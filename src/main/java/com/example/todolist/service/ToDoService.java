package com.example.todolist.service;

import com.example.todolist.Entity.ToDoList;
import com.example.todolist.dto.request.CreateToDoRequest;
import com.example.todolist.dto.response.MessageResponse;
import com.example.todolist.dto.request.UpdateToDoRequest;
import com.example.todolist.repository.ToDoListRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor   // private final ToDoListRepository toDoListRepository 의 생성자를 추가해줄려고
public class ToDoService {

    private final ToDoListRepository toDoListRepository;

    private ToDoList toDoList = new ToDoList();

    public List<ToDoList> getToDo(){
        return toDoListRepository.findAll();
    }


    @Transactional
    public MessageResponse createToDo(CreateToDoRequest request) {
            toDoListRepository.save(ToDoList.builder()
                    .contents(request.getContent())
                    .build());
        return MessageResponse.builder()
                .message("ToDoList" +"(" + request.getContent() + ")" + "ToDoList 생성이 완료되었습니다.")
                .build();
    }



    @Transactional
    public MessageResponse updateToDo(UpdateToDoRequest dto, Long id) {
        ToDoList toDoList =toDoListRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(id + "번은 없는 아이디 입니다"));
        toDoList.setContents(dto.getContent());
        return MessageResponse.builder()
                .message(id + "번 아이디 ToDo 수정되었습니다")
                .build();
    }

    @Transactional
    public MessageResponse deleteToDo(Long id) {
        try {
            toDoListRepository.deleteById(id);
        }catch (Exception e){
            throw new BaseException(ErrorCode.NOT_FOUND);
        }

        return MessageResponse.builder()
                .message(id + "번이 아이디 ToDO가 삭제되었습니다")
                .build();
    }

    public ToDoList getToDo(Long id){

        return toDoListRepository.findById(id)
                .orElse(()-> new BaseException(ErrorCode.NOT_FOUND));
              //  .orElseThrow(() -> new NoSuchElementException(id + "번 아이디는 없는 아이디 입니다"));
    }

    private void noneIdChecker(Long id){

        toDoListRepository.findById(toDoList.getId())
                .ifPresent(toDoList1 -> {
                    throw new IllegalStateException("예외처리");
                });

    }


    public MessageResponse deleteAll() {
        toDoListRepository.deleteAll();
        return MessageResponse.builder()
                .message("모든 ToDOList가 삭제되었습니다.")
                .build();
    }

}
