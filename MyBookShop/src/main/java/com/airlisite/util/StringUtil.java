package com.airlisite.util;

/**
 * 字符串处理工具类
 * @author Ctony
 *
 */
public class StringUtil {
	
	/**
	 * 判断是否为数字(正整数)
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str)
	{
		if(str==null || str.equals(""))
			return false;
		return str.matches("[1-9]\\d*");
	}
}
