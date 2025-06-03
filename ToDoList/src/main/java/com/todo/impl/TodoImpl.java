package com.todo.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entity.Task;
import com.todo.repositoty.ToDoRepo;
import com.todo.service.ToDoService;

@Service
public class TodoImpl implements ToDoService {

	@Autowired
	private ToDoRepo repo;
	
	@Override
	public Task save(Task t) {
		return repo.save(t);
	}
	

	@Override
	public Optional<Task> getTaskById(Long id) {
	
		return repo.findById(id);
	}
	
	
	@Override
	public List<Task> getAllTask() {
		return repo.findAll();
	}

@Override
	public Task modify(Task t) {
		return repo.save(t);
	}


@Override
public boolean delete(Long id) {
	// TODO Auto-generated method stub
	
	if(repo.existsById(id)) {
		repo.deleteById(id);
			return true;
	}
	return false;
}


//	@Override
//	public Task modify(Map<String, Object> updateTask) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	

}
