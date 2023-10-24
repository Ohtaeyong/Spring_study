package exam02.config;

import exam02.models.member.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
    /*
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public JoinValidator joinValidator() { // 생성자 형태가 아닌 setter형태를 통한 주입이기 때문에
        JoinValidator joinValidator = new JoinValidator();
        joinValidator.setMemberDao(memberDao());

        return joinValidator;
    }



    @Bean
    public JoinService joinService() {
        return new JoinService(joinValidator(), memberDao());
    }



    @Bean
    public InfoService infoService() {
        return new InfoService(memberDao());
    }
     */
}