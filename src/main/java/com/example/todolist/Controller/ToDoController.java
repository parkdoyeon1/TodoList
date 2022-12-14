package com.example.todolist.Controller;

import com.example.todolist.Entity.ToDoList;
import com.example.todolist.dto.request.CreateToDoRequest;
import com.example.todolist.dto.response.MessageResponse;
import com.example.todolist.dto.request.UpdateToDoRequest;
import com.example.todolist.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoService toDoService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public MessageResponse createToDo(@RequestBody CreateToDoRequest dto){
        return toDoService.createToDo(dto);
    }
    @PutMapping("/{todo-id}")
    public MessageResponse updateToDo(@RequestBody UpdateToDoRequest dto, @PathVariable("todo-id")Long id){
        return toDoService.updateToDo(dto,id);
    }

    @DeleteMapping("/{todo-id}")
    public MessageResponse deleteToDo(@PathVariable("todo-id") Long id){

        return toDoService.deleteToDo(id);
    }

    @DeleteMapping("/all")
    public MessageResponse deleteAll(){
       return toDoService.deleteAll();
    }

    @GetMapping
    public List<ToDoList> readAllToDo(){
        return toDoService.getToDo();
    }

    @GetMapping("/{todo-id}")
    public ToDoList readToDo(@PathVariable("todo-id") Long id){
        return toDoService.getToDo(id);
    }







}
