package com.bproductive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bproductive.enums.Priorities;
import com.bproductive.todo.ToDoModel;
import com.bproductive.todo.ToDoRepository;
import com.bproductive.todo.ToDoService;

/** 
 * @author Sebastiaan van den Berg
 * Data initializer creates takes for the BProductive web app
*/

@Component
public class InitData implements CommandLineRunner{
	
	private ToDoService toDoService;
	
	public InitData(ToDoRepository toDoRepo, ToDoService toDoService) {
		this.toDoService = toDoService;
	}
	
	@Override
	public void run(String... args) throws Exception {		
		
		createToDos();				
	}

	private void createToDos() {	
				
		toDoService.createToDo(new ToDoModel("Johan", "Doing this", Priorities.values()[0], "2021-10-10"));
		toDoService.createToDo(new ToDoModel("Susan", "Doing that", Priorities.values()[1], "2021-10-06"));
		toDoService.createToDo(new ToDoModel("Rick", "Doing more",  Priorities.values()[2], "2021-10-08"));
		toDoService.createToDo(new ToDoModel("Debbie", "Doing less", Priorities.values()[1], "2021-10-30"));
		toDoService.createToDo(new ToDoModel("Henk", "Doing too much", Priorities.values()[2], "2021-10-03"));
		toDoService.createToDo(new ToDoModel("Jane", "Doing a lot", Priorities.values()[2], "2021-10-04"));
		toDoService.createToDo(new ToDoModel("Dirk", "Doing nothing much", Priorities.values()[0], "2021-12-31"));
	}
}
