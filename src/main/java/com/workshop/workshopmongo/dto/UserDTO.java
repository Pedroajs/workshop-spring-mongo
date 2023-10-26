package com.workshop.workshopmongo.dto;

import com.workshop.workshopmongo.domain.User;

import java.io.Serializable;

public record UserDTO(String name, String email) implements Serializable {
    public static UserDTO fromUser(User user){
        return new UserDTO(user.getName(), user.getEmail());
    }
}