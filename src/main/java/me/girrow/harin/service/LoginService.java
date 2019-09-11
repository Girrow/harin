package me.girrow.harin.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.girrow.harin.mapper.UserMapper;
import me.girrow.harin.util.HttpUtil;
import me.girrow.harin.vo.UserVO;

@Service
public class LoginService {
	
	@Autowired
	UserMapper um;
	
	//로그인 화인
	public HashMap<String, Object> checkUserIsRight(UserVO uv, HttpSession session) {
		HashMap<String,Object> resultMap =null;
		int checkUserIdIsRight=-1;
		checkUserIdIsRight =um.checkUserInfo(uv);
		if(checkUserIdIsRight == 1) {
			// 값 조회 성공시
			resultMap=HttpUtil.put(200, "로그인이 성공하였습니다.");
			session.setAttribute("username", uv.getUsername());
		}else {
			// 값 조회 실패시
			resultMap=HttpUtil.put(202, "로그인 정보값이 올바르지 않습니다.");
		}
		
		return resultMap;
	}
	
	//사용자 회원가입
	public HashMap<String,Object> addUserInfo(UserVO uv){
		HashMap<String,Object> resultMap = null;
		int checkUserIsAlreadyHave=-1;
		int addUserId=-1;
		try {
			checkUserIsAlreadyHave = um.checkUserAlreadyHave(uv);
			if(checkUserIsAlreadyHave > 0) {
				resultMap=HttpUtil.put(203, "이미 있는 아이디입니다.");
				return resultMap;
			}else {
				addUserId=um.addUser(uv);
				if(addUserId > 0) {
					resultMap=HttpUtil.put(200, "회원가입 완료! 로그인 실행해주세요");
				}else {
					resultMap=HttpUtil.put(203, "회원가입 오류 발생! 다시한번 시도해주세요");
				}
			}
		} catch (Exception e) {
			resultMap=HttpUtil.put(204, "로그인 Error");
		}
		
		return resultMap;
	}
	
	
}
