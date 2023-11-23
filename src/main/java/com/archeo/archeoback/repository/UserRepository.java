package com.watch.watchtogbackend.repository;

import com.watch.watchtogbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserName(String name);

    boolean existsByEmail(String email);

    UserDetails findByEmail(String email);
    User findUserByEmail(String email);

    User findUserById(Long id);

    User findUserByUserName(String username);





}