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
	private static final String TODO_PAGE = "todo";
	private static final String LIST_TODO_PAGE = "list-todos";
	private static final String REDIRECT_LIST_TODO_PAGE = "redirect:/list-todos";

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
		modelMap.put("todos", todoService.getByUser(getLoggedInUserName(modelMap)));
		return LIST_TODO_PAGE;
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String addTodo(ModelMap modelMap)
	{
		modelMap.addAttribute("todo",
			new Todo(0, getLoggedInUserName(modelMap), "Default description", new Date(), false));
		return TODO_PAGE;
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result)
	{
		if (result.hasErrors())
		{
			return TODO_PAGE;
		}

		todoService.add(getLoggedInUserName(modelMap), todo.getDescription(), new Date(), false);
		return REDIRECT_LIST_TODO_PAGE;
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap modelMap, @RequestParam Integer id)
	{
		todoService.deleteById(id);
		return REDIRECT_LIST_TODO_PAGE;
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap modelMap, @RequestParam Integer id)
	{
		Todo todo = todoService.getById(id);
		modelMap.put("todo", todo);
		return TODO_PAGE;
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result)
	{
		if (result.hasErrors())
		{
			return TODO_PAGE;
		}
		todo.setUser(getLoggedInUserName(modelMap));
		todoService.update(todo);
		return REDIRECT_LIST_TODO_PAGE;
	}

	private String getLoggedInUserName(ModelMap modelMap)
	{
		return (String) modelMap.get("name");
	}
}
