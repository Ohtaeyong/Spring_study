package controllers.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join") // /member/join
    public String join() {

        return "member/join";
    }

    @PostMapping("/join")
    //@RequestMapping(method = {RequestMethod.POST, RequestMethod.PATCH}, path ="/member/join")
    public String joinPs() {

        System.out.println("유입?");

        return "redirect:/member/login";
    }

    @GetMapping("/login") // /member/login
    public String login() {

        return "member/login";
    }

    @PostMapping("/login")
    public String loginPs() {

        return "member/login";
    }

    /*
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/member/login")
    public String login(RequestLogin form, HttpServletResponse response) {
        System.out.println(form);
        System.out.println(response);
        System.out.println(request.getParameter("userId"));
        return "member/login";
    }


    @GetMapping("/member/join") //1101 15:39 추가
    public String join(Model model) {
        String[] addCss = {"member/test1", "member/test2"};
        List<String> addScript = Arrays.asList("member/script1", "member/script2");

        model.addAttribute("addCss", addCss);
        model.addAttribute("addScript", addScript);
        model.addAttribute("pageTitle", "회원가입");

        return "member/join";
    }

    @GetMapping("/member/login")
    public String login(Model model) {

        model.addAttribute("userId", "user99");
        model.addAttribute("userPw", "비밀번호");

        return "member/login"; // login.html
    }

    @GetMapping("/member/info")
    public String info(Model model) {

        Member member = Member.builder()
                .userNo(1L)
                .userId("<h1>user01</h1>")
                .userPw("123456")
                .userNm("사용자01")
                .email("user01@test.org")
                .mobile("010-0000-0000")
                .build();

        model.addAttribute("member", member);

        return "member/info";
    }

    // 11-01 시작(th:each)
    @GetMapping("/member/list")
    public String members(Model model) {

        List<Member> members = IntStream.rangeClosed(1, 10).mapToObj(this::addMember).toList(); // map : 검색과 변환
        model.addAttribute("members", members);

        return "member/list";
    }

    private Member addMember(int i) {
        return Member.builder()
                .userNo(i * 10000)
                .userId("user" + i)
                .userPw("123456")
                .userNm("사용자" + i)
                .email("user"+i+"@test.org")
                .regDt(LocalDateTime.now())
                .build();
    }
     */

}
