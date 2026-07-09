package com.eventHive.tickets.eventHive.ticket.entity;

import com.eventHive.tickets.eventHive.event.entity.Event;
import com.eventHive.tickets.eventHive.ticket.entity.type.TicketStatus;
import com.eventHive.tickets.eventHive.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    @CreationTimestamp
    private LocalDateTime bookedAt;

    @Column(nullable = false)
    private String ticketCode;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
