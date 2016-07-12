package configtest;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "net.tinvention.webcrud.spring.model, net.tinvention.webcrud.spring.service, net.tinvention.webcrud.spring.dao, net.tinvention.webcrud.spring.util")
public class WebAppConfigTest {


	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/testesercitazionespring");
		dataSource.setUsername("root");
		dataSource.setPassword("1111");
		return dataSource;
	}

	@Bean
	public JdbcTemplate template(DataSource ds) {
		return new JdbcTemplate(ds);
	}
}