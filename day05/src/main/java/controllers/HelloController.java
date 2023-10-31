package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name="nm", defaultValue = "이름없음") String name, int num1, boolean agree) { // required = false 이면 하나만 써도 오류는 나지 않음, defaultValue로 기본값 설정 가능
        System.out.printf("name=%s, num1=%d, agree=%s%n", name, num1, agree); // 형변환 필요없이 알아서 주입 (변수명이 동일 할때만)

        return "hello"; // /WEB-INF/templates/hello.jsp
    }

    /*
    @GetMapping("/hello")
    public ModelAndView hello() { // model = data

        ModelAndView mv = new ModelAndView(); // 밑의 두가지 값이 들어있는것이 ModelAndView
        mv.addObject("message", "반갑습니다."); // 데이터
        mv.setViewName("hello"); // 템플릿 정보에 대한 경로

        return mv; // 주로 위에걸 씀
    }
     */
}
