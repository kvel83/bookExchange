package com.example.bookExchange.service;

import com.example.bookExchange.dto.RoleDTO;
import com.example.bookExchange.dto.UserDTO;
import com.example.bookExchange.entity.Role;
import com.example.bookExchange.entity.User;
import com.example.bookExchange.repository.RoleRepository;
import com.example.bookExchange.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public List<RoleDTO> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        List<RoleDTO> roleDTOS = new ArrayList<RoleDTO>();
        if (roles.size() > 0){
            for (Role role:roles){
                roleDTOS.add(Util.convertToRoleDTO(role));
            }
        }
        return roleDTOS;
    }

    //public List<Role> getAllRoles(){
    //    return roleRepository.findAll();
    //}

    public Optional<Role> getRole(Long id){
        return roleRepository.findById(id);
    }

    public void saveRole(Role role){
        roleRepository.save(role);
    }

    public void deleteRole(Long id){
        roleRepository.deleteById(id);
    }

}

