package com.example.todolist.service;

import com.example.todolist.Entity.ToDoList;
import com.example.todolist.dto.CreateToDoRequest;
import com.example.todolist.dto.MessageResponse;
import com.example.todolist.dto.UpdateToDoRequest;
import com.example.todolist.repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor //왜 붙이는지 궁금합
public class ToDoService {

    private final ToDoListRepository toDoListRepository;


    @Transactional
    public MessageResponse createToDo(CreateToDoRequest request) {
            toDoListRepository.save(ToDoList.builder()
                    .contents(request.getContent())
                    .build());
        return MessageResponse.builder()
                .message("ToDoList 생성이 완료되었습니다.")
                .build();
    }


    @Transactional
    public MessageResponse updateToDo(UpdateToDoRequest dto, Long id) {
        ToDoList toDoList =toDoListRepository.findById(id).get();
        toDoList.setContents(dto.getContent());
        return MessageResponse.builder()
                .message(id + "번 아이디 ToDo 수정되었습니다")
                .build();
    }

    @Transactional
    public MessageResponse deleteToDo(Long id) {
        toDoListRepository.deleteById(id);
        return MessageResponse.builder()
                .message(id + "번이 아이디 ToDO가 삭제되었습니다")
                .build();
    }
}
