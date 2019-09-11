package me.girrow.harin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import me.girrow.harin.vo.PostVO;

@Mapper
public interface PostMapper {
	public List<PostVO> selectAllData();
}
