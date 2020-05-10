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
	
	@PostMapping("/user/create")
	public String create(User user) {
		System.out.print(user);
		users.add(user);
		userRepository.save(user);
		return "redirect:/list"; // redirect =클라이언트로 돌아갔다가 다시 list메소드 실행
	}
	
	@GetMapping("/list") // redirect 응답
	public String list(Model model) {
		model.addAttribute("users", users);
		return "list"; //templates - list.html로 정보 전
	}
}
 