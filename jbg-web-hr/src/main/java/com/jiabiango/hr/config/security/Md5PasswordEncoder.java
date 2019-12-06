package com.jiabiango.hr.config.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Md5PasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        if(rawPassword == null) {
            return null;
        }
        return DigestUtils.md5Hex(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if(StringUtils.isBlank(encodedPassword)) {
            return true;
        }
        return encodedPassword.equalsIgnoreCase(encode(rawPassword));
    }
}
