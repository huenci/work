package com.jiabiango.hr.wechat.service.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jiabiango.hr.util.Tools;
import com.jiabiango.hr.wechat.dto.PaySignature;
import com.jiabiango.hr.wechat.dto.WxPayDto;
import com.jiabiango.hr.wechat.gongzhong.GongZhongService;
import com.jiabiango.hr.wechat.pay.CreateSignature;
import com.jiabiango.hr.wechat.pay.Sha1Util;

/**
 * @describe 小程序发起支付
 * @author lukas Lukas 414024003@qq.com
 * @date 2016年8月13日 10:56:14
 * @version 1.0
 */
@Component
public class MiniPayMentService {
	@Autowired
	private GongZhongService gongZhongService;

	private static Logger logger = LoggerFactory.getLogger(MiniPayMentService.class);
	
	/**
	 * 申请小程序支付
	 * @param body 描述
	 * @param orgName 当前域名含http
	 * @param openId 支付用户微信标识
	 * @param memberId 当前用户会员标识
	 * @param billNo 订单编号
	 * @param payType 支付类型 1:购买商品支付订单，2:余额支付 ，3:会员余额充值订单
	 * @param spbillCreateIp IP地址
	 * @param totalFee 支付金额
	 * @return
	 */
	public PaySignature createPayMini(String body, String orgName, String openId, String phoneNumber, String billNo,
			int payType, String spbillCreateIp, Double totalFee) {
		WxPayDto pay = new WxPayDto();
		pay.setOrderId(billNo);
		pay.setBody(body);
		pay.setNotifyUrl(orgName);
		pay.setOpenId(openId);
		pay.setPayType(payType + "," + phoneNumber);// 支付类型默认为1，1:购买商品支付订单，2:会员余额充值订单
		if(spbillCreateIp.contains(",")) {
			spbillCreateIp = spbillCreateIp.substring(0,spbillCreateIp.lastIndexOf(","));
    	}
		pay.setSpbillCreateIp(spbillCreateIp);
		pay.setTotalFee(Tools.getMoney(totalFee + ""));//
		PaySignature paySignature = new PaySignature();
		paySignature.setTimeStamp(Sha1Util.getTimeStamp());
		paySignature.setNonceStr(Sha1Util.getNonceStr());
		paySignature.setSignType("MD5");
		/*paySignature.setRegMoney(regMoney);
		paySignature.setRegHint(regHint);*/
		return CreateSignature.getPackage(pay, paySignature);
	}

}
