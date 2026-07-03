package com.eventHive.tickets.eventHive.security.service;

import com.eventHive.tickets.eventHive.security.entity.CustomUserDetails;
import com.eventHive.tickets.eventHive.user.entity.User;
import com.eventHive.tickets.eventHive.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Invalid Credentials"));
        return new CustomUserDetails(user);
    }
}
