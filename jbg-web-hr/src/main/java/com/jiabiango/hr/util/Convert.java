package com.jiabiango.hr.util;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.commons.lang3.math.NumberUtils;

public class Convert
{
	
	private static final int DEF_DIV_SCALE = 10; 
	
	/**
	 * string转int
	 * @param str 字符窜
	 * @param defaultValue 默认int类型
	 * @return
	 */
  public static int strToInt(String str, int defaultValue)
  {
    int Result = defaultValue;
    try
    {
      if(str.contains(".")){
    	  str = str.substring(0,str.indexOf("."));
    	  
      }
      Result = Integer.parseInt(str);
     
    }
    catch (Exception localException) {
    	System.out.println(localException.toString());
    }
    return Result;
  }

  /**
   * string转long
   * @param str 字符窜
   * @param defaultValue 默认long
   * @return
   */
  public static long strToLong(String str, long defaultValue) {
    long Result = defaultValue;
    try
    {
      Result = Long.parseLong(str);
    }
    catch (Exception localException) {
    }
    return Result;
  }

  /**
   * string转float
   * @param str
   * @param defaultValue
   * @return
   */
  public static float strToFloat(String str, float defaultValue) {
    float Result = defaultValue;
    try
    {
      Result = Float.parseFloat(str);
    }
    catch (Exception localException) {
    }
    return Result;
  }

  public static double strToDouble(String str, double defaultValue) {
    double Result = defaultValue;
    try
    {
      Result = Double.parseDouble(str);
    }
    catch (Exception localException) {
    }
    return Result;
  }
  
  public static BigDecimal strToBigDecimal(String str,BigDecimal defaultValue) {
		BigDecimal dec =defaultValue;
		if(str==null || str==""){
			return dec;
		}
		BigDecimal bd = new BigDecimal(str);
		dec = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return dec;
	}
  
  
  /**
	 * String类型转Double类型，保留2位小数
	 * @param doubleStr
	 * @return double
	 */
	public  static double strToDouble(String doubleStr){
		DecimalFormat   df = new DecimalFormat("#.00");
		return NumberUtils.toDouble(df.format(doubleStr), 0.00);
	}
	
	/**
	 * Double类型（保留2位小数）
	 * @param doubleStr
	 * @return double
	 */
	public  static double strToDouble(Double doubleStr){
		DecimalFormat   df = new DecimalFormat("#.00");
		return  NumberUtils.toDouble(df.format(doubleStr), 0.00) ;
	}

  public static boolean strToBoolean(String str, boolean defaultValue) {
    boolean Result = defaultValue;
    try
    {
      Result = Boolean.parseBoolean(str);
    }
    catch (Exception localException) {
    }
    return Result;
  }

  public static java.util.Date strToDate(String str, java.util.Date defaultValue)
  {
    return strToDate(str, "yyyy-MM-dd HH:mm:ss", defaultValue);
  }

  public static java.util.Date strToDate(String str, String format, java.util.Date defaultValue) {
    java.util.Date Result = defaultValue;
    SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.ENGLISH);
    try
    {
      Result = formatter.parse(str);
    }
    catch (Exception localException) {
    }
    return Result;
  }

  public static String dateToStr(java.util.Date date, String defaultValue)
  {
    return dateToStr(date, "yyyy-MM-dd HH:mm:ss", defaultValue);
  }

  public static String dateToStr(java.util.Date date, String format, String defaultValue) {
    String Result = defaultValue;
    SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.ENGLISH);
    try
    {
      Result = formatter.format(date);
    }
    catch (Exception localException) {
    }
    return Result;
  }

  public static String strToStr(String str, String defaultValue) {
    String Result = defaultValue;

    if ((str != null) && (!(str.isEmpty()))) {
      Result = str;
    }

    return Result;
  }

  public static java.sql.Date dateToSqlDate(java.util.Date date) {
    return new java.sql.Date(date.getTime());
  }

  public static java.util.Date sqlDateToDate(java.sql.Date date) {
    return new java.util.Date(date.getTime());
  }

  public static Timestamp dateToSqlTimestamp(java.util.Date date) {
    return new Timestamp(date.getTime());
  }

  public static java.util.Date qlTimestampToDate(Timestamp date) {
    return new java.util.Date(date.getTime());
  }

  public static int strtoAsc(String st)
  {
    byte[] gc = st.getBytes();
    int asnum = gc[0];
    return asnum;
  }

  public static char intToChar(int backnum)
  {
    char stchar = (char)backnum;
    return stchar;
  }
  
  /** 
  * * 两个Double数相加 * 
  *  
  * @param v1 * 
  * @param v2 * 
  * @return Double 
  */  
  public static Double add(Double v1, Double v2) {  
     BigDecimal b1 = new BigDecimal(v1.toString());  
     BigDecimal b2 = new BigDecimal(v2.toString());  
     return new Double(b1.add(b2).doubleValue());  
  }  
    
  /** 
  * * 两个Double数相减 * 
  *  
  * @param v1 * 
  * @param v2 * 
  * @return Double 
  */  
  public static Double sub(Double v1, Double v2) {  
     BigDecimal b1 = new BigDecimal(v1.toString());  
     BigDecimal b2 = new BigDecimal(v2.toString());  
     return new Double(b1.subtract(b2).doubleValue());  
  }  
    
  /** 
  * * 两个Double数相乘 * 
  *  
  * @param v1 * 
  * @param v2 * 
  * @return Double 
  */  
  public static Double mul(Double v1, Double v2) {  
     BigDecimal b1 = new BigDecimal(v1.toString());  
     BigDecimal b2 = new BigDecimal(v2.toString());  
     return new Double(b1.multiply(b2).doubleValue());  
  }  
    
  /** 
  * * 两个Double数相除 * 
  *  
  * @param v1 * 
  * @param v2 * 
  * @return Double 
  */  
  public static Double div(Double v1, Double v2) {  
     BigDecimal b1 = new BigDecimal(v1.toString());  
     BigDecimal b2 = new BigDecimal(v2.toString());  
     return new Double(b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP)  
       .doubleValue());  
  }  
    
  /** 
  * * 两个Double数相除，并保留scale位小数 * 
  *  
  * @param v1 * 
  * @param v2 * 
  * @param scale * 
  * @return Double 
  */  
  public static Double div(Double v1, Double v2, int scale) {  
     if (scale < 0) {  
      throw new IllegalArgumentException(  
        "The scale must be a positive integer or zero");  
     }  
     BigDecimal b1 = new BigDecimal(v1.toString());  
     BigDecimal b2 = new BigDecimal(v2.toString());  
     return new Double(b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue());  
  }  
  
}