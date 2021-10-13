package com.microservices.template.users.application.ports.in.user_cases.update_user;

import com.microservices.template.users.application.responses.UpdateUserResponse;

public interface UpdateUserUseCase {
    UpdateUserResponse execute(UpdateUserCommandDTO command);
}
