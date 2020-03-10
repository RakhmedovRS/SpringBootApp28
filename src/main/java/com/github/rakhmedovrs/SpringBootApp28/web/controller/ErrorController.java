package com.github.rakhmedovrs.SpringBootApp28.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Error controller
 *
 * @author RakhmedovRS
 * @created 10-Mar-20
 */
@Controller("error")
public class ErrorController
{
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView handleException(HttpServletRequest request, Exception exception)
	{
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("exception", exception.getStackTrace());
		 mv.addObject("url", request.getRequestURL());
		 mv.setViewName("error");

		 return mv;
	}
}
