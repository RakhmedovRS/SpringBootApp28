package com.github.rakhmedovrs.SpringBootApp28.web.controller;

import com.github.rakhmedovrs.SpringBootApp28.web.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author RakhmedovRS
 * @created 28-Feb-20
 */
@Controller
@SessionAttributes("name")
public class TodoController
{
	@Autowired
	TodoService todoService;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String getList(ModelMap modelMap)
	{
		modelMap.put("todos", todoService.getByUser((String) modelMap.get("name")));
		return "list-todos";
	}
}
