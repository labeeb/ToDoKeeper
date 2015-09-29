package com.lab.todo.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.lab.todo.client.widget.TaskTree;
import com.lab.todo.shared.Folder;
import com.lab.todo.shared.Task;

public class ShowItems implements EntryPoint {
	
	List<Folder> categories = null;
	TaskTree root11 ;

	@Override
	public void onModuleLoad() {
		// Create a menu bar
		MenuBar menu = new MenuBar();
		menu.setAutoOpen(true);
		// menu.setWidth("500px");
		menu.setAnimationEnabled(true);
		// root1.addItem(menu);

		Command menuCommand = new Command() {

			public void execute() {
				//saveTest();
				sendNameToServer();
			}
		};
		menu.addItem("Save", menuCommand);

		RootPanel.get().add(menu);

		categories = getData();
		TaskTree root11 = new TaskTree("NEW");
		//root11.setText("Folders");
		for (Folder category : categories) {
			for (Task task : category.getTasks()) {
				TaskTree taskTree = new TaskTree(task);
				root11.addItem(taskTree);
			}
		}
		Tree t = new Tree();
		t.addItem(root11);
		RootPanel.get().add(t);
	}

	public List<Task> getAllTask(TaskTree root){
		List<Task> tasks = new ArrayList<Task>();
		if(root == null||root.getChildren() == null){
			return null;
		}
		for(TaskTree taskTree:root.getChildren()){
			tasks.addAll(getAllTask(taskTree));
		}
		
		return tasks;
	}
	
	List<Folder> getData(){
		List<Folder> categories = new ArrayList<>();
		Folder c1 = new Folder("Folder name");
		Task t1 = new Task("Task");
		c1.getTasks().add(t1);
		categories.add(c1);
		return categories;
	}
	
	List<Folder> testData() {
		List<Folder> categories = new ArrayList<>();

		Folder c1 = new Folder("c1");

		Task t1 = new Task("t1");
		c1.getTasks().add(t1);
		Task t2 = new Task("t2");
		c1.getTasks().add(t2);
		Task t3 = new Task("t3");
		c1.getTasks().add(t3);
		Task t3_1 = new Task("t3_1");
		t3.getChildren().add(t3_1);
		Task t3_2 = new Task("t3_2");
		t3.getChildren().add(t3_2);
		Task t3_2_1 = new Task("t3_2_1");
		t3_2.getChildren().add(t3_2_1);
		Task t4 = new Task("t4");
		c1.getTasks().add(t4);
		categories.add(c1);

		return categories;
	}	


	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final TodoApiServiceAsync todoApiService = GWT
			.create(TodoApiService.class);
	
	/**
	 * Send the name from the nameField to the server and wait for a response.
	 */
	private void sendNameToServer() {
		// First, we validate the input.
		String textToServer = "Test value";
		
		if(categories == null || categories.size()==0){
			return;
		}
		
		Folder task= categories.get(0);
		todoApiService.saveFolder(task, new AsyncCallback<Folder>() {
			
			@Override
			public void onSuccess(Folder result) {
				Window.alert("from server :"+result.getText());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("it was a failure");
			}
		});
		
//		todoApiService.testServerApi(textToServer,
//				new AsyncCallback<String>() {
//					public void onFailure(Throwable caught) {
//						Window.alert("it was a failure");
//					}
//
//					public void onSuccess(String result) {
//						Window.alert("from server :"+result);
//					}
//				});
	}

}
