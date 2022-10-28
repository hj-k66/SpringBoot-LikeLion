package com.example.springboothello.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserRequestDto {
    private String id;
    private String name;
    private String password;

    @Override
    public String toString(){
        return String.format("%s %s %s", this.name, this.name, this.password);
    }
}
