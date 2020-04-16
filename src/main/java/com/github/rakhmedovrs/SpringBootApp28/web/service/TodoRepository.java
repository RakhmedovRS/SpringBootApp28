package com.github.rakhmedovrs.SpringBootApp28.web.service;

import com.github.rakhmedovrs.SpringBootApp28.web.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author RakhmedovRS
 * @created 16-Apr-20
 */
public interface TodoRepository extends JpaRepository<Todo, Integer>
{
	List<Todo> findByUser(String user);
}
