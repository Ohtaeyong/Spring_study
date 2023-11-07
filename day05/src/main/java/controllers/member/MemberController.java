package controllers.member;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import models.member.JoinService;
import models.member.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    //@Autowired
    private final JoinValidator joinValidator; // 생성자를 통해 초기화 -> @RequiredArgsConstructor -> final추가
    private final JoinService joinService;
    private final LoginValidator loginValidator;
    private final LoginService loginService;

    @GetMapping("/join") // /member/join
    public String join(@ModelAttribute RequestJoin join) { // GET방식일때도 Model(속성추가)주입 // th:field를 쓰려면 추가

//        RequestJoin requestJoin = new RequestJoin();
//        model.addAttribute("requestJoin", requestJoin); // 명칭만 앞에 소문자, 어노테이션으로

        return "member/join";
    }

    @PostMapping("/join")
    //@RequestMapping(method = {RequestMethod.POST, RequestMethod.PATCH}, path ="/member/join")
    public String joinPs(@Valid RequestJoin join, Errors errors /*Model model*/) {

        //model.addAttribute("requestJoin", join); 지워도 join.html에서 자동 추가

        //joinValidator.validate(join, errors);
        /*
        if (errors.hasErrors()) {
            // 검증 실패시 유입
            return "member/join";
        }
*/
        // 검증 성공 -> 회원가입 처리

        joinService.join(join); // 위에 private final JoinService joinService; 추가 후 추가

        return "redirect:/member/login";
    }

    @GetMapping("/login") // /member/login
    public String login(@ModelAttribute RequestLogin form, @CookieValue(name="saveId", required = false) String userId) {

        if (userId != null) {
            form.setUserId(userId);
            form.setSaveId(true);
        }

        return "member/login";
    }

    @PostMapping("/login")
    public String loginPs(@Valid RequestLogin form, Errors errors) {

        loginValidator.validate(form, errors);

        if (errors.hasErrors()) { // 에러가 한개라도 검출이 되면
            return "member/login";
        }

        // 유효성 검사 성공 -> 로그인 처리
        loginService.login(form);

        return "redirect:/";

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/member/login";
    }

    // MemberController 한정 예외 페이지 처리
    /*
    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, Model model) { // Bad, Duplicate 한꺼번에 하려면 Exception으로 하는게 나음
        e.printStackTrace();
        model.addAttribute("message", e.getMessage());
        return "error/common";
    }
    */

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.setValidator(joinValidator);
//    }

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
