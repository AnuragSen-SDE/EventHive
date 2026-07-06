package com.eventHive.tickets.eventHive.auth.service;

import com.eventHive.tickets.eventHive.auth.entity.SignupRequestDto;

public interface AuthService {
    void signupUser(SignupRequestDto signupRequestDto);
    void signInUser(SignupRequestDto signupRequestDto);
}
