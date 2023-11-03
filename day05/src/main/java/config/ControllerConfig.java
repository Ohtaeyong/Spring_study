package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"controllers", "models"}) // 자동스캔범위
public class ControllerConfig {

//    @Bean
//    public HelloController helloController() {
//        return new HelloController();
//    }
}
