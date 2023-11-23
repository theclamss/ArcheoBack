package com.watch.watchtogbackend.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.watch.watchtogbackend.model.*;
import com.watch.watchtogbackend.repository.RoleRepository;
import com.watch.watchtogbackend.repository.UserRepository;
import com.watch.watchtogbackend.service.AuthService;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)


public class Login {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    AuthService authService;


    @PostMapping(path = "/register", consumes = "application/json")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){

        Role role = roleRepository.findRoleById(1L);
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User(
                registerRequest.getId(),
                registerRequest.getUserName(),
                registerRequest.getEmail(),
                encoder.encode(registerRequest.getPassword()),
                registerRequest.getAddress(),
                roles
        );

        if(userRepository.existsByUserName(user.getUsername())){
            return ResponseEntity.badRequest().body("Error: Name is already taken");
        }

        if(userRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.badRequest().body("Error: Email is already taken");
        }

        userRepository.save(user);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @PostMapping(path = "/login", consumes = "application/json")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto ){

            User user=userRepository.findUserByEmail(loginRequestDto.getLoginEmail());
            System.out.println(user);

        if(!userRepository.existsByEmail(loginRequestDto.getLoginEmail())){

            return ResponseEntity.badRequest().body("Error: aucun compte avec cet username");
        }



        return ResponseEntity.ok(authService.login(loginRequestDto));
    }





}


