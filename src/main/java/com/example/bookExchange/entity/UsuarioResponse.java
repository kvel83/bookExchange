package com.example.bookExchange.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioResponse {
    
    private String userName;
    private Long   rolId;
    private String token;
}
