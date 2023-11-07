package controllers.admin;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminMemberController")
@RequestMapping("/admin/member")
public class MemberController {

    @GetMapping
    public String list(@ModelAttribute @Valid MemberSearch search, Errors errors) { // 에러객체는 커맨드 바로 뒤에
        System.out.println(search);
        return "admin/member/list";
    }

    @GetMapping("/{num}/info/{id}")// {} -> 바뀔 수 있는 부분
    public String info(@PathVariable(name="id", required = false) String userId, @PathVariable Integer num) { // @PathVariable -> Spring5에 추가된 기능
        System.out.println(userId);
        System.out.println(num);

        return "admin/member/info";
    }
}
