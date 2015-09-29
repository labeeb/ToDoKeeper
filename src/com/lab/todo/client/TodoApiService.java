package com.lab.todo.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.lab.todo.shared.Folder;
import com.lab.todo.shared.Task;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("api")
public interface TodoApiService extends RemoteService {
	String testServerApi(String name) throws IllegalArgumentException;
	
	Task saveTask(Task task)throws IllegalArgumentException; 
	
	Folder saveFolder(Folder folder) throws IllegalArgumentException;
	
}
