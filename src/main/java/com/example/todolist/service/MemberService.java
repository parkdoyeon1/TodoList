package com.example.todolist.service;

import com.example.todolist.Entity.Member;
import com.example.todolist.dto.request.MemberRequest;
import com.example.todolist.dto.response.MessageResponse;
import com.example.todolist.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MessageResponse join(MemberRequest request) {
        duplicateMemberCheck(request.getMemberId());
        Member member =Member.builder()
                .memberId(request.getMemberId())
                .password(request.getPassword())
                .build();
            memberRepository.save(member);
            return MessageResponse.builder()
                    .message(member.getMemberId()+"님이 정상적으로 회원가입이 완료 되었습니다.")
                    .build();
    }


    public List<String> findAll() {
        return memberRepository.findAll().stream()
                .map(member -> member.getMemberId())
                .collect(Collectors.toList());
    }


    private void duplicateMemberCheck(String memberId){
        memberRepository.findByMemberId(memberId)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
