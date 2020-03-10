package com.github.rakhmedovrs.SpringBootApp28.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Welcome controller
 *
 * @author RakhmedovRS
 * @ created 2020-02-19
 */
@Controller
public class WelcomeController
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap modelMap)
	{
		modelMap.put("name", getLoggedInUserName());
		return "welcome";
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
