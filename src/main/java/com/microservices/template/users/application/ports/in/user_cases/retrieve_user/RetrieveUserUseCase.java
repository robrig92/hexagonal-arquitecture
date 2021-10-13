package com.microservices.template.users.application.ports.in.user_cases.retrieve_user;

import com.microservices.template.users.application.responses.RetrieveUserResponse;
import javassist.NotFoundException;

public interface RetrieveUserUseCase {
    public RetrieveUserResponse execute(RetrieveUserQueryDTO command) throws NotFoundException;
}
