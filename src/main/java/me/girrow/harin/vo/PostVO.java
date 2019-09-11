package me.girrow.harin.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class PostVO {
	private String no;
	private String title;
	private String content;
	private String writer;
	private String created;
}
