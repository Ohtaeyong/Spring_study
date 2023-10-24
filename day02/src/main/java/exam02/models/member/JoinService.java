package exam02.models.member;

import exam02.commons.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JoinService {

    @Autowired
    private Validator<Member> validator;

    @Autowired
    private MemberDao memberDao;


    public void join(Member member) {

        validator.check(member);

        memberDao.register(member);
    }

}
