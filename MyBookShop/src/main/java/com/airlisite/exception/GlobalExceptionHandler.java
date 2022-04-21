/**
 * 
 */
package com.airlisite.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Administrator
 *
 */
public class GlobalExceptionHandler implements HandlerExceptionResolver{


	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		if(ex instanceof BookShopException){
			BookShopException libEx = (BookShopException)ex;
			request.setAttribute("error", libEx.getMsg());
		}else{
			request.setAttribute("error", ex.getMessage());
		}
		
		ModelAndView view = new ModelAndView();
		view.setViewName("error");
		return view;
	}
	
}
