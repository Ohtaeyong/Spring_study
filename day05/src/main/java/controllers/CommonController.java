package controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("controllers") // 정의하지 않으면 전 범위 // controllers를 포함한 범위
public class CommonController {

    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, Model model) {
        e.printStackTrace();
        model.addAttribute("message", e.getMessage());
        return "error/common";
    }
}
