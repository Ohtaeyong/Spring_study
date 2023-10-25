package exam04.config;

import exam04.models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
/*
@ComponentScan(basePackages = "exam04.models",
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes=ManualBean.class))
 */
@ComponentScan(basePackages = "exam04.models",
    excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MemberDao.class)) // 필터명을 직접 명시
public class AppCtx {

//    @Bean
//    public MemberDao memberDao() { // 수동 등록빈은 우선순위가 먼저임
//        System.out.println("여기?");
//        return new MemberDao();
//    }
}
