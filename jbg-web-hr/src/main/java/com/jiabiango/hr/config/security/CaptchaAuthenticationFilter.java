package com.jiabiango.hr.config.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jiabiango.hr.config.KaptchaConfig;
import com.jiabiango.hr.exception.CaptchaIncorrectException;

public class CaptchaAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    
    public static final String CAPTCHA_PARAMETER = "captcha";
    
	private boolean postOnly = true;
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("不支持"+request.getMethod()+"方法认证");
        }
        String username = obtainUsername(request);
        String password = obtainPassword(request);
    

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        username = username.trim();

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

        setDetails(request, authRequest);
	 
        return this.getAuthenticationManager().authenticate(authRequest);
	}
	
    private String obtainCaptcha(HttpServletRequest request) {
        return request.getParameter(CAPTCHA_PARAMETER);
    }
}
