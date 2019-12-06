package com.jiabiango.hr.config.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
	private final String forwardUrl;
	
	public CustomAccessDeniedHandler(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}

    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException)
            throws IOException, ServletException {
        //可放入异常信息到request里
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
        dispatcher.forward(request, response);
    }

}
