package com.signUp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class welcomeController {
	@GetMapping("/helloworld")
	public String welcome() {
		return "list";
	}
}
