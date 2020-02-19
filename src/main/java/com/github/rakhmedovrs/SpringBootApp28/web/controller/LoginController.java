package com.github.rakhmedovrs.SpringBootApp28.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Login controller
 *
 * @author RakhmedovRS
 * @ created 2020-02-19
 */
@Controller
public class LoginController
{
    @RequestMapping("/login")
    @ResponseBody
    public String loginMessage()
    {
        return "Login message";
    }
}
