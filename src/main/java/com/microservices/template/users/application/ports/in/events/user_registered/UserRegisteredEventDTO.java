package com.microservices.template.users.application.ports.in.events.user_registered;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserRegisteredEventDTO {
    @NotNull
    private Long id;

    @NotNull
    private String auth0Id;
}
