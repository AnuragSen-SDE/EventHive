package com.eventHive.tickets.eventHive.user.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "name_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isActive;
}
