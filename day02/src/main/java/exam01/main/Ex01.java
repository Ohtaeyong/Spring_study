package exam01.main;

import exam01.Greet;
import exam01.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Greet g1 = ctx.getBean("greet", Greet.class); // greet(@Bean 메서드명)
        g1.hello("이이름");

        Greet g2 = ctx.getBean("greet", Greet.class);
        System.out.println(g1 == g2); // true -> 주소값이 같다 -> 싱글톤 패턴

        ctx.close();
    }
}
