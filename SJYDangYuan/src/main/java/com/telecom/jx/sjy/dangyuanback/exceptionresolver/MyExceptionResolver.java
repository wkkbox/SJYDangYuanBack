package com.telecom.jx.sjy.dangyuanback.exceptionresolver;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.ConnectException;

public class MyExceptionResolver implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv = null;
		// 如果是shiro无权操作，因为shiro 在操作auno等一部分不进行转发至无权限url
		if (ex instanceof UnauthorizedException) {
			mv = new ModelAndView("error/unauthor");
			return mv;
		} else if (ex instanceof ConnectException) {
			mv = new ModelAndView("error/unauthor");
			return mv;
		} else if (ex instanceof CommunicationsException) {
			mv = new ModelAndView("error/unauthor");
			return mv;
		}
		mv = new ModelAndView("error/error");
		ex.printStackTrace();
		return mv;
	}

}
