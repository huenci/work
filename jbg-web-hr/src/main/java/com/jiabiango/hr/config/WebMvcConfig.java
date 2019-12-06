package com.jiabiango.hr.config;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.jiabiango.hr.config.resolver.ApiRequestResolver;
import com.jiabiango.hr.util.SpringContextUtil;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
          .allowedOrigins("*")
          .allowedMethods("*")
          .allowedHeaders("*")
          .allowCredentials(true);
    }
	
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter convert = new FastJsonHttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        convert.setSupportedMediaTypes(supportedMediaTypes);
        converters.add(0, convert);
    }
    
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(SpringContextUtil.getBean(ApiRequestResolver.class));
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        super.addInterceptors(registry);
    }
    
    @Bean
    public Converter<String, Date> addDateConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                if (source == null || "".equals(source)) {
                    return null;
                }
                Date date;
                try {
                    date = DateUtils.parseDate(source, "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd");
                } catch (ParseException e) {
                    throw new RuntimeException("日期参数转换错误");
                }
                return date;
            }
        };
    }
}
