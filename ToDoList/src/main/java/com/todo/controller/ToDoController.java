package com.todo.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entity.Task;
import com.todo.service.ToDoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/todolist")
public class ToDoController {
	
	@Autowired
	private ToDoService todoservice;
	
	@PostMapping("/add")	
	Map<String, Object> add(@RequestBody Task t)
	{
		t.setCreateon(LocalDateTime.now());
		Map<String, Object> response=new HashMap<>();
		try {
			response.put("status", "Success");
			response.put("data",todoservice.save(t) );
		}
		catch(Exception e) {
			response.put("status", "Failure");
			response.put("data",e.fillInStackTrace());
		}
		return response;
	}
	
	
	@GetMapping("/{id}")
	Map<String, Object> getById(@PathVariable Long id){
		
		Map<String, Object> response=new HashMap<>();
		try {
			response.put("status", "Success");
			response.put("data", todoservice.getTaskById(id));
		} catch (Exception e) {
			response.put("status", "Failure");
			response.put("data", e.fillInStackTrace());
		}
		return response;
	}
	
	@PutMapping("/modifyTask/{id}")
	Map<String, Object> modifyTask(@PathVariable Long id,@RequestBody Map<String, Object> updateTask){
		Map<String, Object> response=new HashMap<>();
		try {
			Task existingTask=todoservice.getTaskById(id)
					.orElseThrow(()->new RuntimeException("Task not found for id "+id));
			
		
			if(updateTask.containsKey("title")) {
				existingTask.setTitle(updateTask.get("title").toString());
			}
			if (updateTask.containsKey("task")) {
				existingTask.setTask(updateTask.get("task").toString());
			}
			if (updateTask.containsKey("completed")) {
				existingTask.setCompleted(Boolean.parseBoolean((String) updateTask.get("completed")));
			}
			
			existingTask.setUpdateon(LocalDateTime.now());
			
			response.put("status", "Success");
			response.put("data", todoservice.modify(existingTask));
		} catch (Exception e) {
			response.put("status", "Failure");
			response.put("data", e.fillInStackTrace());
		}
		
		return response;
	}
	
	@GetMapping("/alltask")
	Map<String, Object> getAllTask(){
		
		Map<String, Object> response=new HashMap<>();
		try {
			response.put("status", "Success");
			response.put("data", todoservice.getAllTask());
		} catch (Exception e) {
			response.put("status", "Failure");
			response.put("data", e.fillInStackTrace());
		}
		
		return response;
		
	}
	@DeleteMapping("/delete/{id}")
	Map<String,Object> deleteRecord(@PathVariable Long id){
		
		String result;
		boolean isDelete=todoservice.delete(id);
		if(isDelete) {
			 result="deleted successfully";
		}
		else {
			 result="error in deletion";
		}
		Map<String,Object> response=new HashMap<>();
		try {
			response.put("status", "Success");
			response.put("data", result);
		} catch (Exception e) {
			response.put("status", "Failure");
			response.put("data", e.fillInStackTrace());
		}		
		return response;
		
	}	
}
