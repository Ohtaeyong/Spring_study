package controllers.member;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestJoin {
    @NotBlank
    @Size(min = 6)
    private String userId;

    @NotBlank
    @Size(min = 8, max = 16)
    private String userPw;

    @NotBlank
    private String confirmUserPw;

    @NotBlank
    private String userNm;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String mobile;

    @AssertTrue
    private boolean agree;
}
