package com.jiabiango.hr.wechat.gongzhong;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.jiabiango.hr.util.JsonUtil;
import com.jiabiango.hr.wechat.gongzhong.vo.weboauth.OauthAccessToken;


/**
 * @category说明：微信AccessToken操作
 * @author创建人：lukas
 * @date创建时间：2017年12月26日17:01:07
 * @emial邮箱：414024003@163.com
 */
@Component
public class AccessTokenService {
	
    @Autowired
    private  StringRedisTemplate redisTemplate;
    
    /**
     * 保存微信 AccessToken
     * @param oauthAccessToken
     * @return
     */
    public  OauthAccessToken saveToken(String key,OauthAccessToken oauthAccessToken) {
        redisTemplate.boundValueOps(key).set(oauthAccessToken.getAccessToken(), oauthAccessToken.getExpiresIn()-500, TimeUnit.SECONDS);
        return oauthAccessToken;
    }
    
    /**
     * 获取微信AccessToken
     * @param accessToken
     * @return
     */
    public  String getToken(String key) {
        return  redisTemplate.boundValueOps(key).get();
    }
    
    /**
     * 获取微信授权AccessToken
     * @param accessToken
     * @return
     */
    public  OauthAccessToken getOauthAccessToken(String key) {
        return  JsonUtil.parse(redisTemplate.boundValueOps(key).get(), OauthAccessToken.class);
    }
    
    
    /**
     * 保存微信授权AccessToken
     * @param key
     * @param oauthAccessToken
     * @return
     */
    public  OauthAccessToken saveOauthAccessToken(String key,OauthAccessToken oauthAccessToken) {
        redisTemplate.boundValueOps(key).set(JsonUtil.toJson(oauthAccessToken),oauthAccessToken.getExpiresIn()-200, TimeUnit.SECONDS);
        return oauthAccessToken;
    }
    
    
  
    
}
