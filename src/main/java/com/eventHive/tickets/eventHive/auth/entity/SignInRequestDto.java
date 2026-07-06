package com.eventHive.tickets.eventHive.auth.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignInRequestDto {

    @NotBlank(message = "Email can't be empty")
    private final String email;

    @NotBlank(message = "Password can't be empty")
    private final String password;

}
