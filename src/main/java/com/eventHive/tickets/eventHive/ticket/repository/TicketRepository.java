package com.eventHive.tickets.eventHive.ticket.repository;

import com.eventHive.tickets.eventHive.ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository extends JpaRepository<Ticket,Long> {


}
