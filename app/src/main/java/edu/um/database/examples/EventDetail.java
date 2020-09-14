package edu.um.database.examples;

import java.util.Date;

public class EventDetail {
	private Long id;
	private Date date;
	
	public EventDetail(Long id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}
	
	public Long getId() {
		return id;
	}
	
	public Date getDate() {
		return date;
	}
	
	
}
