package SpringBootwithReact;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloController {
	
	@GetMapping("api/hello")
	
	public String sayHello() {
	
	return "{\"message\": \"Good Morning from Spring Boot !\"} ";
	
	}
	
}
