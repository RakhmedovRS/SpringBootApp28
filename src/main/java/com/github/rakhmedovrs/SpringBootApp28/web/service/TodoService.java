package com.github.rakhmedovrs.SpringBootApp28.web.service;

import com.github.rakhmedovrs.SpringBootApp28.web.model.Todo;

import java.util.Date;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 28-Feb-20
 */
public interface TodoService
{
	List<Todo> getByUser(final String user);

	void add(String user, String description, Date targetDate, boolean isDone);

	void deleteById(final Integer id);

	Todo getById(final Integer id);

	void update(Todo todo);
}
