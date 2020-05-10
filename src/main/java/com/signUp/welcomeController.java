package com.signUp;
import com.signUp.domain.User;
import com.signUp.domain.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class welcomeController {
	@GetMapping("/helloworld")
	public String welcome() {
		return "list";
	}
}
