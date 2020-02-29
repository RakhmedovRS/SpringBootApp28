package com.github.rakhmedovrs.SpringBootApp28.web.controller;

import com.github.rakhmedovrs.SpringBootApp28.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Login controller
 *
 * @author RakhmedovRS
 * @ created 2020-02-19
 */
@Controller
@SessionAttributes("name")
public class LoginController
{
    @Autowired
    LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginMessage(ModelMap modelMap)
	{
		return "login";
	}

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showWelcomePage(@RequestParam String name,
                                  @RequestParam String password,
                                  ModelMap modelMap)
    {
        if (!loginService.validateUser(name, password))
        {
            modelMap.put("errorMessage", "invalid password or/and username");
            return "login";
        }

        modelMap.put("name", name);
        return "welcome";
    }
}
