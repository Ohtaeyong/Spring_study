package exam05.main;

import exam05.config.AppCtx;
import exam05.Message;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex02 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Message m1 = ctx.getBean(Message.class);
        Message m2 = ctx.getBean(Message.class); // false

        System.out.println(m1 == m2);

        ctx.close();
    }
}
