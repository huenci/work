package com.jiabiango.hr.config.resolver;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.jiabiango.hr.config.bean.ApiRequest;
import com.jiabiango.hr.config.util.RequestUtil;

@Component
public class ApiRequestResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType() == ApiRequest.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) throws Exception {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.setToken(webRequest.getHeader("Authorization"));
        apiRequest.setClientIp(RequestUtil.getIp(webRequest.getNativeRequest(HttpServletRequest.class)));
        apiRequest.setClientPlatform(webRequest.getHeader("C-Platform"));
        apiRequest.setClientSystem(webRequest.getHeader("C-System"));
        apiRequest.setSystemVersion(webRequest.getHeader("C-System-Version"));
        apiRequest.setClientVersion(webRequest.getHeader("C-Version"));
        apiRequest.setNetwork(webRequest.getHeader("C-Network"));
        String timestamp = webRequest.getHeader("Timestamp");
        apiRequest.setTimestamp(NumberUtils.toLong(timestamp));
        return apiRequest;
    }
}
