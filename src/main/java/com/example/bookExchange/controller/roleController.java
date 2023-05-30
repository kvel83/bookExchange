package com.example.bookExchange.controller;

import com.example.bookExchange.dto.RoleDTO;
import com.example.bookExchange.entity.Role;
import com.example.bookExchange.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/role")
public class roleController {
    @Autowired
    private RoleService roleService;
    @GetMapping
    public List<RoleDTO> getAll(){
        return roleService.getAllRoles();
    }

    @GetMapping("/{roleId}")
    public Optional<Role> getRoleById(@PathVariable("roleId") Long roleId){
        return roleService.getRole(roleId);
    }

    @PostMapping
    public void saveRole(@RequestBody Role role){
        roleService.saveRole(role);
    }

    @DeleteMapping("/delete/{roleId}")
    public void deleteRole(@PathVariable("roleId") Long roleId){
        roleService.deleteRole(roleId);
    }
}
