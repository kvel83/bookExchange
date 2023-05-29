package com.example.bookExchange.controller;

import com.example.bookExchange.entity.Book;
import com.example.bookExchange.entity.User;
import com.example.bookExchange.service.BookService;
import com.example.bookExchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/users")
public class userController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable("userId") Long userId){
        return userService.getUser(userId);
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
