package com.eventHive.tickets.eventHive.event.service;

import com.eventHive.tickets.eventHive.event.entity.Event;

public interface EventService {
    Event createEvent(Event event, Long userId);
    int decreaseAvailableSets(Long eventId);
    Event findById(Long eventId);
}
