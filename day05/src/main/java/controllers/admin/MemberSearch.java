package controllers.admin;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class MemberSearch {

    @DateTimeFormat(pattern = "yyyy.MM.dd") // ex) 2023-11-01 ~ 2023-11-06 -> -만 오류X @DateTimeFormat를 통해 알려줌
    private LocalDate sdate;

    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private LocalDate edate;
}
