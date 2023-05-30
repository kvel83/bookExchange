package com.example.bookExchange.controller;

import com.example.bookExchange.dto.UserDTO;
import com.example.bookExchange.entity.Book;
import com.example.bookExchange.entity.User;
import com.example.bookExchange.service.BookService;
import com.example.bookExchange.service.UserService;
import com.example.bookExchange.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/users")
public class userController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<UserDTO> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/id/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") Long userId){
        Optional<User> userWithRole= userService.getUserWithRole(userId);
        if (userWithRole.isPresent()){
            User user = userWithRole.get();
            UserDTO userDTO = Util.converToUserDTO(user);
            return ResponseEntity.ok(userDTO);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{userName}")
    public Optional<User> getUserByUserName(@PathVariable("userName") String userName){return userService.getUserByUserName(userName);}

    @PostMapping
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PutMapping("/update/{userId}")
    public void updateUser(@RequestBody User user, @PathVariable("userId") Long userId){
        userService.updateUser(userId, user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }
}
