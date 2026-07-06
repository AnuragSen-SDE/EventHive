package com.eventHive.tickets.eventHive.user.service.impl;

import com.eventHive.tickets.eventHive.user.entity.User;
import com.eventHive.tickets.eventHive.user.repository.UserRepository;
import com.eventHive.tickets.eventHive.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}
