package net.texala.security.web.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestVo {
	@NotBlank
	private String username;

	@NotBlank
	private String password;

}

