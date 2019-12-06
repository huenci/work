package com.jiabiango.hr.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.net.ssl.HttpsURLConnection;

import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jiabiango.hr.wechat.constant.WeChatConstans;

/**
 * 微信网页JS API支付签名
 * @author Lukas 2015年6月25日11:57:57
 *
 */
public class Sha1Util {
	
	private static Logger logger = LoggerFactory.getLogger(Sha1Util.class);

	
	/**
	 * 
	 */
	public static final String MCH_ID =WeChatConstans.mch_id;
	

	
	/**
	 * 
	 */
	public static final String KEY = WeChatConstans.partner_key;
	
	
	/**
	 * 请求生成二维码接口地址
	 */
	public static final String UNIFO_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	
	
	/**
	 * 微信端支付成功回调地址
	 */
	public static final String WECHAT_NOTIFY_URL = "/weChatPayResSample";
	
	/**
	 * 数据编码
	 */
	private static final String ENCODING = "UTF-8";
	
	
	
	
	
	/**
	 * 生成随机字符串
	 * @return
	 */
	public static String getNonceStr() {
		Random random = new Random();
		return MD5Utils.MD5Encode(String.valueOf(random.nextInt(10000)), "UTF-8");
	}
	
	/**
	 * 获取服务器时间戳
	 * @return
	 */
	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}
	
	 
	 /**
	  * 获得js signature
	  * @param signParams该对象继承了treeMap，并且所有的键名称均为小写总共有以下键jsapi_ticket，timestamp，nonce_str，url（treeMap默认是key值asc，但是在下面方法中并没有这个效果，所以将signParams转换成数组在按asc，如果想用signParams排序从重新排序）
	  * @return  false表示生成失败
	  * @throws IOException
	  */
	 public static String getSignature(SortedMap<String, String> signParams) throws IOException {
	     /****
	      * 对 jsapi_ticket、 timestamp 和 nonce 按字典排序 对所有待签名参数按照字段名的 ASCII
	      * 码从小到大排序（字典序）后，使用 URL 键值对的格式（即key1=value1&key2=value2…）拼接成字符串
	      * string1。这里需要注意的是所有参数名均为小写字符。 接下来对 string1 作 sha1 加密，字段名和字段值都采用原始值，不进行
	      * URL 转义。即 signature=sha1(string1)。
	      * **如果没有按照生成的key1=value&key2=value拼接的话会报错
	      */
		 String jsapi_ticket= signParams.get("jsapi_ticket");
		 String timestamp= signParams.get("timestamp");
		 String nonce= signParams.get("nonce_str");
		 String jsurl= signParams.get("url");
	     String[] paramArr = new String[] {"jsapi_ticket=" + jsapi_ticket,"timestamp=" + timestamp, "noncestr=" + nonce, "url=" + jsurl };
	     Arrays.sort(paramArr);
	     // 将排序后的结果拼接成一个字符串
	     String content = paramArr[0].concat("&"+paramArr[1]).concat("&"+paramArr[2]).concat("&"+paramArr[3]);
	     String gensignature = null;
	     try {
	         MessageDigest md = MessageDigest.getInstance("SHA-1");
	         // 对拼接后的字符串进行 sha1 加密
	         byte[] digest = md.digest(content.toString().getBytes());
	         gensignature = byteToStr(digest);
	     } catch (NoSuchAlgorithmException e) {
	         e.printStackTrace();
	     }
	     // 将 sha1 加密后的字符串与 signature 进行对比
	     if (gensignature != null) {
	         return gensignature.toLowerCase();// 返回signature
	     } else {
	         return "false";
	     }
	 }
	 
	 
	 /**
		 * 获取签名 用于页面wx.config注入
		 * @param timestamp Sha1Util.getTimeStamp()
		 * @param nonce_str Sha1Util.getNonceStr()
		 * @param url 当前网页的URL不包含#及其后面部分(参数需要带上,必须是完整的URL)
		 * @param ticket 公众号jsapi_ticke，作用于微信支付
		 * @return "" 表示获取签名出现异常
		 * @throws Exception 
		 */
		public static  String createSignature(String timestamp,String nonce_str,String url,String ticket){
			SortedMap<String, String> signParams = new TreeMap<String, String>();
			String jsapi_ticket=ticket;
			if(Tools.isEmpty(jsapi_ticket)){
				logger.info("获取jsapi_ticket异常");
				return "";
			}
			if(Tools.isEmpty(nonce_str)){
				logger.info("nonce_str参数不能为空");
				return "";
			}
			signParams.put("nonce_str", nonce_str);
			signParams.put("jsapi_ticket",jsapi_ticket);
			if(Tools.isEmpty(timestamp)){
				logger.info("timestamp参数不能为空");
				return "";
			}
			signParams.put("timestamp", timestamp);
			if(Tools.isEmpty(url)){
				logger.info("url参数不能为空");
				return "";
			}
			signParams.put("url", url);
			String signature="";
			try {
				signature =Sha1Util.getSignature(signParams);
			} catch (IOException e) {
				logger.info("wx.config签名生成异常："+e.getMessage());
				e.printStackTrace();
			}
			if(signature.equals("false")){
				return "";
			}
			return signature;
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
		
		
		/**
		 * 验证二维码支付请求前面与请求成功后返回前面是否一致
		 * 
		 * @param sbuf
		 * @param params
		 * @param root
		 * @param rsign
		 * @param key
		 * @return
		 */
		public static final boolean verifySign(final StringBuilder sbuf,
				final SortedMap<String, String> params, final Element root,
				final String rsign, final String key) {
			params.clear();
			final List<?> elems = root.elements();
			for (final Iterator<?> i = elems.iterator(); i.hasNext();) {
				final Element elem = (Element) i.next();
				final String name = elem.getName();
				if ("sign".equals(name)) {
					continue;
				}
				params.put(name, elem.getText());
			}
			final String sign = getSign(sbuf, params, key);
			logger.info("verifySign sign：" + sign);
			logger.info("verifySign rsign：" + rsign);
			return (sign.equals(rsign));
		}
		
		/**
		 * 生成请求二维码支付签名
		 * 
		 * @param sbuf
		 * @param params
		 * @param key
		 * @return
		 */
		public static final String getSign(final StringBuilder sbuf,
				final SortedMap<String, String> params, final String key) {
			sbuf.setLength(0);
			int k = 0;
			for (final Iterator<String> i = params.keySet().iterator(); i.hasNext(); ++k) {
				final String name = i.next();
				sbuf.append(k == 0 ? "" : '&').append(name).append('=')
						.append(params.get(name));
			}
			sbuf.append('&').append("key").append('=').append(key);
			return Encrypt.MD5(sbuf.toString(), ENCODING).toUpperCase();
		}
		
		
	 
	 /**
	  * 将字节数组转换为十六进制字符串
	  *
	  * @param byteArray
	  * @return
	  */
	 private static String byteToStr(byte[] byteArray) {
	     String strDigest = "";
	     for (int i = 0; i < byteArray.length; i++) {
	         strDigest += byteToHexStr(byteArray[i]);
	     }
	     return strDigest;
	 }
	  
	 /**
	  * 将字节转换为十六进制字符串
	  *
	  * @param mByte
	  * @return
	  */
	 private static String byteToHexStr(byte mByte) {
	     char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
	             'B', 'C', 'D', 'E', 'F' };
	     char[] tempArr = new char[2];
	     tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
	     tempArr[1] = Digit[mByte & 0X0F];
	     String s = new String(tempArr);
	     return s;
	 }
	
}
