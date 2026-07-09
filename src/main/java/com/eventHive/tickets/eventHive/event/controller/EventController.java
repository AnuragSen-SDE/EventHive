package com.eventHive.tickets.eventHive.event.controller;

import com.eventHive.tickets.eventHive.event.entity.Event;
import com.eventHive.tickets.eventHive.event.entity.dto.EventDto;
import com.eventHive.tickets.eventHive.event.mapper.EventMapper;
import com.eventHive.tickets.eventHive.event.service.EventService;
import com.eventHive.tickets.eventHive.util.network.entity.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final EventMapper eventMapper;

    @PostMapping("/{user_id}")
    public ResponseEntity<ApiResponse> createEvent(
            @Valid @RequestBody EventDto eventDto,
            @PathVariable(name = "user_id") Long user_id
            ) {
        Event event = eventService.createEvent(eventMapper.toEntity(eventDto),user_id);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.CREATED.value())
                                .message("Event created Successfully ")
                                .data(eventMapper.toDto(event))
                                .build()
                );
    }

}
