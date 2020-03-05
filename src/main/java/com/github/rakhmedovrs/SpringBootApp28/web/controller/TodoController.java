package com.github.rakhmedovrs.SpringBootApp28.web.controller;

import com.github.rakhmedovrs.SpringBootApp28.web.model.Todo;
import com.github.rakhmedovrs.SpringBootApp28.web.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;

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

	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String getList(ModelMap modelMap)
	{
		modelMap.put("todos", todoService.getByUser((String) modelMap.get("name")));
		return "list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String addTodo(ModelMap modelMap)
	{
		modelMap.addAttribute("todo",
			new Todo(0, (String) modelMap.get("name"), "Default description", new Date(), false));
		return "todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result)
	{
		if (result.hasErrors())
		{
			return "todo";
		}

		todoService.add((String) modelMap.get("name"), todo.getDescription(), new Date(), false);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap modelMap, @RequestParam Integer id)
	{
		todoService.deleteById(id);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap modelMap, @RequestParam Integer id)
	{
		Todo todo = todoService.getById(id);
		modelMap.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result)
	{
		if (result.hasErrors())
		{
			return "todo";
		}
		todo.setUser((String) modelMap.get("name"));
		todoService.update(todo);
		return "redirect:/list-todos";
	}
}
