package com.eventHive.tickets.eventHive.user.repository;

import com.eventHive.tickets.eventHive.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
