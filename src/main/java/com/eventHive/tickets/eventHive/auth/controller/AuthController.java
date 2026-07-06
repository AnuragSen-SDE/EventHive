package com.eventHive.tickets.eventHive.auth.controller;

import com.eventHive.tickets.eventHive.auth.entity.SignupRequestDto;
import com.eventHive.tickets.eventHive.auth.service.AuthService;
import com.eventHive.tickets.eventHive.user.service.UserService;
import com.eventHive.tickets.eventHive.util.network.entity.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signupUser(
            @Valid @RequestBody SignupRequestDto signupRequestDto
            ) {

        authService.signupUser(signupRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.CREATED.value())
                                .message("Account created with email : " + signupRequestDto.getEmail())
                                .build()
                );
    }
}
