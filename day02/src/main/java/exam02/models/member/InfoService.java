package exam02.models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 스캔범위를 알려주는 어노테이션
public class InfoService {

    @Autowired
    private MemberDao memberDao;

    public void print() {
        List<Member> members = memberDao.gets();
        members.stream().forEach(System.out::println);
    }

}
