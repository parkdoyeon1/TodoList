package com.example.todolist.repository;

import com.example.todolist.Entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList,Long> {

}
