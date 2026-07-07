package com.eventHive.tickets.eventHive.event.service.impl;

import com.eventHive.tickets.eventHive.event.entity.Event;
import com.eventHive.tickets.eventHive.event.entity.EventMembership;
import com.eventHive.tickets.eventHive.event.entity.type.EventRoles;
import com.eventHive.tickets.eventHive.event.repository.EventMembershipRepository;
import com.eventHive.tickets.eventHive.event.repository.EventRepository;
import com.eventHive.tickets.eventHive.event.service.EventService;
import com.eventHive.tickets.eventHive.user.entity.User;
import com.eventHive.tickets.eventHive.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final UserService userService;
    private final EventMembershipRepository eventMembershipRepository;

    @Override
    @Transactional
    public Event createEvent(Event event, Long userId) {
       try{
           User createdBy = userService.findById(userId);

           event.setCreatedAt(LocalDateTime.now());
           event.setCreatedBy(createdBy);
           event.setUpdatedAt(LocalDateTime.now());

           Event savedEvent = eventRepository.save(event);

           EventMembership eventMembership = EventMembership.builder()
                   .user(createdBy)
                   .event(savedEvent)
                   .role(EventRoles.ORGANISER)
                   .assignedAt(LocalDateTime.now())
                   .build();

           eventMembershipRepository.save(eventMembership);

           return savedEvent;

        }catch (Exception e){

        }

    }
}
