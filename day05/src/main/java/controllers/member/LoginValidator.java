package controllers.member;

import lombok.RequiredArgsConstructor;
import models.member.Member;
import models.member.MemberDao;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class LoginValidator implements Validator {

    private final MemberDao memberDao;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestLogin.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        RequestLogin form = (RequestLogin) target;

        /*
        1. 아이디가 존재 하는지 체크
        2. 회원을 조회 -> 비밀번호 검증
        */

        String userId = form.getUserId();
        String userPw = form.getUserPw();

        Member member = null;
        if (userId != null && !userId.isBlank()) {
            member = memberDao.get(userId);
            if (member == null) {
                //errors.rejectValue("userId", "NotFound");
                errors.reject("NotFound.userId"); // 아이디인지 비밀번호인지 특정하지 못하도록
            }
        }

        if (member != null && userPw != null && !userPw.isBlank()) {
            boolean matched = BCrypt.checkpw(userPw, member.getUserPw());
            if (!matched) {
                //errors.rejectValue("userPw", "Incorrect");
                errors.reject("Incorrect.userPw");
            }
        }
    }
}
