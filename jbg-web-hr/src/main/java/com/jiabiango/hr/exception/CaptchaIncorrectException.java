package com.jiabiango.hr.exception;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CaptchaIncorrectException extends AuthenticationException{
	private static final long serialVersionUID = 3128488184962718521L;
	
	private Authentication authentication;
	
	public CaptchaIncorrectException(String message){
		super(message);
	}

	public Authentication getAuthentication() {
		return authentication;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}
}
