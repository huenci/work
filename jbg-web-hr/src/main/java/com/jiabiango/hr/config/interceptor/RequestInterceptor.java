package com.jiabiango.hr.config.interceptor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.jiabiango.hr.util.JsonUtil;

@Component
@Aspect
public class RequestInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

	@Value("${spring.profiles.active}")
	private String active;

	/**
	 * 判断传入参数是否合法
	 * 
	 * @param point
	 * @return
	 * @throws Throwable
	 */
	@SuppressWarnings("rawtypes")
	@Around(value = "execution(* com.jiabiango.hr.*.controller.*.*(..))")
	public Object process(ProceedingJoinPoint point) throws Throwable {
		long start = System.currentTimeMillis();
		Method method = ((MethodSignature) point.getSignature()).getMethod();
		List<Object> logArgs = new ArrayList<>();
		Object returnValue = null;
		try {
			Object[] args = point.getArgs();
			for (int i = 0; i < args.length; i++) {
				if (args[i] instanceof HttpServletRequest) {
					continue;
				} else if (args[i] instanceof HttpServletResponse) {
					continue;
				} else if (args[i] instanceof HttpSession) {
					continue;
				} else if (args[i] instanceof ModelAndView) {
					continue;
				} else if (args[i] instanceof Model) {
					continue;
				}
				logArgs.add(args[i]);

			}
			returnValue = point.proceed(args);
			return returnValue;
		} finally {
			String result = "忽略";
			if ("dev".equals(active)) {
				if (returnValue instanceof ModelAndView) {
					View view = ((ModelAndView) returnValue).getView();
					if (view instanceof MappingJackson2JsonView) {
						result = JsonUtil.toJson(((MappingJackson2JsonView) view).getAttributesMap());
					} else {
						result = ((ModelAndView) returnValue).getViewName();
					}
				} else if (returnValue instanceof ResponseEntity) {
					result = "ResponseEntity:"
							+ ((ResponseEntity) returnValue).getHeaders().getContentType().toString();
				} else {
					result = JsonUtil.toJson(returnValue);
				}
				logger.info("调用接口{},参数:{},返回:{},耗时:{}ms", method.getDeclaringClass().getName() + "." + method.getName(),
						JsonUtil.toJson(logArgs), result, System.currentTimeMillis() - start);
			} else {
				logger.info("调用接口{},参数:{},返回:{},耗时:{}ms", method.getDeclaringClass().getName() + "." + method.getName(),
						JsonUtil.toJson(logArgs), result, System.currentTimeMillis() - start);
			}
		}
	}
}
