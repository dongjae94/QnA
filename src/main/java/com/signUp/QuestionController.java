package com.signUp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.signUp.domain.*;


@Controller
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository; //spring에서 관리하는 repository를 사용하겠다는 의미
	
	@GetMapping("/form")
	public String form(HttpSession session, Question q) {
		if(!HttpSessionUtils.isLoginUser(session)) {
			return "/users/loginForm";
		}
		return "/qna/form";
	}
	
	@GetMapping("/{id}")
	public String show(HttpSession session, @PathVariable Long id, Model model) {
		if(!HttpSessionUtils.isLoginUser(session)) {
			return "/users/loginForm";
		}
		model.addAttribute("question", questionRepository.findById(id).get());
		return "/qna/show";
	}
	
	@PostMapping("")
	public String create(String title, String contents, HttpSession session) {
		if(!HttpSessionUtils.isLoginUser(session)) {
			return "/users/loginForm";
		}
		User sessionUser = HttpSessionUtils.getUserFromSession(session);
		
		Question newQuestion = new Question(sessionUser, title, contents);
		questionRepository.save(newQuestion);
		return "redirect:/";
	}
	@GetMapping("/{id}/form")
	public String updateForm(@PathVariable Long id, Model model) {
		model.addAttribute("question", questionRepository.findById(id).get());
		return "/qna/updateForm"; 
	}
	@PutMapping("/{id}")
	public String update(@PathVariable Long id, String title, String contents) {
		Question question = questionRepository.findById(id).get();
		question.update(title, contents);
		questionRepository.save(question);
		
		return String.format("redirect:/questions/%d", id);
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		
		questionRepository.delete(questionRepository.findById(id).get());
		return "redirect:/";
	}
	
	
	
}
