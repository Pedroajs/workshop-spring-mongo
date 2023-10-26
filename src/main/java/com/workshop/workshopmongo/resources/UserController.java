package com.workshop.workshopmongo.resources;

import com.workshop.workshopmongo.domain.User;
import com.workshop.workshopmongo.dto.UserDTO;
import com.workshop.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.workshop.workshopmongo.dto.UserDTO.fromUser;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map(UserDTO::fromUser).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> finBydId(@PathVariable String id){
        var foundUser = userService.findById(id);
        return ResponseEntity.ok().body(fromUser(foundUser));
    }
}
