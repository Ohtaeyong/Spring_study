package models.member;

import controllers.member.RequestJoin;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final JoinValidator validator;
    private final MemberDao memberDao;

//    public JoinService(Validator validator, MemberDao memberDao) {
//        this.validator = validator;
//        this.memberDao = memberDao;
//    } // 생성자 지우고 위에 @RequiredArgsConstructor 추가

    public void join(RequestJoin form) {

        validator.check(form);

        Member member = new ModelMapper().map(form, Member.class); // build() 쓸필요없음

        memberDao.register(member);
    }

    // 1103 14:39주석
//    public void join(HttpServletRequest request) {
//        String _agree = Objects.requireNonNullElse(request.getParameter("agree"), "false");
//        boolean agree = _agree.equals("true") ? true : false;
//
//        Member member = Member.builder()
//                .userId(request.getParameter("userId"))
//                .userPw(request.getParameter("userPw"))
//                .confirmUserPw(request.getParameter("confirmUserPw"))
//                .email(request.getParameter("email"))
//                .userNm(request.getParameter("userNm"))
//                .agree(agree)
//                .build();
//        join(member);
//    }
}
