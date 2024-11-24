package com.kt.diagon.service;

import com.kt.diagon.models.Roles;
import com.kt.diagon.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Roles> getAllRoles() {
        return roleRepository.findAll();
    }
}
