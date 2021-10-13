package com.microservices.template.users.application.ports.in.user_cases.retrieve_user;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Valid
public class RetrieveUserQueryDTO {
    @NotNull
    private final Long id;
}
