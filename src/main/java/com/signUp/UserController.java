package com.signUp;

import com.signUp.domain.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.signUp.domain.User;
import com.signUp.domain.UserRepository;

@Controller
@RequestMapping("/users") // 시작위치
public class UserController {
	
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String login(String userId, String password, HttpSession session) {
		User user = userRepository.findByUserId(userId);
		if(user == null) {
			return "redirect:/users/loginForm";
		}
		if(!password.equals(user.getPassword())) {
			return "redirect:/users/loginForm";
		}
		session.setAttribute("user", user);
		return "redirect:/";
	}
	
	@GetMapping("/form")
	public String form() {
		return "/user/form";
	}
	
	@GetMapping("{id}/form")
	public String updateForm(@PathVariable Long id, Model model) { //URL 변수를 얻어올수 있음
		User user = userRepository.findById(id).get();
		model.addAttribute("user", user);					//optional 공부필요
		
		return "/user/updateForm";
	}

	@PutMapping("{id}") //put의 경우 데이터 수정을 한다 라는 규칙, delete 등 사용가능
	public String update(@PathVariable Long id, User updateUser) { //URL 변수를 얻어올수 있음
		User user = userRepository.findById(id).get();
		user.update(updateUser);
		userRepository.save(user);
		return "redirect:/users";
	}
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("") // users가 들어가면 회원가입-규칙
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
 