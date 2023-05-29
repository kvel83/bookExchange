package com.example.bookExchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Devuelve el nombre de la vista del formulario de inicio de sesión
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // Devuelve el nombre de la vista del panel de control
    }
}