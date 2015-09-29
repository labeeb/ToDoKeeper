package com.lab.todo.client.widget;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TreeItem;
import com.lab.todo.shared.Task;

public class TaskTree extends TreeItem {
	private Task task;
	private List<TaskTree> children;
	private CheckBox checkBox;
	private TextArea text;
	private Button addChildBtn;

	private void setChild(Task task) {
		this.task = task;
		HorizontalPanel hPanel = new HorizontalPanel();
		setWidget(hPanel);
		this.checkBox = new CheckBox();
		hPanel.add(checkBox);

		this.addChildBtn = new Button("+");
		hPanel.add(addChildBtn);
		addChildBtn.addClickHandler(addButtonClickHandler);

		this.text = new TextArea();
		this.text.setText(task.getText());
		hPanel.add(this.text);
	}

	public TaskTree(Task task) {
		setChild(task);
		if (task != null && task.getChildren().size() > 0) {
			children = new ArrayList<TaskTree>(task.getChildren().size());
			for (Task child : task.getChildren()) {
				TaskTree childTree = new TaskTree(child);
				children.add(childTree);
				addItem(childTree);
			}

		}
	}

	public TaskTree(String string) {
		setText(string);
	}

	ClickHandler addButtonClickHandler = new ClickHandler() {
		public void onClick(ClickEvent event) {
			Task newChildTask = new Task("");
			TaskTree.this.task.getChildren().add(newChildTask);
			TaskTree childTree = new TaskTree(newChildTask);
			TaskTree.this.addItem(childTree);
			TaskTree.this.setState(true);
			childTree.setState(true);
			// Window.alert("child created");
		}
	};

	public List<TaskTree> getChildren() {
		return children;
	}
	
	
}
