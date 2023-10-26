package com.workshop.workshopmongo.service;

import com.workshop.workshopmongo.domain.User;
import com.workshop.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User create(User user){
        return userRepository.save(user);
    }
}
