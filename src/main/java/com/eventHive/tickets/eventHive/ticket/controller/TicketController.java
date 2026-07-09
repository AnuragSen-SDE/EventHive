package com.eventHive.tickets.eventHive.ticket.controller;

import com.eventHive.tickets.eventHive.ticket.entity.Ticket;
import com.eventHive.tickets.eventHive.ticket.mapper.TicketMapper;
import com.eventHive.tickets.eventHive.ticket.service.TicketService;
import com.eventHive.tickets.eventHive.util.network.entity.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    @PostMapping("/{eventId}/book")
    public ResponseEntity<ApiResponse> bockTicket(
            @PathVariable(name = "eventId") Long eventId
            ) {
        Ticket ticket = ticketService.bookTicket(eventId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.OK.value())
                                .message("Event bocked successfully")
                                .data(ticketMapper.toDto(ticket))
                                .build()
                );
    }

}
