package com.jiabiango.hr.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.util.Config;

@Configuration
public class KaptchaConfig {
    public static final String KAPTCHA_SESSION_KEY = "captcha";
    public static final String KAPTCHA_SESSION_DATE = "captcha_date";

    @Bean
    public Producer kaptchaProducer() {
        Properties properties = new Properties();
        properties.put("kaptcha.border", "no");
        properties.put("kaptcha.image.width", "160");
        properties.put("kaptcha.image.height", "70");
        properties.put("kaptcha.textproducer.char.string", "abcdefghjkmnprtuvwxyABCDEFGHJKMNPRTUVWXY1234567890");
        properties.put("kaptcha.textproducer.char.length", "4");
        properties.put("kaptcha.textproducer.font.size", "40");
        properties.put("kaptcha.textproducer.font.color", "white");
        properties.put("kaptcha.noise.color", "white");
        properties.put("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.ShadowGimpy");
        properties.put("kaptcha.background.clear.from", "darkGray");
        properties.put("kaptcha.background.clear.to", "gray");
        Config config = new Config(properties);
        Producer kaptchaProducer = config.getProducerImpl();
        return kaptchaProducer;
    }
}
