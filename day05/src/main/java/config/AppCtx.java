package config;

import org.apache.tomcat.jdbc.pool.DataSource; // DataSource 추가할때 잘 볼것
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
public class AppCtx {

    @Bean(destroyMethod = "close") // 알아서 외부에 정의된 자원 해제
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        // 데이터 베이스 연결 설정 S
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        ds.setUsername("spring6");
        ds.setPassword("_aA123456");
        // 데이터 베이스 연결 설정 E

        // 커넥션 풀 설정 S
        ds.setInitialSize(2);
        ds.setMaxActive(10); // 최대 활성화 개수는 10개를 넘지 않는다.
        ds.setTestWhileIdle(true); // 기본값은 false // 연결 체크
        ds.setTimeBetweenEvictionRunsMillis(3000); // 5초가 기본값 // 3초마다 연결 상태 확인
        ds.setMinEvictableIdleTimeMillis(30 * 1000); // 1분이 되면 연결객체 제거(기본값) // 30초설정
        // 커넥션 풀 설정 E

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() { // 이것을 가지고 쿼리 수행
        return new JdbcTemplate(dataSource()); // 위쪽의 메서드 주입 // Ex04로 이동
    }
}
