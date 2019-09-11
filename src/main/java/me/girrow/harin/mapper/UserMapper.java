package me.girrow.harin.mapper;

import org.apache.ibatis.annotations.Mapper;

import me.girrow.harin.vo.UserVO;

@Mapper
public interface UserMapper {
	public int checkUserInfo(UserVO uv);
	public int checkUserAlreadyHave(UserVO uv);
	public int addUser(UserVO uv);
}
