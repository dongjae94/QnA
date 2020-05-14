package com.signUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.signUp.domain.User;
import com.signUp.domain.UserRepository;

@Controller
@RequestMapping("/users") // 시작위치
public class UserController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("") // users가 들어가면 회원가입-규
	public String create(User user) {
		userRepository.save(user);
		return "redirect:/users"; // redirect =클라이언트로 돌아갔다가 다시 list메소드 실행
	}
	
	@GetMapping("") // redirect 응답
	public String list(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "/user/list"; //    template - user/list.html로 정보 전
	}
}
 