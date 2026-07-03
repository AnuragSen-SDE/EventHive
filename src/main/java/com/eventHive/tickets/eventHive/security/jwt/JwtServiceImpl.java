package com.eventHive.tickets.eventHive.security.jwt;

import com.eventHive.tickets.eventHive.security.entity.CustomUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JwtServiceImpl implements JwtService{

    @Value("${jwt.secret}")
    private  String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Override
    public String generateToken(UserDetails userDetails) {
        CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
        HashMap<String ,Objects> map = new HashMap<>();
        return createToken(map,userDetails);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        Claims claims = extractAllClaims(token);
        return claims.getExpiration().before(new Date()) && claims.getSubject().equals(userDetails.getUsername());
    }

    @Override
    public boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    @Override
    public String extractUserName(String token) {
        return extractAllClaims(token).getSubject();
    }


    private String createToken(Map<String , Objects> clams , UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(clams)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey())
                .compact();
    }

    private Claims extractAllClaims( String token ) {
        return Jwts.parser().setSigningKey(getSigningKey()).build().parseSignedClaims(token).getBody();
    }

    private SecretKey getSigningKey() { return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }
}
