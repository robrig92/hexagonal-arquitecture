package com.microservices.template.users.infrastructure.in.brokers;

import lombok.Data;

@Data
public class RegisteredUserEventDTO {
    private Long id;
    private String auth0Id;
}
