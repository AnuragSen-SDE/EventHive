package com.eventHive.tickets.eventHive.auth.service;

import com.eventHive.tickets.eventHive.auth.entity.SignInRequestDto;
import com.eventHive.tickets.eventHive.auth.entity.SignInResponseDto;
import com.eventHive.tickets.eventHive.auth.entity.SignupRequestDto;

public interface AuthService {
    void signupUser(SignupRequestDto signupRequestDto);
    SignInResponseDto signInUser(SignInRequestDto signInRequestDto);
}
