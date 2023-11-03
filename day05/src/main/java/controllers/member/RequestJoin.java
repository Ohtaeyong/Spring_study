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

    //private String[] hobby; // 취미
    //private List<String> hobby; // 배열로 해도 되고 collection으로 해도됨

    private Adress addr; // addr.address, addr.zipcode
}
