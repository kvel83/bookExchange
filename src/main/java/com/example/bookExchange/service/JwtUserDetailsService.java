package com.example.bookExchange.service;

import java.util.ArrayList;
import java.util.Optional;

import com.example.bookExchange.entity.User;
import com.example.bookExchange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        UserDetails userDetails = null;
        if (user != null) {
            userDetails = org.springframework.security.core.userdetails.User.withUsername(user.get().getUserName())
                    .password(user.get().getPassword()).accountExpired(false).authorities("usuario").accountLocked(false).build();
        }
        return userDetails;
    }

        /*if ("usuario".equals(username)) {
            return new User("usuario", "$2a$10$3rWgOTbkEqdiJBOt4dHMI.g7nDDIBaJC2IkWecEyTHVyZClhS3yLm",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }*/
        //return user;
    }