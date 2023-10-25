package com.workshop.workshopmongo.resources;

import com.workshop.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        try {
            User user1 = new User("1", "pedro","gmail");
            List<User> list = new ArrayList<>();
            list.add(user1);
            return ResponseEntity.ok().body(list);
        } catch (RuntimeException exception){
            exception.printStackTrace();
            throw new RuntimeException();
        }

    }
}
