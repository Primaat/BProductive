package com.bproductive.todo;

import java.util.List;

import org.springframework.stereotype.Service;

/** 
 * @author Sebastiaan van den Berg
 * The Service arranges the connection between the Controller and Repository, 
 * receiving and sending data requests between the controller and repository
 * for storage or query purposes.
*/

@Service
public class ToDoService {
	
	private ToDoRepository toDoRepo;	
	
	public ToDoService(ToDoRepository toDoRepo) {
		this.toDoRepo = toDoRepo;
	}
		
	public List<ToDoModel> getAllToDoModels(){
		return toDoRepo.findAll();
	}
	
	public ToDoModel getToDoModelById(Long id){
		return toDoRepo.findToDoModelById(id);
	}
	
	public ToDoModel readyNewToDoModel() {
		return new ToDoModel();
	}

	public void createToDo(ToDoModel toDo) {
		 toDoRepo.save(toDo);
	}
	
	public void updateToDo(ToDoModel toDo) {
		 toDoRepo.save(toDo);
	}
	
	public void deleteToDo(Long id) {
		 toDoRepo.deleteById(id);
	}
}
