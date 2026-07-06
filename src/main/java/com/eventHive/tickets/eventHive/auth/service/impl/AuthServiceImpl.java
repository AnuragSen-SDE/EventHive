package com.eventHive.tickets.eventHive.auth.service.impl;

import com.eventHive.tickets.eventHive.auth.entity.SignupRequestDto;
import com.eventHive.tickets.eventHive.auth.service.AuthService;
import com.eventHive.tickets.eventHive.exception.customExcepiton.UserException;
import com.eventHive.tickets.eventHive.user.entity.User;
import com.eventHive.tickets.eventHive.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signupUser(SignupRequestDto signupRequestDto) {
        if (userService.existsByEmail(signupRequestDto.getEmail())) throw new UserException("User Already Exist With this email ");
        User user = User.builder()
                .email(signupRequestDto.getEmail())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .isActive(true)
                .build();
        user = userService.saveUser(user);
    }

    @Override
    public void signInUser(SignupRequestDto signupRequestDto) {

    }
}
