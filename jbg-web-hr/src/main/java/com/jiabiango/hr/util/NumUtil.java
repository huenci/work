package com.jiabiango.hr.util;

import java.math.BigDecimal;

public class NumUtil {
	private static final long SIZE_KB = 1024;
	private static final long SIZE_MB = SIZE_KB * 1024;
	private static final long SIZE_GB = SIZE_MB * 1024;

	/**
	 * 将金额从int转成double
	 * 
	 * @param money
	 * @return
	 */
	public static double moneyIntToDouble(Integer money) {
		return divide(money, 2);
	}
	
    public static String moneyIntToDoubleString(Integer money) {
        BigDecimal o = new BigDecimal(money.toString());
        String s = o.movePointLeft(2).toString();
        s = s.replace(".00", "");
        return s;
    }
    
    public static String discountIntToDoubleString(Integer money) {
        BigDecimal o = new BigDecimal(money.toString());
        String s = o.movePointLeft(1).toString();
        s = s.replace(".0", "");
        return s;
    }
	
	/**
	 * 将金额从double转成int
	 * 
	 * @param money
	 * @return
	 */
	public static int moneyDoubleToInt(Double money) {
		return multiply(money, 2);
	}

	public static double divide(Integer a, int n) {
		BigDecimal o = new BigDecimal(a.toString());
		return o.movePointLeft(n).doubleValue();
	}

	public static int multiply(Double a, int n) {
		BigDecimal o = new BigDecimal(a.toString());
		return o.movePointRight(n).intValue();
	}
	
	public static String formatSize(long size) {
		if (size < SIZE_KB) {
			return String.format("%d B", (int) size);
		} else if (size < SIZE_MB) {
			return String.format("%.2f KB", (float) size / SIZE_KB);
		} else if (size < SIZE_GB) {
			return String.format("%.2f MB", (float) size / SIZE_MB);
		} else {
			return String.format("%.2f GB", (float) size / SIZE_GB);
		}
	}
}
