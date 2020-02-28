package com.github.rakhmedovrs.SpringBootApp28.web.model;

import java.util.Date;
import java.util.StringJoiner;

/**
 * @author RakhmedovRS
 * @created 28-Feb-20
 */
public class Todo
{
	private Integer id;
	private String user;
	private String description;
	private Date targetDate;
	private boolean isDone;

	public Todo(Integer id, String user, String description, Date targetDate, boolean isDone)
	{
		this.id = id;
		this.user = user;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
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
		return isDone;
	}

	public void setDone(boolean done)
	{
		isDone = done;
	}

	@Override
	public String toString()
	{
		return new StringJoiner(", ", Todo.class.getSimpleName() + "[", "]")
			.add("id=" + id)
			.add("user='" + user + "'")
			.add("description='" + description + "'")
			.add("targetDate=" + targetDate)
			.add("isDone=" + isDone)
			.toString();
	}
}
