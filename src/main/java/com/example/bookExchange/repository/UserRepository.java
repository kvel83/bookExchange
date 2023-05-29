package com.example.bookExchange.repository;

import com.example.bookExchange.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * @param userName de usuario a buscar
     * @return Usuario
     */
    Optional<User> findByUserName(String userName);
}
