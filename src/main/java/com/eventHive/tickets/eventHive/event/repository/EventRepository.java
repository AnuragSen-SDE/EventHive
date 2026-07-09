package com.eventHive.tickets.eventHive.event.repository;

import com.eventHive.tickets.eventHive.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
