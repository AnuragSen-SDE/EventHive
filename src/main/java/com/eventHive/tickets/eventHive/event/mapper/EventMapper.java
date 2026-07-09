package com.eventHive.tickets.eventHive.event.mapper;

import com.eventHive.tickets.eventHive.event.entity.Event;
import com.eventHive.tickets.eventHive.event.entity.dto.EventDto;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;
@Mapper(componentModel = "spring")
public interface EventMapper {
    EventDto toDto(Event event);

    Event toEntity(EventDto eventDto);
}
