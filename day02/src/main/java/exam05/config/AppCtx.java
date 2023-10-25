package exam05.config;

import exam05.Message;
import exam05.Message2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppCtx {

    @Bean
    @Scope("prototype") // 매번 가져올 때마다 다른 객체를 가져옴
    public Message message() {
        return new Message();
    }

    @Bean(initMethod = "init", destroyMethod = "close") // 제한조건은 매개변수가 있으면 안됨 // 주로 많이 쓰는게 DB
    public Message2 message2() {
        return new Message2();
    }
}
