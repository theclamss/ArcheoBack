package com.watch.watchtogbackend.repository;

import com.watch.watchtogbackend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
     Long findByname(String name);
     Role findRoleById(Long id);
}