package demo.security1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;

@Configuration
@ComponentScan(basePackages="demo.security1")
public class Application {

	public static void main(String[] args) {
			
			ApplicationContext ctx= new AnnotationConfigApplicationContext(Application.class);
			MyBusinessLogic logic= ctx.getBean(MyBusinessLogic.class);
			
			SecurityContext Sectx=new SecurityContextImpl();
			
			Authentication auth=new UsernamePasswordAuthenticationToken("nilakshi", "admin");
			Sectx.setAuthentication(auth);
			SecurityContextHolder.setContext(Sectx);
			
			try{
				logic.m1();
				
			}
			catch(Exception e){
					System.out.println("problem in invocking m1"+e);
			}
			try{
				logic.m2();
				
			}
			catch(Exception e){
				System.out.println("problem in invocking m2"+e);
		}
	}
}
