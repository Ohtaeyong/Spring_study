package exam03.config;

import exam03.models.member.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppCtx2.class)
public class AppCtx1 {

    @Bean
    //@Qualifier("mDao")
    public MemberDao memberDao() {
        return new MemberDao();
    }

    /*
    @Bean
    public MemberDao memberDao2() { // 스프링6에서는 오류발생 X // 두개중에 뭘 주입해야할지 헷갈림
        return new MemberDao();
    }
     */
}
