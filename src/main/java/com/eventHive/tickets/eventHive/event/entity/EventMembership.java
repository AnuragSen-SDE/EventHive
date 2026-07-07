package com.eventHive.tickets.eventHive.event.entity;

import com.eventHive.tickets.eventHive.event.entity.type.EventRoles;
import com.eventHive.tickets.eventHive.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "event_membership",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","event_id"})
)
@Getter
@Setter
@Builder
public class EventMembership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id",nullable = false)
    private Event event;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventRoles role;

    private LocalDateTime assignedAt;
}
