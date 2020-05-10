package com.signUp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.signUp.domain.User;
import com.signUp.domain.UserRepository;

@Controller
public class UserController {
	private List<User> users= new ArrayList<User>();
	
	@Autowired
	private UserRepository userRepository;
	@PostMapping("/create")
	public String create(User user) {
		System.out.print(user);
		users.add(user);
		userRepository.save(user);
		
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("users", users);
		return "list";
	}
}
 