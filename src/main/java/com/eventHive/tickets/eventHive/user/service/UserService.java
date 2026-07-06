package com.eventHive.tickets.eventHive.user.service;

import com.eventHive.tickets.eventHive.user.entity.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
