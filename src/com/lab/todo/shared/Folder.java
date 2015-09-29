package com.lab.todo.shared;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Folder implements com.google.gwt.user.client.rpc.IsSerializable{
	
	@Id Long id;
	
	String text;
	List<Task> tasks;
	
	public Folder() {
		// for api
	}
	
	@Override
	public String toString() {
		return "F("+text+") <"+tasks+">";
	}
	
	public Folder(String text) {
		this.text = text;
		this.tasks = new ArrayList<>();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
}
