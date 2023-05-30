package com.example.bookExchange.entity;
/** Creado por Katia Velasquez 29/05/2023
 * Clase que representa a los usuarios del sistema */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "mail", unique = true)
    private String userMail;
    private String userFullName;
    private int age;
    private String password;
    private String userName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "role_id")
    @JsonIgnoreProperties("users")
    private Role role;
}
