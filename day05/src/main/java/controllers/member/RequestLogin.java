package controllers.member;

public record RequestLogin( // 스프링 6에서만 가능 컴파일버전 17이상에서만
        String userId,
        String userPw,
        boolean saveId
) { }
