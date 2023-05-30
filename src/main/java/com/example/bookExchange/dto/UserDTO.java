package com.example.bookExchange.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    private String userMail;
    private String userFullName;
    private int age;
    private String userName;
    private RoleDTO role;
}
