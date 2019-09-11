package me.girrow.harin.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.girrow.harin.service.BoardService;
import me.girrow.harin.service.LoginService;
import me.girrow.harin.util.HttpUtil;
import me.girrow.harin.vo.PostVO;
import me.girrow.harin.vo.UserVO;



@RestController
public class DataController {
	
	@Autowired
	LoginService lsi;
	@Autowired
	BoardService bsi;
	
	//bindResult 예외처리 아직 안함
	@PostMapping("/checkUser")
	public HashMap<String,Object> checkUserInfo(@Valid UserVO uv,HttpSession session){
		//bindResult 예외처리 해주기
		HashMap<String,Object> resultMap = lsi.checkUserIsRight(uv, session);
		
		return resultMap; 
	}
	
	@PostMapping("/addUserInfo")
	public HashMap<String,Object> addUserInfo(@Valid UserVO uv,HttpSession session){
		//bindResult 예외처리 해주기
		HashMap<String,Object> resultMap = lsi.addUserInfo(uv);
		
		return resultMap; 
	}
	
	
	//Session 값 가져오기
	@PostMapping("/getUserSession")
	public HashMap<String,Object> getInfo(HttpSession session){
		HashMap<String,Object> resultMap = null;
		if(session.getAttribute("username") == null) {
			resultMap=HttpUtil.put(202, "");
		}else {
			resultMap=HttpUtil.put(200, session.getAttribute("username").toString());
		}
		return resultMap;
	}
	
	@PostMapping("/getBoardList")
	public HashMap<String, Object> getBoardList() {
		HashMap<String, Object> resultMap = bsi.getBoardList();
		return resultMap;
	}
	
	@PostMapping("/getOneView/{key}")
	public PostVO getMenu(@PathVariable String key) {
		return bsi.getMenu(key);
	}
	

	
	

}
