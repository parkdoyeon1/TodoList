package com.example.todolist.dto;

import com.example.todolist.Entity.ToDoList;
import com.example.todolist.repository.ToDoListRepository;
import lombok.AllArgsConstructor;

import java.util.NoSuchElementException;

@AllArgsConstructor
public class ExceptionRequest extends ToDoList {
    private ToDoListRepository toDoListRepository;
    public ToDoList exception(Long id){
        return toDoListRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException(id + "번은 없는 아이디 입니다"));
    }
}
