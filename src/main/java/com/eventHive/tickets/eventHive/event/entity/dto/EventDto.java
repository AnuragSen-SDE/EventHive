package com.eventHive.tickets.eventHive.event.entity.dto;

import com.eventHive.tickets.eventHive.event.entity.type.EventStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EventDto {

    private String Title;


    private String description;


    private String venue;


    private Integer totalSeats;


    private Integer bookedSeats;


    private String price;


    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventStatus status;
}
