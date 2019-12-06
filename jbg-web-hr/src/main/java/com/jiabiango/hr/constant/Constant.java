package com.jiabiango.hr.constant;

/**
 * 常量类
 * @author XIEMING
 */
public class Constant {
	/**验证码*/
	public static final String VERIFY_CODE = "VERIFY_CODE";
	/**登录失败次数*/
	public static final String LOGIN_ERROR_TIMES = "LOGIN_ERROR_TIMES";
	/**缓存的KEY*/
	public static final String CACHE_KEY = "CACHE_KEY";
	/**session过期时间(秒)*/
	public static final int SESSION_EXPIRE_SECONDS = 180;
	/**缓存权限信息*/
	public static final String SESSION_OPERATIONS = "SESSION_OPERATIONS";
	/**用户登录信息*/
	public static final String SESSION_IDENTITY_KEY = "SESSION_IDENTITY_KEY";
	/**匿名群组*/
	public static final String ROLE_ANONYMOUS = "anonymous";
	/**上次请求地址*/
	public static final String PRE_REQUEST_PATH = "PRE_REQUEST_PATH";
	/**上次请求时间*/
	public static final String PRE_REQUEST_TIME = "PRE_REQUEST_TIME";
	/**非法请求次数*/
	public static final String MAL_REQUEST_TIMES = "MAL_REQUEST_TIMES";
	
	public static final String HD_ADDORDER_APINAME = "新增批发单服务";
	public static final String HD_CANCELORDER_APINAME = "作废批发单服务";
	
	public static final String HD_ADDREFOUNDORDER_APINAME = "新增批发退单服务";
	
	public static final String WY_GETUNSYNCORDERS = "getunsyncorders";
	
	public static final String WY_UPDATEORDERSYNC = "updateordersyncbycode";
	
	public static final String WY_UPDATEORDERSENDSTATUS="updateordersendstatus";
	
	public static final String WY_UPDATEORDERSTATE="updateorderstate";
	
	
	public static final String CHARSET_UTF8 = "utf-8";
	
	/**
	 * web门店
	 */
	public static final String STORE_CODE="1001";
	/**
	 * 商户号
	 */
	public static final String CARD_ID="9765";
	
	public static final String VE = "VE";
	public static final String HD = "HD";
	public static final String CANCEL = "CANCEL";
	public static final String REFOUND = "REFOUND";
	
	public static final String ADD = "ADD";
	public static final String FINSH = "FINSH";
	
	public static final String DATE_FOMATE="yyyyMMddHHmmss";
	public static final String SUCCESS="SUCCESS";
	public static final String FAIL="FAIL";
	
	
	public static final String HD_ORDER_STAT="1000";//已收货
	/**
	 * 图片上传阿里云
	 */
//	public static final String ENDPOINT="oss-cn-shenzhen.aliyuncs.com";
//	
//	public static final String ACCESSKEYID="LTAIakY4grJVSw2I";
//
//	public static final String ACCESSKEYSECRET="ldP3smBJkPZJP6HqddkNUgHjPFqNG4";
//	
//	public static final String BUCKETNAME = "maamaam";
	
	public static final String ENDPOINT="oss-cn-shenzhen.aliyuncs.com";
	
	public static final String ACCESSKEYID="LTAI4Ow2Nr41We1R";

	public static final String ACCESSKEYSECRET="xtGQh7faFAwOYyEAtnnUIIUeNtNvSx";
	
	public static final String BUCKETNAME = "maam";

	public static final String STIME=" 00:00:00";
	
	public static final String ETIME=" 24:00:00";
}
