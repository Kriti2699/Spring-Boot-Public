package com.todo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.todo.entity.Task;

public interface ToDoService {
	
	Task save(Task t);
	
	Optional<Task> getTaskById(Long id);
	
	List<Task> getAllTask();
	
//	Task modify(Map<String, Object> updateTask);

	Task modify(Task t);
	
	boolean delete(Long t);


	
	
	
	

}
