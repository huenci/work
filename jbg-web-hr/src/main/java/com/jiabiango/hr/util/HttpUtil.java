package com.jiabiango.hr.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
 

	/**
	 * 对接中台
	 * 
	 * @param urlString
	 * @param jsonObject
	 * @return
	 */
	public static String postJson(String urlString, String jsonObject) {
		String returnJson = "";
		DataOutputStream out = null;
		BufferedReader reader = null;
		try {

			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			connection.connect();
			out = new DataOutputStream(connection.getOutputStream());
			if (null != jsonObject) {
				out.write(jsonObject.getBytes("UTF-8"));
			}
			out.flush();
			out.close();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null) {
				sb.append(lines);
			}
			returnJson = sb.toString();
			reader.close();
			connection.disconnect();
		} catch (Exception e) {

			e.printStackTrace();
		} // 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return returnJson;
	}
	
	/** 
     * 发起http请求获取返回结果 
     * @param req_url 请求地址 
     * @return 
     */ 
    public static String httpRequest(String req_url) {
        StringBuffer buffer = new StringBuffer();  
        try {  
            URL url = new URL(req_url);  
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  

            httpUrlConn.setDoOutput(false);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  

            httpUrlConn.setRequestMethod("GET");  
            httpUrlConn.connect();  

            // 将返回的输入流转换成字符串  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  

            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            // 释放资源  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();  

        } catch (Exception e) {  
            System.out.println(e.getStackTrace());  
        }  
        return buffer.toString();  
    }
 

}
