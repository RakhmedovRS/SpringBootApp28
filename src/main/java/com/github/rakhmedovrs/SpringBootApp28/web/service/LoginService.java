package com.github.rakhmedovrs.SpringBootApp28.web.service;

import org.springframework.stereotype.Component;

/**
 * @author RakhmedovRS
 * @created 27-Feb-20
 */
@Component()
public class LoginService
{
	public boolean validateUser(String userID, String password)
	{
		return userID.equalsIgnoreCase("in28minutes") && password.equals("dummy");
	}
}
