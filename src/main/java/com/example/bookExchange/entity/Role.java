package com.example.bookExchange.entity;
/** Creado por Katia Velasquez 29/05/2023
 * Clase que representa a los usuarios del sistema */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    private String roleName;
    @Column(name = "role", unique = true)
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private Set<User> users;
}
