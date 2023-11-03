package models.member;

import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
//@Transactional
public class MemberDao {
    //private static Map<String, Member> members = new HashMap<>();

    private final JdbcTemplate jdbcTemplate;
    /*
    public boolean register(Member member) {

        String userPw = BCrypt.hashpw(member.getUserPw(), BCrypt.gensalt(12));
        member.setUserPw(userPw);
        //members.put(member.getUserId(), member);

        String sql = "INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, EMAIL, USER_NM, MOBILE) " +
                " VALUES (SEQ_MEMBER.nextVal, ?, ?, ?, ?, ?)";
        int affectedRows = jdbcTemplate.update(sql, member.getUserId(),
                userPw, member.getEmail(), member.getUserNm(), member.getMobile());

        return affectedRows > 0;
    }
    */

    @Transactional // 연속된 쿼리가 있을 때
    public boolean register(Member member) {
        String userPw = BCrypt.hashpw(member.getUserPw(), BCrypt.gensalt(12));
        String sql = "INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, EMAIL, USER_NM, MOBILE) " +
                " VALUES (SEQ_MEMBER.nextVal, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        int affectedRows = jdbcTemplate.update(con -> {
            PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"USER_NO"});
            pstmt.setString(1, member.getUserId());
            pstmt.setString(2, userPw);
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, member.getUserNm());
            pstmt.setString(5, member.getMobile());

            return pstmt;
        }, keyHolder); // 증감번호 알기(keyHolder)

        if (affectedRows > 0) {
            long userNo = keyHolder.getKey().longValue();
            member.setUserNo(userNo);
        }

        return affectedRows > 0;
    }

    public Member get(String userId) {
        //return members.get(userId);
        try { // 예외 처리(오류가아니라 null값으로)
            String sql = "SELECT * FROM MEMBER WHERE USER_ID = ?";
            Member member = jdbcTemplate.queryForObject(sql, this::mapper, userId); // 데이터 레코드 한개 조회

            return member;
        } catch (RuntimeException e) {

            e.printStackTrace();
            return null;
        }
    }

    public boolean exists(String userId) {
        //return members.containsKey(userId);

        String sql = "SELECT COUNT(*) FROM MEMBER WHERE USER_ID = ?";
        long cnt = jdbcTemplate.queryForObject(sql, long.class, userId);

        return cnt > 0;
    }

//    public static void clearData() {
//        members.clear();
//    }

    public List<Member> gets() {

        String sql = "SELECT * FROM MEMBER ORDER BY REG_DT DESC";

        // FunctionInterface -> 람다
        List<Member> members = jdbcTemplate.query(sql, this::mapper);

        return members;
    }

    private Member mapper(ResultSet rs, int i) throws SQLException {
        return Member.builder()
                .userNo(rs.getLong("USER_NO"))
                .userId(rs.getString("USER_ID"))
                .userPw(rs.getString("USER_PW"))
                .userNm(rs.getString("USER_NM"))
                .email(rs.getString("EMAIL"))
                .mobile(rs.getString("MOBILE"))
                .regDt(rs.getTimestamp("REG_DT").toLocalDateTime())
                .build();
    }
}
