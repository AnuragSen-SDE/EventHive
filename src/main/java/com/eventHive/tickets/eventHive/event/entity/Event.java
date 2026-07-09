package com.eventHive.tickets.eventHive.event.entity;

import com.eventHive.tickets.eventHive.event.entity.type.EventStatus;
import com.eventHive.tickets.eventHive.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String eventCode;

    @Column(nullable = false)
    private String venue;

    @Column(nullable = false)
    private Integer totalSeats;

    @Column(nullable = false)
    private Double price;

//    @Column(nullable = false)
    private Integer availableSeats;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventStatus status;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "created_by")
    private User createdBy;

}
