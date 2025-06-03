package com.todo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_Alltask")
public class Task {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long task_id;
	
	private Long user_id;
	
	private String title;
	private String task;
	
	private boolean completed;
	
	@Column(updatable = false)
	private LocalDateTime createon;
	private LocalDateTime updateon;
	
	
	
	
	public Long getTask_id() {
		return task_id;
	}

	public void setTask_id(Long task_id) {
		this.task_id = task_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public LocalDateTime getCreateon() {
		return createon;
	}

	public void setCreateon(LocalDateTime createon) {
		this.createon = createon;
	}

	public LocalDateTime getUpdateon() {
		return updateon;
	}

	public void setUpdateon(LocalDateTime updateon) {
		this.updateon = updateon;
	}



	
	

}
