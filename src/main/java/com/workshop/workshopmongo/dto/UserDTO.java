package com.workshop.workshopmongo.dto;

import com.workshop.workshopmongo.domain.User;

import java.io.Serializable;

public record UserDTO(String id, String name, String email) implements Serializable {
    public static UserDTO fromUser(User user){
        return new UserDTO(user.getId(),user.getName(), user.getEmail());
    }

    public static User fromDTO(UserDTO userDTO){
        return new User(userDTO.id,userDTO.name, userDTO.email);
    }
}