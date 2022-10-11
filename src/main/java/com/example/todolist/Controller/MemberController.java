package com.example.todolist.Controller;


import com.example.todolist.dto.request.MemberRequest;
import com.example.todolist.dto.response.MessageResponse;
import com.example.todolist.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;



    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public MessageResponse createMember(@RequestBody MemberRequest request){
        return memberService.join(request);
    }

    @GetMapping
    public List<String> findAll(){
        return memberService.findAll();
    }




}
