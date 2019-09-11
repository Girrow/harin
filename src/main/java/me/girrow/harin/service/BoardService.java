package me.girrow.harin.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.girrow.harin.mapper.PostMapper;
import me.girrow.harin.util.HttpUtil;
import me.girrow.harin.vo.PostVO;

@Service
public class BoardService {

	@Autowired
	PostMapper pm;
	public PostVO getMenu(String key) {
		return pm.selectOneData(key);
	}
	
	public HashMap<String, Object> getBoardList() {
		HashMap<String, Object> resultMap = null;
		List<PostVO> list = pm.selectAllData();
		if (list.size() > 0) {
			resultMap = HttpUtil.put(200, "데이터 가져오기 성공");
			resultMap.put("results", list);
		} else {
			resultMap = HttpUtil.put(202, "데이터 가져오기 실패");
		}
		return resultMap;
	}

	public HashMap<String, Object> doThat(HttpSession session, String key, PostVO pv) {
		pv.setWriter(session.getAttribute("username").toString());
		HashMap<String, Object> resultMap = null;
		int result = -1;
		switch (key) {
		case "create":
			result = pm.create(pv);
			break;
		case "update":
			result = pm.update(pv);
			break;
		case "delete":
			result = pm.delete(pv);
			break;
		default:
			System.out.println("오류");
			break;
		}
		
		if(result > 0) {
			resultMap = HttpUtil.put(200, key+" 성공");
		}else {
			resultMap = HttpUtil.put(202, key+" 오류");
		}
		return resultMap;
	}
}
