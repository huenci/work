package com.jiabiango.hr.admin.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Producer;
import com.jiabiango.hr.config.KaptchaConfig;

@Controller
@RequestMapping("/admin")
public class CaptchaController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private Producer kaptchaProducer;

	@RequestMapping("/captcha")
	public void generate(HttpSession session, HttpServletResponse response){
	    String captcha = kaptchaProducer.createText();
		session.setAttribute(KaptchaConfig.KAPTCHA_SESSION_KEY, captcha);
		session.setAttribute(KaptchaConfig.KAPTCHA_SESSION_DATE, new Date());
		logger.debug("生成验证码为："+ captcha);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedImage bi = kaptchaProducer.createImage(captcha);
        try(ServletOutputStream out = response.getOutputStream()) {
            ImageIO.write(bi, "jpg", baos);
			baos.writeTo(out);
			out.flush();
        } catch (IOException e) {
            logger.error("验证码图片生成失败");
        }
	}
}
