package com.jiabiango.hr.wechat.dto;

import java.math.BigDecimal;

/**
 * @category说明：微信支付签名
 * @author创建人：lukas
 * @date创建时间：2017年12月26日17:01:07
 * @emial邮箱：414024003@163.com
 */
public class PaySignature extends Signature{
	
	/**
	 * 预支付报文内容
	 */
	private String packages;
	
	/**
	 * 签名类型
	 */
	private String signType;
	
	
	/**
	 * 支付签名
	 */
	private String paySign;
	
	/**
	 * 订单编号
	 */
	private String billNo;
	
	/**
	 * 赠送金额
	 */
	private BigDecimal regMoney;

	/**
	 * 充值提示
	 */
	private int regHint;
	
	public String getBillNo() {
		return billNo;
	}


	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}


	public String getPackages() {
		return packages;
	}


	public void setPackages(String packages) {
		this.packages = packages;
	}


	public String getSignType() {
		return signType;
	}


	public void setSignType(String signType) {
		this.signType = signType;
	}


	public String getPaySign() {
		return paySign;
	}


	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}

	public BigDecimal getRegMoney() {
		return regMoney;
	}


	public void setRegMoney(BigDecimal regMoney) {
		this.regMoney = regMoney;
	}
	
	public int getRegHint() {
		return regHint;
	}


	public void setRegHint(int regHint) {
		this.regHint = regHint;
	}

	@Override
	public String toString() {
		return "PaySignature [packages=" + packages + ", signType=" + signType + ", paySign=" + paySign + ", billNo="
				+ billNo + ", regMoney=" + regMoney + ", regHint=" + regHint + "]";
	}
	
}
