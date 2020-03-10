package com.github.rakhmedovrs.SpringBootApp28.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Logout controller
 *
 * @author RakhmedovRS
 * @ created 2020-03-10
 */
@Controller
public class LogoutController
{
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String showWelcomePage(HttpServletRequest request, HttpServletResponse response)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null)
		{
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/";
	}

	private String getLoggedInUserName()
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails)
		{
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}
}
