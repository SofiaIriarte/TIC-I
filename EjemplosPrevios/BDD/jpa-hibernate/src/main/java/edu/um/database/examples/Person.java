package edu.um.database.examples;

import java.util.HashSet;
import java.util.Set;

public class Person {
	private Long id;
	private int age;
	private Name name;
	private Set<Event> events;

	public Person() {
		events = new HashSet<Event>();
		name = new Name();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

}
