package demo.security1;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
public class SecurityConfig {
	 
		@Autowired
		private DataSource ds;
		
		@Autowired
	     public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        
			/* auth.inMemoryAuthentication().withUser("nilakshi").password("nilakshi").roles("admin")
					.and().withUser("test").password("test").roles("stduser")
					.and().withUser("user1").password("user1").roles("stduser");
				*/	
				auth.jdbcAuthentication().dataSource(ds)
				.usersByUsernameQuery("select username,password,enabled from user where username=?")
				.authoritiesByUsernameQuery("select username,role from roles where username=?");
	     }
	
		@Bean
		public DataSource getdatasource(){
			
			return new DriverManagerDataSource("jdbc:hsqldb:hsql://localhost/","sa","");
			
		}
}
