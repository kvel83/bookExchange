package com.example.bookExchange.service;

import com.example.bookExchange.entity.User;
import com.example.bookExchange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUserName (String userName){return userRepository.findByUserName(userName);}

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public void updateUser(Long id, User updatedUser){
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.ifPresent(user -> {
            user.setUserMail(updatedUser.getUserMail());
            user.setPassword(updatedUser.getPassword());
            user.setUserId(updatedUser.getUserId());
            user.setUserFullName(updatedUser.getUserFullName());
            user.setAge(updatedUser.getAge());
            userRepository.save(user);
        });

    }
}

