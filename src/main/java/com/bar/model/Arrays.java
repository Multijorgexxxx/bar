package com.bar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Arrays {

	@Id
	private int id;
	private String input_array;

	public Arrays() {
	}

	public Arrays(int id, String input_array) {
		this.id = id;
		this.input_array = input_array;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInput_array() {
		return input_array;
	}

	public void setInput_array(String input_array) {
		this.input_array = input_array;
	}

}
