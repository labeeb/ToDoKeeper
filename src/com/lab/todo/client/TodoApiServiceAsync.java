package com.lab.todo.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.lab.todo.shared.Folder;
import com.lab.todo.shared.Task;

/**
 * The async counterpart of <code>TodoApiService</code>.
 */
public interface TodoApiServiceAsync {
	void testServerApi(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;

	void saveTask(Task task, AsyncCallback<Task> callback);

	void saveFolder(Folder folder, AsyncCallback<Folder> callback);
}
