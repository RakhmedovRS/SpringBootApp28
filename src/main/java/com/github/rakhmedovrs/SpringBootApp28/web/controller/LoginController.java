package com.github.rakhmedovrs.SpringBootApp28.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String loginMessage()
    {
        return "login";
    }
}