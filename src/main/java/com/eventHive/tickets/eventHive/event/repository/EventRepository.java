package com.eventHive.tickets.eventHive.event.repository;

import com.eventHive.tickets.eventHive.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event,Long> {

    @Modifying
    @Query("UPDATE Event e SET e.availableSeats = e.availableSeats - 1 WHERE e.id = :eventId AND e.availableSeats > 0")
    int decrementAvailableSeats( @Param("eventId") Long eventId);
}
