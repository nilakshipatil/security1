package demo.security1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@Component
public class MyBusinessLogic {
	
	@Secured(value="ROLE_admin")
	public String m1(){
		System.out.println("In m1 of MyBusinessLogic ");
		return "Output of m1 processing";
	}
	
	@Secured(value="ROLE_stduser")
	public String m2(){
		System.out.println("In m2 of MyBusinessLogic ");
		return "Output of m2 processing";
	}
}
