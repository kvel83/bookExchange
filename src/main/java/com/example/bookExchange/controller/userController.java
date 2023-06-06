package com.example.bookExchange.controller;

import com.example.bookExchange.dto.UserDTO;
import com.example.bookExchange.dto.UserUpdateDTO;
import com.example.bookExchange.entity.Book;
import com.example.bookExchange.entity.User;
import com.example.bookExchange.service.BookService;
import com.example.bookExchange.service.UserService;
import com.example.bookExchange.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
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

    /*@PutMapping("/update/{userId}")
    public void updateUser(@RequestBody User user, @PathVariable("userId") Long userId){
        userService.updateUser(userId, user);
    }*/

    @PutMapping ("/update/{userId}")
    public ResponseEntity<String> updateUser(@RequestBody(required = false) UserUpdateDTO userDTO, @PathVariable("userId") Long userId ) {
        if (userDTO != null) {
            User user = userDTO.getUser();
            String newPassword = userDTO.getNewPassword();
            if (user != null) {
                userService.updateUser(userId, user);
                return ResponseEntity.ok("Usuario actualizado exitosamente");
            } else if (newPassword != null) {
                userService.updateUser(userId, newPassword);
                return ResponseEntity.ok("Password actualizada correctamente");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Solicitud inválida");
    }


    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }
}
