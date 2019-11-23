
package venu.ractise.spring.rest;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan
public class EmployeeDataSourceConfig {

	private String drivaerName = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String userName = "SYSTEM";
	private String password = "India123";

	
	
	@Bean
	public DataSource getDataSource() throws SQLException {

		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(drivaerName);
		dataSourceBuilder.url(url);
		dataSourceBuilder.username(userName);
		dataSourceBuilder.password(password);

		return dataSourceBuilder.build();
	}
	
	@Bean
	public JdbcTemplate getJdbCTemplate(DataSource source) {
		return new JdbcTemplate(source) ;
	}

}
