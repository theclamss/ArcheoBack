package com.watch.watchtogbackend.service;

import com.watch.watchtogbackend.model.AuthResponseDto;
import com.watch.watchtogbackend.model.LoginRequestDto;
import com.watch.watchtogbackend.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponseDto login(LoginRequestDto request) {








        Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLoginEmail(), request.getLoginPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);


        var user = userRepository.findByEmail(request.getLoginEmail());
        var jwt = jwtService.generateToken(user);
        return AuthResponseDto.builder()
                .token(jwt)
                .build();
    }


}
