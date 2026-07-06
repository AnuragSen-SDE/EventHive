package com.eventHive.tickets.eventHive.security.jwt;

import com.eventHive.tickets.eventHive.security.entity.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generateToken(UserDetails userDetails);
    boolean isTokenValid(String token,UserDetails userDetails);
    boolean isTokenExpired(String token);
    String  extractUserName( String token);
}
