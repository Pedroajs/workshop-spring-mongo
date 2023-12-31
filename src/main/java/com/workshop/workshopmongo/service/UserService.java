package com.workshop.workshopmongo.service;

import com.workshop.workshopmongo.domain.User;
import com.workshop.workshopmongo.dto.UserDTO;
import com.workshop.workshopmongo.repository.UserRepository;
import com.workshop.workshopmongo.service.exceptions.ResourceNotFoundException;
import com.workshop.workshopmongo.service.exceptions.RollbackException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static com.workshop.workshopmongo.dto.UserDTO.fromDTO;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional(rollbackFor = RollbackException.class)
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

    public User update(String id, UserDTO userDTO){
        var foundUser = findById(id);
        foundUser.setName(userDTO.name());
        foundUser.setEmail(userDTO.email());
        return userRepository.save(foundUser);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }
}
