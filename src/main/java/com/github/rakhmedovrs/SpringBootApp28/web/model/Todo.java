package com.github.rakhmedovrs.SpringBootApp28.web.model;

import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * @author RakhmedovRS
 * @created 28-Feb-20
 */
@Entity(name = "Todo")
public class Todo
{
	@Id
	@GeneratedValue
	private Integer id;
	private String user;
	@Size(min = 10, message = "Enter at least 10 characters")
	private String description;
	private Date targetDate;
	private boolean done;

	public Todo()
	{
	}

	public Todo(Integer id, String user, String description, Date targetDate, boolean done)
	{
		this.id = id;
		this.user = user;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Date getTargetDate()
	{
		return targetDate;
	}

	public void setTargetDate(Date targetDate)
	{
		this.targetDate = targetDate;
	}

	public boolean isDone()
	{
		return done;
	}

	public void setDone(boolean done)
	{
		this.done = done;
	}

	@Override
	public String toString()
	{
		return new StringJoiner(", ", Todo.class.getSimpleName() + "[", "]")
			.add("id=" + id)
			.add("user='" + user + "'")
			.add("description='" + description + "'")
			.add("targetDate=" + targetDate)
			.add("isDone=" + done)
			.toString();
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		Todo todo = (Todo) o;
		return getId().equals(todo.getId());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(getId());
	}
}
