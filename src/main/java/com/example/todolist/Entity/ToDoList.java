package com.example.todolist.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "member")
public class ToDoList {

    private Member member;

    private Long id;

    private String contents;

    public void setMember(Member member) {
        this.member = member;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
