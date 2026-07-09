package com.eventHive.tickets.eventHive.event.entity.dto;

import com.eventHive.tickets.eventHive.event.entity.type.EventStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @Min(0)
    private Integer totalSeats;

    private String eventCode;

    @Min(0)
    private Double price;

}
