package com.todo.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.entity.Task;

@Repository
public interface ToDoRepo extends JpaRepository<Task, Long> {

}
