package com.jiabiango.hr.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.jiabiango.hr.constant.Constant;

import net.sf.json.JSONObject;

public class ssm {
	
	private static Logger logger = LoggerFactory.getLogger(ssm.class);
	
	//产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAIKDHtGAQXoPlH";
    static final String accessKeySecret = "YHjNSR0pAx9Jo4IJnLF5JYEsE5zuiI";
    
    public static Map<String,Object> sendSms(String sendPhone, String Code,int noteType) throws ClientException {
    	Map<String, Object> map = new HashMap<String, Object>();
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", Constant.ACCESSKEYID, Constant.ACCESSKEYSECRET);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(sendPhone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("慢漫悠享");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_155840335");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"code\":\"" + Code + "\"}");
        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");
        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
        	//请求成功
        	map.put("type", 0);
        	map.put("msg", "发送成功");
        	return map;
        }
        map.put("type", -1);
    	map.put("msg", "网络繁忙，请稍后！");
    	map.put("Code", sendSmsResponse.getCode());
    	map.put("Message", sendSmsResponse.getMessage());
    	map.put("RequestId", sendSmsResponse.getRequestId());
    	map.put("BizId", sendSmsResponse.getBizId());
    	logger.info("---------------sendSms--------->sendPhone:"+sendPhone);
    	logger.info("---------------sendSms--------->sendCode:"+Code);
    	logger.info("---------------sendSms--------->Message:"+sendSmsResponse.getMessage());
    	logger.info("---------------sendSms--------->RequestId:"+sendSmsResponse.getRequestId());
    	logger.info("---------------sendSms--------->BizId:"+sendSmsResponse.getBizId());
        return map;
    }
    
    public static Map<String,Object> sendOrder(String sendPhone, String Code,String templateParam) throws ClientException {
    	Map<String, Object> map = new HashMap<String, Object>();
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", Constant.ACCESSKEYID, Constant.ACCESSKEYSECRET);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(sendPhone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("慢漫悠享");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(Code);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam(templateParam);
        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");
        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
        	//请求成功
        	map.put("type", 0);
        	map.put("msg", "发送成功");
        	return map;
        }
        map.put("type", -1);
    	map.put("msg", "网络繁忙，请稍后！");
    	map.put("Code", sendSmsResponse.getCode());
    	map.put("Message", sendSmsResponse.getMessage());
    	map.put("RequestId", sendSmsResponse.getRequestId());
    	map.put("BizId", sendSmsResponse.getBizId());
    	logger.info("---------------sendSms--------->sendPhone:"+sendPhone);
    	logger.info("---------------sendSms--------->sendCode:"+Code);
    	logger.info("---------------sendSms--------->Message:"+sendSmsResponse.getMessage());
    	logger.info("---------------sendSms--------->RequestId:"+sendSmsResponse.getRequestId());
    	logger.info("---------------sendSms--------->BizId:"+sendSmsResponse.getBizId());
        return map;
    }
    /**
     * 生成数字验证码
     * @param number
     * @return
     */
    public static String getRandomNumCode(int number){
        String codeNum = "";
        int [] numbers = {0,1,2,3,4,5,6,7,8,9};
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            //目的是产生足够随机的数，避免产生的数字重复率高的问题
            int next = random.nextInt(10000);
            codeNum+=numbers[next%10];
        }
        System.out.println(codeNum);
        return codeNum;
    }
    public static void main(String[] args) throws ClientException, InterruptedException {
    	//System.out.println("短信接口返回的数据----------------"+getRandomNumCode(6)); 
    	//System.out.println("短信接口返回的数据----------------"+sendSms("15576622969","666666",1));
    	Map<String, Object> map = new HashMap<>();
    	map.put("name", "胡先生");
		map.put("product", "香港");
		JSONObject json = JSONObject.fromObject(map);
		System.out.println(json.toString());
    	System.out.println("短信接口返回的数据----------------"+sendOrder("15576622969","SMS_155840347",json.toString()));
    	
    }
}
