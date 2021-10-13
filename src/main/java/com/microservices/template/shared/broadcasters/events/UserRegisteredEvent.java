package com.microservices.template.shared.broadcasters.events;

import lombok.Data;

@Data
public class UserRegisteredEvent {
    private Long id;
    private String auth0Id;
}
