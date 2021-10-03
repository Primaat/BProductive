package com.bproductive.todo;

import org.springframework.data.jpa.repository.JpaRepository;

/** 
 * @author Sebastiaan van den Berg
 * The Repository is queried by the service  and send Objects for further processing
 * and stores new Objects send by the service.
*/

public interface ToDoRepository extends JpaRepository<ToDoModel, Long>{
	
	ToDoModel findToDoModelById(Long id);
}
