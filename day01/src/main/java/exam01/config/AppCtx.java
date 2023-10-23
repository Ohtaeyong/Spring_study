package exam01.config;

import exam01.Greet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

    @Bean // 스프링이 관리할 객체임을 알려줌
    public Greet greet() {
        return new Greet();
    }
}
