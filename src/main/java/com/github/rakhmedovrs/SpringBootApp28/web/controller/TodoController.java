package com.github.rakhmedovrs.SpringBootApp28.web.controller;

import com.github.rakhmedovrs.SpringBootApp28.web.model.Todo;
import com.github.rakhmedovrs.SpringBootApp28.web.service.TodoRepository;
import com.github.rakhmedovrs.SpringBootApp28.web.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;

/**
 * @author RakhmedovRS
 * @created 28-Feb-20
 */
@Controller
public class TodoController
{
	private static final String TODO_PAGE = "todo";
	private static final String LIST_TODO_PAGE = "list-todos";
	private static final String REDIRECT_LIST_TODO_PAGE = "redirect:/list-todos";

	@Autowired
	TodoService todoService;

	@Autowired
	TodoRepository repository;

	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String getList(ModelMap modelMap)
	{
//		modelMap.put("todos", todoService.getByUser(getLoggedInUserName()));
		modelMap.put("todos", repository.findByUser(getLoggedInUserName()));
		return LIST_TODO_PAGE;
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String addTodo(ModelMap modelMap)
	{
		modelMap.addAttribute("todo",
			new Todo(0, getLoggedInUserName(), "Default description", new Date(), false));
		return TODO_PAGE;
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result)
	{
		if (result.hasErrors())
		{
			return TODO_PAGE;
		}

		todo.setUser(getLoggedInUserName());
		repository.save(todo);
//		todoService.add(getLoggedInUserName(), todo.getDescription(), new Date(), false);
		return REDIRECT_LIST_TODO_PAGE;
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap modelMap, @RequestParam Integer id)
	{
//		todoService.deleteById(id);
		repository.deleteById(id);
		return REDIRECT_LIST_TODO_PAGE;
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap modelMap, @RequestParam Integer id)
	{
//		Todo todo = todoService.getById(id);
		Todo todo = repository.getOne(id);
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
		todo.setUser(getLoggedInUserName());
//		todoService.update(todo);
		repository.save(todo);
		return REDIRECT_LIST_TODO_PAGE;
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
