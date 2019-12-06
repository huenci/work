package com.jiabiango.hr.wechat.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 订单中台
 * @author Administrator
 *
 */
@Component
public class OrderCenterConstans {
	
	
	/**
	 * 订单支付成功提交销售数据到中台接口地址
	 */
	public static  String ORDER_CENTER_URL;
    
	/**
	 * 查询中台商品中心接口地址
	 */
	public static  String SKU_CENTER_URL;
	
	/**
	 * 查询中台会员中心手机号是否存在
	 */
	public static String MEMBER_PHONE_CENTER_URL;
	
	/**
	 * 查询中台会员余额
	 */
	public static String MEMBER_ACCOUNT_CENTER_URL;
	
	/**
	 * 中台会员中心余额支付接口
	 */
	public static String MEMBER_ACCOUNT_PAY_CENTER_URL;
	
	/**
	 * 中台会员中心余额充值接口
	 */
	public static String MEMBER_ACCOUNT_RECHARGE_CENTER_URL;
	
	/**
	 * 中台ERP配出单接口
	 */
	public static String MEMBER_WITHOUTORDER_CENTER_URL;
	
	/**
	 * 中台ERP仓库库存查询接口
	 */
	public static String MEMBER_BUSINVS_CENTER_URL;
	
	/**
	 * 分公司同步
	 */
	public static String COMPANY_CENTER_URL;
	
	/**
	 * 网点同步
	 */
	public static String STORE_CENTER_URL;
	
	
	/**
	 * 会员中心更新会员与网点的对应关系
	 */
	public static String MEMBER_SYNGBL_NETSTORE_URL;
	

	@Value("${center.ORDER_CENTER_URL:http://118.31.78.106:8088/jbg/sava/order}")
	public  void setORDER_CENTER_URL(String oRDER_CENTER_URL) {
		ORDER_CENTER_URL = oRDER_CENTER_URL;
	}

	@Value("${center.SKU_CENTER_URL:http://118.31.78.106:8088/jbg/query/goodlist}")
	public  void setSKU_CENTER_URL(String sKU_CENTER_URL) {
		SKU_CENTER_URL = sKU_CENTER_URL;
	}

	@Value("${center.MEMBER_PHONE_CENTER_URL:http://118.31.78.106:8001/hd/members/}")
	public  void setMEMBER_PHONE_CENTER_URL(String mEMBER_PHONE_CENTER_URL) {
		MEMBER_PHONE_CENTER_URL = mEMBER_PHONE_CENTER_URL;
	}

	@Value("${center.MEMBER_ACCOUNT_CENTER_URL:http://118.31.78.106:8001/hd/account/phone/}")
	public  void setMEMBER_ACCOUNT_CENTER_URL(String mEMBER_ACCOUNT_CENTER_URL) {
		MEMBER_ACCOUNT_CENTER_URL = mEMBER_ACCOUNT_CENTER_URL;
	}

	@Value("${center.MEMBER_ACCOUNT_PAY_CENTER_URL:http://118.31.78.106:8001/hd/account/phone/pay}")
	public  void setMEMBER_ACCOUNT_PAY_CENTER_URL(String mEMBER_ACCOUNT_PAY_CENTER_URL) {
		MEMBER_ACCOUNT_PAY_CENTER_URL = mEMBER_ACCOUNT_PAY_CENTER_URL;
	}

	@Value("${center.MEMBER_ACCOUNT_RECHARGE_CENTER_URL:http://118.31.78.106:8001/hd/account/phone/recharge/}")
	public  void setMEMBER_ACCOUNT_RECHARGE_CENTER_URL(String mEMBER_ACCOUNT_RECHARGE_CENTER_URL) {
		MEMBER_ACCOUNT_RECHARGE_CENTER_URL = mEMBER_ACCOUNT_RECHARGE_CENTER_URL;
	}

	@Value("${center.MEMBER_WITHOUTORDER_CENTER_URL:http://118.31.78.106:8088/jbg/sava/withoutorder}")
	public  void setMEMBER_WITHOUTORDER_CENTER_URL(String mEMBER_WITHOUTORDER_CENTER_URL) {
		MEMBER_WITHOUTORDER_CENTER_URL = mEMBER_WITHOUTORDER_CENTER_URL;
	}

	@Value("${center.MEMBER_BUSINVS_CENTER_URL:http://118.31.78.106:8088/jbg/query/businvs}")
	public  void setMEMBER_BUSINVS_CENTER_URL(String mEMBER_BUSINVS_CENTER_URL) {
		MEMBER_BUSINVS_CENTER_URL = mEMBER_BUSINVS_CENTER_URL;
	}
	
	@Value("${center.MEMBER_SYNGBL_NETSTORE_URL:https://yx.jiabiango.com/api/members/syngbl/netStore}")
	public  void setMEMBER_SYNGBL_NETSTORE_URL(String mEMBER_SYNGBL_NETSTORE_URL) {
		MEMBER_SYNGBL_NETSTORE_URL = mEMBER_SYNGBL_NETSTORE_URL;
	}
	
	@Value("${center.COMPANY_CENTER_URL:https://yx.jiabiango.com/api/members/syngbl/company}")
	public  void setCOMPANY_CENTER_URL(String cOMPANY_CENTER_URL) {
		COMPANY_CENTER_URL = cOMPANY_CENTER_URL;
	}
	
	@Value("${center.STORE_CENTER_URL:https://yx.jiabiango.com/api/members/syngbl/store}")
	public  void setSTORE_CENTER_URL(String sTORE_CENTER_URL) {
		STORE_CENTER_URL = sTORE_CENTER_URL;
	}
	
	
}
