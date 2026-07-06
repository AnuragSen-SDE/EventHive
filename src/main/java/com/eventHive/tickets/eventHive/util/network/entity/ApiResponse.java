package com.eventHive.tickets.eventHive.util.network.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ApiResponse {
    private int status;
    private String message;
    private Object data;
}
