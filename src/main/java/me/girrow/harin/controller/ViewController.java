package me.girrow.harin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import net.sf.json.JSONObject;

@Controller
public class ViewController {
	/**
	 * 사용자를 처음 맞이할 화면
	 * @author hairn 
	 */
	@GetMapping("/")
	public String homeView() {
		return "home";
	}
	
	@GetMapping("/login")
	public String loginView() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logoutView(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/board")
	public String boardView(HttpSession session) {
		if(session.getAttribute("username")!=null) {
			return "board";
		}else {
			return "redirect:/";
		}
	}
}
