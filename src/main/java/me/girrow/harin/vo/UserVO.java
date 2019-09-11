package me.girrow.harin.vo;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class UserVO {
	
	private String no;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	
	private String created;
	
}
