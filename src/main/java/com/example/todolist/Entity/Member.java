package com.example.todolist.Entity;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {


    private Long id;


    private String account_id;
    private String password;

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
