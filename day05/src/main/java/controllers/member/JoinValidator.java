package controllers.member;

import commons.MobileValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class JoinValidator implements Validator, MobileValidator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestJoin.class); // 검증하고자하는 command의 클래스
    }

    @Override
    public void validate(Object target, Errors errors) {
        RequestJoin form = (RequestJoin)target;

        /*
        추가 검증 부분
        1. 아이디 중복 여부 - 중복 가입X
        2. 비밀번호, 비밀번호 확인 일치 여부
        3. 휴대전화번호(필수 X) -> 입력되면 형식 체크
        */

        String userId = form.getUserId();
        String userPw = form.getUserPw();
        String confirmUserPw = form.getConfirmUserPw();
        String mobile = form.getMobile();

        // 비밀번호, 비밀번호 확인 일치 여부
        if (userPw != null && !userPw.isBlank() && confirmUserPw != null && !confirmUserPw.isBlank()
            && !userPw.equals(confirmUserPw)) {

            errors.rejectValue("confirmUserPw", "Mismatch");
        }

        // 휴대전화번호(필수 X) -> 입력되면 형식 체크
        if (mobile != null && !mobile.isBlank() && !checkMobile(mobile)) {
            errors.rejectValue("mobile", "Mobile");
        }



//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "Required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPw", "Required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmUserPw", "Required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userNm", "Required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile", "Required");

        // 필수 항목 검증(userId, userPw, confirmUserPw, userNm, email) -> 번거롭고 잘 쓰지 않음
//        String userId = form.getUserId();
//        String userPw = form.getUserPw();
//        String confirmUserPw = form.getConfirmUserPw();
//        String userNm = form.getUserNm();
//        String email = form.getEmail();
//        String mobile = form.getMobile();
//
//        if (userId == null || userId.isBlank()) {
//            errors.rejectValue("userId", "Required", "아이디를 입력하세요");
//        }
//
//        if (userPw == null || userPw.isBlank()) {
//            errors.rejectValue("userPw", "Required"); // 기본메시지를 지워도 동작함
//        }
//
//        if (confirmUserPw == null || confirmUserPw.isBlank()) {
//            errors.rejectValue("confirmUserPw", "Required", "비밀번호를 확인하세요");
//        }
//
//        if (userNm == null || userNm.isBlank()) {
//            errors.rejectValue("userNm", "Required", "회원명을 입력하세요");
//        }
//
//        if (email == null || email.isBlank()) {
//            errors.rejectValue("email", "Required", "이메일을 입력하세요");
//        }
//
//        if (mobile == null || mobile.isBlank()) {
//            errors.rejectValue("mobile", "Required", "전화번호를 입력하세요");
//        }
    }
}
