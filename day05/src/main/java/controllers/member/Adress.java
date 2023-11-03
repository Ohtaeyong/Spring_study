package controllers.member;

import lombok.Data;

@Data
public class Adress {

    private String zipcode; // 우편번호
    private String address;
    private String addressSub; // 나머지 주소
}
