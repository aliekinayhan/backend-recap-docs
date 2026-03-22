package com.ayhanekin.JWT.service;

import com.ayhanekin.JWT.dto.request.LoginRequest;
import com.ayhanekin.JWT.dto.request.RegisterRequest;
import com.ayhanekin.JWT.entity.Role;
import com.ayhanekin.JWT.entity.User;
import com.ayhanekin.JWT.repo.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {
    private final UserRepo repo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager manager;

    public AuthService(UserRepo repo, PasswordEncoder encoder, AuthenticationManager manager) {
        this.repo = repo;
        this.encoder = encoder;
        this.manager = manager;
    }

    public String login(LoginRequest request) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()
                )
        );
        return "Welcome Back...";
    }

    public String register (RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build();
        repo.save(user);
        return "User Created...";
    }

}
