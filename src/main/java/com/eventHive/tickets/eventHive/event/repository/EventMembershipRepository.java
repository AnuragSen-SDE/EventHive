package com.eventHive.tickets.eventHive.event.repository;

import com.eventHive.tickets.eventHive.event.entity.EventMembership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventMembershipRepository extends JpaRepository<EventMembership,Long> {
}
