package me.girrow.harin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import me.girrow.harin.vo.PostVO;

@Mapper
public interface PostMapper {
	public List<PostVO> selectAllData();
	public PostVO selectOneData(String key);
	public int create(PostVO pv);
	public int update(PostVO pv);
	public int delete(PostVO pv);
}
