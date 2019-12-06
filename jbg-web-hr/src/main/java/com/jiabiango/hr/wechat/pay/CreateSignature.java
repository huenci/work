package com.jiabiango.hr.wechat.pay;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.net.ssl.HttpsURLConnection;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiabiango.hr.util.Encrypt;
import com.jiabiango.hr.util.Tools;
import com.jiabiango.hr.wechat.constant.WeChatConstans;
import com.jiabiango.hr.wechat.dto.PaySignature;
import com.jiabiango.hr.wechat.dto.WxPayDto;

/**
 * @category说明：支付签名小程序
 * @author创建人：lukas
 * @date创建时间：2017年12月26日17:01:07
 * @emial邮箱：414024003@163.com
 */
public class CreateSignature {
	
	private static Logger logger = LoggerFactory.getLogger(CreateSignature.class);
	
	
	/**
	 * 获取小程序签名
	 * @param body 主体
	 * @param openId 当前小程序应用微信用户对于的OPENID
	 * @param TotalFee 订单支付金额单位为元
	 * @param all_order_number 订单编号
	 * @param payType 1.普通订单 2.余额充值订单
	 * @param member_id 当前用户会员表中member_id
	 * @param ip 当前发起支付客户端IP/或者客户端设备唯一标识
	 * @param basePath 服务端地址
	 * @param appId 小程序appId
	 * @return
	 */
	public static PaySignature weChatPay(String body, String openId, double TotalFee,
			String all_order_number, String payType, String member_id,
			String ip,String basePath,String appId) {
		WxPayDto tpWxPay = new WxPayDto();
		tpWxPay.setOpenId(openId);
		tpWxPay.setBody(body);
		tpWxPay.setOrderId(all_order_number);
		tpWxPay.setSpbillCreateIp(ip);
		tpWxPay.setTotalFee(Tools.getMoney(TotalFee+""));
		String PayType = payType + "," + member_id;
		tpWxPay.setPayType(PayType);
		PaySignature paySignature =JSON.parseObject(getPackage(tpWxPay,basePath,appId), PaySignature.class) ;
		logger.info(paySignature.toString());
		return paySignature;
	}
	
	
	/**
	 * 获取请求预支付id报文
	 * @param tpWxPayDto 支付请求对象
	 * @param basePath 支付域名
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String getPackage(WxPayDto tpWxPayDto,String basePath,String appId) {
		// 1 参数
		String openId = tpWxPayDto.getOpenId();
		// 附加数据 原样返回
		String attach = tpWxPayDto.getPayType();
		// 总金额以分为单位，不带小数点
		String totalFee = tpWxPayDto.getTotalFee();
		// 订单生成的机器 IP
		String spbill_create_ip = tpWxPayDto.getSpbillCreateIp();
		// ---必须参数
		// 商品描述根据情况修改
		String body = tpWxPayDto.getBody();
		// 商户订单号
		String out_trade_no = tpWxPayDto.getOrderId();
		SortedMap<String, String> params = new TreeMap<String, String>();
		// 公众账号ID
		params.put("appid", appId);// 微信分配的公众账号ID（企业号corpid即为此appId）
		// 商户号
		params.put("mch_id", Sha1Util.MCH_ID);// 微信支付分配的商户号
		// 随机字符串
		String nonce_str = Sha1Util.getNonceStr();
		params.put("nonce_str", nonce_str);// 随机字符串，不长于32位。推荐随机数生成算法:https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_3
		// 商品描述
		params.put("body", body);
		// 附加数据
		params.put("attach", attach);// 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
		// 商户订单号
		params.put("out_trade_no", out_trade_no);// 商户系统内部的订单号,32个字符内、可包含字母,
													// 其他说明见https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2
		// 总金额 Int类型，已做单位处理
		params.put("total_fee", totalFee);// 订单总金额，单位为分，详见支付金额
		// 终端IP
		params.put("spbill_create_ip", spbill_create_ip);// APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
		// 通知地址
		String notify_url = basePath + Sha1Util.WECHAT_NOTIFY_URL;// NOTIFYURL
		params.put("notify_url", notify_url);
		String trade_type = "JSAPI";
		params.put("trade_type", trade_type);
		params.put("openid", openId);
		String sign = createSign(params,Sha1Util.KEY,"UTF-8");
		String xml = "<xml>" + "<appid>" + appId + "</appid>" + "<mch_id>"
				+ Sha1Util.MCH_ID + "</mch_id>" + "<nonce_str>" + nonce_str
				+ "</nonce_str>" + "<sign>" + sign + "</sign>"
				+ "<body><![CDATA[" + body + "]]></body>" + "<out_trade_no>"
				+ out_trade_no + "</out_trade_no>" + "<attach>" + attach
				+ "</attach>" + "<total_fee>" + totalFee + "</total_fee>"
				+ "<spbill_create_ip>" + spbill_create_ip
				+ "</spbill_create_ip>" + "<notify_url>" + notify_url
				+ "</notify_url>" + "<trade_type>" + trade_type
				+ "</trade_type>" + "<openid>" + openId + "</openid>"
				+ "</xml>";
		logger.info("获取到的预支付IDxml数据：" + xml);

		String resultXML = httpsRequest(Sha1Util.UNIFO_URL, "POST", xml);
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(resultXML);
		} catch (DocumentException e) {
			logger.info("获取resultXML异常");
			e.printStackTrace();
		}
		logger.info("获取到的预支付resultXML:" + resultXML);
		final Element root = doc.getRootElement();
		String prepay_id = root.element("prepay_id").getText();
		if (Tools.isEmpty(prepay_id)) {
			logger.info("获取到的预支付ID为空");
		}
		// 获取prepay_id后，拼接最后请求支付所需要的package
		SortedMap<String, String> finalpackage = new TreeMap<String, String>();
		String timestamp = Sha1Util.getTimeStamp();
		String packages = "prepay_id=" + prepay_id;
		finalpackage.put("appId", appId);
		finalpackage.put("timeStamp", timestamp);
		finalpackage.put("nonceStr", nonce_str);
		finalpackage.put("package", packages);
		finalpackage.put("signType", "MD5");
		// 要签名
		String finalsign =createSign(finalpackage,Sha1Util.KEY,"UTF-8");
		String finaPackage = "\"appId\":\"" + appId + "\",\"timeStamp\":\""
				+ timestamp + "\",\"nonceStr\":\"" + nonce_str
				+ "\",\"package\":\"" + packages + "\",\"signType\" : \"MD5"
				+ "\",\"paySign\":\"" + finalsign + "\"";
		JSONObject j = new JSONObject();
		j.put("appId", appId);
		j.put("timeStamp", timestamp);
		j.put("nonceStr", nonce_str);
		j.put("packages", packages);
		j.put("signType", "MD5");
		j.put("paySign", finalsign);
		j.put("billNo", out_trade_no);
		logger.info("finaPackage :" + finaPackage);
		return j.toString();
	}
	
	
	/**
	 * 申请支付并返回签名内容
	 * @param tpWxPayDto 支付内容实体
	 * @param paySignature 支付签名内容
	 * @return paySignature
	 */
	public static PaySignature getPackage(WxPayDto tpWxPayDto,PaySignature paySignature) {
		String appId=WeChatConstans.appMiniId;
//		String appId="wx5031e88c2a41ab54";
		SortedMap<String, String> params = new TreeMap<String, String>();
		// 公众账号ID
		params.put("appid", appId);// 微信分配的公众账号ID（企业号corpid即为此appId）
		// 商户号
		params.put("mch_id", Sha1Util.MCH_ID);// 微信支付分配的商户号
//		params.put("mch_id", "1514631091");// 微信支付分配的商户号
		// 随机字符串
		params.put("nonce_str", paySignature.getNonceStr());// 随机字符串，不长于32位。推荐随机数生成算法:https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_3
		// 商品描述
		params.put("body", tpWxPayDto.getBody());
		// 附加数据
		params.put("attach", tpWxPayDto.getPayType());// 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
		// 商户订单号其他说明见https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2
		params.put("out_trade_no", tpWxPayDto.getOrderId());// 商户系统内部的订单号,32个字符内、可包含字母,
		// 总金额 Int类型，已做单位处理
		params.put("total_fee", tpWxPayDto.getTotalFee());// 订单总金额，单位为分，详见支付金额
		// 终端IP
		params.put("spbill_create_ip", tpWxPayDto.getSpbillCreateIp());// APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
		// 通知地址
		String notify_url = tpWxPayDto.getNotifyUrl() + Sha1Util.WECHAT_NOTIFY_URL;
		params.put("notify_url", notify_url);
		String trade_type = "JSAPI";
		params.put("trade_type", trade_type);
		params.put("openid", tpWxPayDto.getOpenId());
		String sign = createSign(params,Sha1Util.KEY,"UTF-8");
		String xml = "<xml>" + "<appid>" + appId + "</appid>" + "<mch_id>"
				+ "1514631091" + "</mch_id>" + "<nonce_str>" + paySignature.getNonceStr()
				+ "</nonce_str>" + "<sign>" + sign + "</sign>"
				+ "<body><![CDATA[" + tpWxPayDto.getBody() + "]]></body>" + "<out_trade_no>"
				+ tpWxPayDto.getOrderId() + "</out_trade_no>" + "<attach>" + tpWxPayDto.getPayType()
				+ "</attach>" + "<total_fee>" + tpWxPayDto.getTotalFee() + "</total_fee>"
				+ "<spbill_create_ip>" + tpWxPayDto.getSpbillCreateIp()
				+ "</spbill_create_ip>" + "<notify_url>" + notify_url
				+ "</notify_url>" + "<trade_type>" + trade_type
				+ "</trade_type>" + "<openid>" + tpWxPayDto.getOpenId() + "</openid>"
				+ "</xml>";
		logger.info("--------------------------->发起支付请求报文内容：" + xml);
		String resultXML = "";
		Document doc = null;
		try {
			resultXML=httpsRequest(Sha1Util.UNIFO_URL, "POST", xml);
			logger.info("--------------------------->发起支付返回报文数据内容:" + resultXML);
			doc = DocumentHelper.parseText(resultXML);
		} catch (DocumentException e) {
			logger.info("--------------------------->获取resultXML异常:"+e.toString());
			e.printStackTrace();
			return paySignature;
		}
		logger.info("获取到的预支付resultXML:" + resultXML);
		final Element root = doc.getRootElement();
		  
		String prepay_id = root.element("prepay_id").getText();
		if (Tools.isEmpty(prepay_id)) {
			logger.info("--------------------------->获取到的预支付ID为空,发起支付返回报文数据内容:"+ resultXML);
			return paySignature;
		}
		// 获取prepay_id后，拼接最后请求支付所需要的package
		SortedMap<String, String> finalpackage = new TreeMap<String, String>();
		String packages = "prepay_id=" + prepay_id;
		finalpackage.put("appId", appId);
		finalpackage.put("timeStamp", paySignature.getTimeStamp());
		finalpackage.put("nonceStr", paySignature.getNonceStr());
		finalpackage.put("package", packages);
		finalpackage.put("signType",paySignature.getSignType());
		// 要签名
		String finalsign =createSign(finalpackage,Sha1Util.KEY,"UTF-8");
		paySignature.setPackages(packages);
		paySignature.setPaySign(finalsign);
		paySignature.setBillNo(tpWxPayDto.getOrderId());
		return paySignature;
	}
	
	
	/**
	 * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
	 */
	public static String createSign(SortedMap<String, String> packageParams,String partner_key,String charset) {
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k)
					&& !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + partner_key);
		logger.info("--------------------------->发起支付请求连接商户key：" + sb.toString());
		String sign = Encrypt.MD5(sb.toString(), charset).toUpperCase();
		return sign;

	}
	
	/**
	 * https访问接口
	 * 
	 * @param requestUrl
	 *            地址
	 * @param requestMethod
	 *            GET/POST
	 * @param output
	 *            参数内容
	 * @return
	 */
	public static String httpsRequest(String requestUrl, String requestMethod,
			String output) {
		try {
			URL url = new URL(requestUrl);
			HttpsURLConnection connection = (HttpsURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod(requestMethod);
			if (null != output) {
				OutputStream outputStream = connection.getOutputStream();
				outputStream.write(output.getBytes("UTF-8"));
				outputStream.close();
			}
			// 从输入流读取返回内容
			InputStream inputStream = connection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			connection.disconnect();
			return buffer.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return "";
	}
	

}
