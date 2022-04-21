package com.airlisite.util;

import com.airlisite.exception.BookShopException;

public class ValidateTool {

	/**
	 * 验证参数是否为空
	 * @param obj
	 * @return 不为空:true,为空false
	 * @throws BookShopException
	 */
	public static boolean checkIsNull(Object obj) throws BookShopException{
		if(obj==null){
			return false;
		}
		if (obj instanceof String) {
			if (((String) obj).trim().equals("")) {
				return false;
			}
		}
		return true;
	}
	
	
}
