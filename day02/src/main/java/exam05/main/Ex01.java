package exam05.main;

import exam05.config.*;
import exam05.Message;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        // 객체 생성 -> 의존성 주입 -> 초기화
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        ctx.close(); // 소멸됨(destroy 호출)
    }
}
