package com.eventHive.tickets.eventHive.ticket.service.impl;

import com.eventHive.tickets.eventHive.event.entity.Event;
import com.eventHive.tickets.eventHive.event.service.EventService;
import com.eventHive.tickets.eventHive.exception.customExcepiton.EventException;
import com.eventHive.tickets.eventHive.exception.customExcepiton.UserException;
import com.eventHive.tickets.eventHive.security.entity.CustomUserDetails;
import com.eventHive.tickets.eventHive.ticket.entity.Ticket;
import com.eventHive.tickets.eventHive.ticket.entity.type.TicketStatus;
import com.eventHive.tickets.eventHive.ticket.repository.TicketRepository;
import com.eventHive.tickets.eventHive.ticket.service.TicketService;
import com.eventHive.tickets.eventHive.user.entity.User;
import com.eventHive.tickets.eventHive.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final UserService userService;
    private final EventService eventService;

    @Transactional
    @Override
    public Ticket bookTicket(Long eventId) {
        //User user = userService.findById(userId);
        String  userName =( (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        User user = userService.findByEmail(userName).orElseThrow(() -> new UserException("User Not Found"));
        Event event = eventService.findById(eventId);
        if (eventService.decreaseAvailableSets(eventId) == 0 ) throw new EventException("No Seats Available for event : " +eventId);

        Ticket ticket = Ticket.builder()
                .ticketStatus(TicketStatus.BOOKED)
                .ticketCode("aaabbb")
                .event(event)
                .user(user)
                .build();

        return ticketRepository.save(ticket);
    }
}
