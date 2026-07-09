package com.eventHive.tickets.eventHive.event.entity.dto;

import com.eventHive.tickets.eventHive.event.entity.type.EventStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EventDto {

    @NotBlank(message = "Event title should not be null")
    private String title;


    private String description;

    @NotBlank(message = "Venue is compulsory")
    private String venue;

    @NotBlank(message = "Total seat count cannot be empty")
    private Integer totalSeats;

    private String eventCode;

    @NotBlank(message = "Price data can't be empty")
    private Double price;

}
