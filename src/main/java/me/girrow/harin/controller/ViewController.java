package me.girrow.harin.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.girrow.harin.service.BoardService;
import me.girrow.harin.vo.PostVO;

@Controller
public class ViewController {
	@Autowired
	BoardService bsi;
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
	
	@GetMapping("/create")
	public String createView() {
		return "board/boardCreate";
	}
	
	@GetMapping("/board")
	public String boardView(HttpSession session,HttpServletRequest req) {
		if(req.getAttribute("rsData")!=null) {
			System.out.println("DATA : "+req.getAttribute("rsData"));
		}
		
		if(session.getAttribute("username")!=null) {
			return "board";
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/detail/{key}")
	public String detailView(@PathVariable String key) {
		return "board/boardDetail";
	}
	@GetMapping("/update/{key}")
	public String updateView(@PathVariable String key) {
		return "board/boardUpdate";
	}
	
	@PostMapping("/board/{key}")
	public String boardCUD(PostVO pv,
										   @PathVariable String key,
										   HttpSession session,
										   HttpServletRequest req
//										   RedirectAttributes ra
										   ){
		HashMap<String,Object> resultMap = null;
		req.setAttribute("rsData", bsi.doThat(session, key, pv));
//		ra.addFlashAttribute("rsData",bsi.doThat(session,key,pv));
		return "redirect:/board";
	}
}
