package models.member;

import lombok.*;

import java.time.LocalDateTime;

@Builder @Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private long userNo;
    private String userId;
    private String userPw;
    //private String confirmUserPw;
    private String userNm;
    private String email;
    private String mobile;
    //private boolean agree; // 약관 동의
    private LocalDateTime regDt; // 가입일시
    private LocalDateTime modDt;
}
