package com.eventHive.tickets.eventHive.ticket.mapper;

import com.eventHive.tickets.eventHive.event.mapper.EventMapper;
import com.eventHive.tickets.eventHive.ticket.entity.Ticket;
import com.eventHive.tickets.eventHive.ticket.entity.dto.TicketDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {EventMapper.class})
public interface TicketMapper {

    @Mapping(source = "event" , target = "eventDto")
    TicketDto toDto(Ticket ticket);
}
