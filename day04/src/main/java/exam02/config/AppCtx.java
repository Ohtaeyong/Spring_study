package exam02.config;

import exam02.aopex.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAspectJAutoProxy
public class AppCtx {

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }

    @Bean
    public ProxyCached proxyCached() {
        return new ProxyCached();
    }

    @Bean
    public ProxyCalculator proxyCalculator() {
        return new ProxyCalculator();
    }
}
