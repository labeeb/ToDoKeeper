package com.lab.todo.shared;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;



@Entity
public class Task implements com.google.gwt.user.client.rpc.IsSerializable {
	
	public @Id Long id;
	
	String text;
	List<Task> children;
	
	public Task() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "T("+text+") <"+children+">";
	}
	
	public Task(String text) {
		this.text = text;
		this.children = new ArrayList<Task>();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Task> getChildren() {
		return children;
	}

	public void setChildren(List<Task> children) {
		this.children = children;
	}
	
	
}
