package com.kt.diagon.repository;

import com.kt.diagon.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<Roles, Long> {
}
