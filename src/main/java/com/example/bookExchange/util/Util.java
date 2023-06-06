package com.example.bookExchange.util;

import com.example.bookExchange.dto.RoleDTO;
import com.example.bookExchange.dto.UserDTO;
import com.example.bookExchange.entity.Role;
import com.example.bookExchange.entity.User;
import com.example.bookExchange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public class Util {

    @Autowired
    private UserRepository userRepository;

    public static RoleDTO convertToRoleDTO(Role role){
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(role.getRoleId());
        roleDTO.setRoleName((role.getRoleName()));
        return roleDTO;
    }
    public static UserDTO converToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserFullName(user.getUserFullName());
        userDTO.setUserMail(user.getUserMail());
        userDTO.setUserName(user.getUserName());
        userDTO.setAge(user.getAge());
        userDTO.setRole(convertToRoleDTO(user.getRole()));
        return userDTO;
    }


}
