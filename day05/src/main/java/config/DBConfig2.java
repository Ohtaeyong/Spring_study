package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DBConfig2 {

    @Profile("dev")
    @Configuration
    public static class DbDevConfig { // Dev

        @Bean(destroyMethod = "close") // 알아서 소멸될 때 자원해제
        public DataSource dataSource() {

            System.out.println("dev profile!!");

            DataSource ds = new DataSource();
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
            ds.setUsername("spring6");
            ds.setPassword("_aA123456");

            ds.setInitialSize(2);
            ds.setMaxActive(10);
            ds.setTestWhileIdle(true);

            return ds;
        }

        @Bean
        public JdbcTemplate jdbcTemplate() {
            return new JdbcTemplate(dataSource());
        }
    }

    @Profile("prod")
    @Configuration
    public static class DbProdConfig { // Prod

        @Bean(destroyMethod = "close") // 알아서 소멸될 때 자원해제
        public DataSource dataSource() {

            System.out.println("prod profile!!");

            DataSource ds = new DataSource();
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
            ds.setUsername("spring6");
            ds.setPassword("_aA123456");

            ds.setInitialSize(2);
            ds.setMaxActive(10);
            ds.setTestWhileIdle(true);

            return ds;
        }

        @Bean
        public JdbcTemplate jdbcTemplate() {
            return new JdbcTemplate(dataSource());
        }
    }
}
