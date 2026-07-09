package com.eventHive.tickets.eventHive.ticket.entity.dto;

import com.eventHive.tickets.eventHive.event.entity.Event;
import com.eventHive.tickets.eventHive.event.entity.dto.EventDto;
import com.eventHive.tickets.eventHive.ticket.entity.type.TicketStatus;
import com.eventHive.tickets.eventHive.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TicketDto {

    private TicketStatus ticketStatus;

    private LocalDateTime bookedAt;

    private String ticketCode;

    private EventDto eventDto;
}
