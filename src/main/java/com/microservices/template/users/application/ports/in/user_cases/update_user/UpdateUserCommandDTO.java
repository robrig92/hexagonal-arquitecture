package com.microservices.template.users.application.ports.in.user_cases.update_user;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateUserCommandDTO {
    @NotNull
    private final Long id;
    private final String firstName;
    private final String lastName;
}
