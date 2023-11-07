package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DBConfig {

    @Value("${enviroment}")
    private String env;

    @Value("${db.username.dev}")
    private String usernameDev;

    @Value("${db.password.dev}")
    private String passwordDev;

    @Value("${db.username.prod}")
    private String usernameProd; // String밖에안됨

    @Value("${db.password.prod}")
    private String passwordProd;

    @Bean(destroyMethod = "close") // 알아서 소멸될 때 자원해제
    public DataSource dataSource() {

        String username = env.equals("prod") ? usernameProd : usernameDev;
        String password = env.equals("prod") ? passwordProd : passwordDev;

        DataSource ds = new DataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        ds.setUsername(username);
        ds.setPassword(password);

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
