package com.lab.todo.server;

import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.Closeable;
import com.lab.todo.shared.Folder;
import com.lab.todo.shared.Task;

public class TodoOfyService {
	static {
        factory().register(Task.class);
        factory().register(Folder.class);
    }

    public static Closeable ofy() {
        return ObjectifyService.begin();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
