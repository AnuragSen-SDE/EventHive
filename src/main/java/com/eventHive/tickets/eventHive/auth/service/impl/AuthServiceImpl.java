package com.eventHive.tickets.eventHive.auth.service.impl;

import com.eventHive.tickets.eventHive.auth.entity.SignInRequestDto;
import com.eventHive.tickets.eventHive.auth.entity.SignInResponseDto;
import com.eventHive.tickets.eventHive.auth.entity.SignupRequestDto;
import com.eventHive.tickets.eventHive.auth.service.AuthService;
import com.eventHive.tickets.eventHive.exception.customExcepiton.UserException;
import com.eventHive.tickets.eventHive.security.entity.CustomUserDetails;
import com.eventHive.tickets.eventHive.security.jwt.JwtService;
import com.eventHive.tickets.eventHive.security.service.CustomUserDetailsService;
import com.eventHive.tickets.eventHive.user.entity.User;
import com.eventHive.tickets.eventHive.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

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
    public SignInResponseDto signInUser(SignInRequestDto signInRequestDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    signInRequestDto.getEmail(),
                    signInRequestDto.getPassword()
            ));

            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            String token = jwtService.generateToken(userDetails);
            return SignInResponseDto.builder().token(token).build();
        }catch (AuthenticationException e) {
            e.printStackTrace();
            throw new UserException("Invalid Credentials");
        }
    }

}
