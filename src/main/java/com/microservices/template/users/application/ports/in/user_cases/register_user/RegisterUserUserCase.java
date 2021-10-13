package com.microservices.template.users.application.ports.in.user_cases.register_user;

import com.microservices.template.users.application.responses.RegisterUserResponse;

public interface RegisterUserUserCase {
    RegisterUserResponse execute(RegisterUserCommandDTO request);
}
