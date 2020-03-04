package com.github.rakhmedovrs.SpringBootApp28.web.service;

import com.github.rakhmedovrs.SpringBootApp28.web.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author RakhmedovRS
 * @created 28-Feb-20
 */
@Service
public class InMemoryTodoService implements TodoService
{
	private static List<Todo> todos = new ArrayList<>();
	private static int todoCount;

	static
	{
		todos.add(new Todo(++todoCount, "in28Minutes", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(++todoCount, "in28Minutes", "Learn Struts", new Date(), false));
		todos.add(new Todo(++todoCount, "in28Minutes", "Learn Hibernate", new Date(), false));
	}

	@Override
	public List<Todo> getByUser(final String user)
	{
		return todos.stream().filter(todo -> todo.getUser().equals(user)).collect(Collectors.toList());
	}

	@Override
	public void add(String user, String description, Date targetDate, boolean isDone)
	{
		todos.add(new Todo(++todoCount, user, description, targetDate, isDone));
	}

	@Override
	public void deleteById(final Integer id)
	{
		todos.removeIf(todo -> todo.getId().equals(id));
	}

	@Override
	public Todo getById(Integer id)
	{
		return todos.stream().filter(todo -> todo.getId().equals(id)).findFirst().orElse(null);
	}

	@Override
	public void update(Todo newTodo)
	{
		todos.remove(newTodo);
		todos.add(newTodo);
	}
}
