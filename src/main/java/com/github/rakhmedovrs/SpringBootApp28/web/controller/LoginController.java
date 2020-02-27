package com.github.rakhmedovrs.SpringBootApp28.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Login controller
 *
 * @author RakhmedovRS
 * @ created 2020-02-19
 */
@Controller
public class LoginController
{
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginMessage(ModelMap modelMap)
	{
		return "login";
	}

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showWelcomePage(@RequestParam String name,
                                  ModelMap modelMap)
    {
        modelMap.put("name", name);
        return "welcome";
    }
}
