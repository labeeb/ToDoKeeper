package com.lab.todo.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.lab.todo.client.TodoApiService;
import com.lab.todo.shared.Folder;
import com.lab.todo.shared.Task;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class TodoApiServiceImpl extends RemoteServiceServlet implements
		TodoApiService {

	public String testServerApi(String input) throws IllegalArgumentException {
		System.out.println("hello hello hello");
		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		return "client :" + input + " serverInfo: " + serverInfo
				+ " userAgent:" + userAgent;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}

	@Override
	public Task saveTask(Task task) throws IllegalArgumentException {
		task.setText("changed From server");
		return task;
	}

	@Override
	public Folder saveFolder(Folder folder) throws IllegalArgumentException {
		
		System.out.println("Going to save :"+folder);
		
		//Car porsche = new Car("2FAST", RED);
		//ofy().save().entity(folder).now();
		return folder;
	}
}
