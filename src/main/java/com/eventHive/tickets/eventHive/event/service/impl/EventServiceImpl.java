package com.eventHive.tickets.eventHive.event.service.impl;

import com.eventHive.tickets.eventHive.event.entity.Event;
import com.eventHive.tickets.eventHive.event.repository.EventRepository;
import com.eventHive.tickets.eventHive.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
}
