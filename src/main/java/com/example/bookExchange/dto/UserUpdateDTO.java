package com.example.bookExchange.dto;

import com.example.bookExchange.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserUpdateDTO {
    private User user;
    private String newPassword;
}
