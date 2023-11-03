package controllers.member;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record RequestLogin( // 스프링 6에서만 가능 컴파일버전 17이상에서만
        @NotBlank
        String userId,

        @NotBlank
        String userPw,

        Boolean saveId
) { }
