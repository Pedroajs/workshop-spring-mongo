package com.workshop.workshopmongo.service;

import com.workshop.workshopmongo.domain.User;
import com.workshop.workshopmongo.dto.UserDTO;
import com.workshop.workshopmongo.repository.UserRepository;
import com.workshop.workshopmongo.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static com.workshop.workshopmongo.dto.UserDTO.fromDTO;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User insert(UserDTO userDTO){
        return userRepository.insert(fromDTO(userDTO));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User create(User user){
        return userRepository.save(user);
    }

    public User findById(String id){
        var foundUser = userRepository.findById(id);
        return foundUser.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
