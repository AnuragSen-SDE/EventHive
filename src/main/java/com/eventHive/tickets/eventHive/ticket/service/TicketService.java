package com.eventHive.tickets.eventHive.ticket.service;

import com.eventHive.tickets.eventHive.ticket.entity.Ticket;

public interface TicketService {
    Ticket bookTicket(Long eventId );
}
