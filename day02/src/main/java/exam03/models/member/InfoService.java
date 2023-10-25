package exam03.models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


public class InfoService {

    //@Autowired
    //private MemberDao memberDao;

    @Autowired
    private Optional<MemberDao> opt;

    //private DateTimeFormatter formatter;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");

    @Autowired(required = false) // 원래 @Autowired는 기본값이 true -> 의존성 필수
    //@Autowired
    public void setFormatter(@Nullable DateTimeFormatter formatter) {
        System.out.println("유입?"); // @Autowired(required = false)로 쓰면 출력X
        System.out.println(formatter);

        this.formatter = formatter;
    }

    public void print() {
        MemberDao memberDao = opt.get();
        List<Member> members = memberDao.gets();
        members.stream().map(this::toConvert).forEach(System.out::println);
    }

    private Member toConvert(Member member) {
        if (formatter == null) { // 주입이 되지 않으면
            return member;
        }
        String regDtStr = formatter.format(member.getRegDt());
        member.setRegDtStr(regDtStr);

        return member;
    }
}
