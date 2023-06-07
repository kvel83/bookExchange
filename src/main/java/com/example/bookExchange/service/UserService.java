package com.example.bookExchange.service;

import com.example.bookExchange.dto.RoleDTO;
import com.example.bookExchange.dto.UserDTO;
import com.example.bookExchange.entity.Role;
import com.example.bookExchange.entity.User;
import com.example.bookExchange.repository.UserRepository;
import com.example.bookExchange.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = new ArrayList<UserDTO>();
        if (!users.isEmpty()){
            for (User user:users){
                usersDTO.add(Util.converToUserDTO(user));
            }
        }
        return usersDTO;
    }


    public Optional<User> getUserWithRole(Long id){
        return userRepository.findByIdWithRole(id);
    }

    public Optional<User> getUserByUserName (String userName){return userRepository.findByUserName(userName);}

    public void saveUser(User user){
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
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

    public void updateUser (Long id, String newPassword){
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.ifPresent((user -> {
            String encryptedPassword = passwordEncoder.encode(newPassword);
            user.setPassword(encryptedPassword);
            userRepository.save(user);
        }));
    }
}

