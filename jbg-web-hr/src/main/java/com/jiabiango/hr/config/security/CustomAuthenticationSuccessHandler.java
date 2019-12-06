package com.jiabiango.hr.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;

import com.jiabiango.hr.config.KaptchaConfig;

public class CustomAuthenticationSuccessHandler extends ForwardAuthenticationSuccessHandler {

    public CustomAuthenticationSuccessHandler(String forwardUrl) {
        super(forwardUrl);
    }
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        request.getSession().removeAttribute(KaptchaConfig.KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(KaptchaConfig.KAPTCHA_SESSION_DATE);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
