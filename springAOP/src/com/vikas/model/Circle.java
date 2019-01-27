package com.vikas.model;

import com.vikas.aspects.Loggable;

public class Circle {

	private String name;

	@Loggable
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String setNameAndReturn(String name) {
		this.name = name;

	return this.name;
	}
	
}
