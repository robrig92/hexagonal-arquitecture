package com.microservices.template.users.application.responses;

import com.microservices.template.users.domain.User;
import lombok.Data;

@Data
public class UpdateUserResponse {
    private String firstName;
    private String lastName;
    private String email;

    public static UpdateUserResponse from(User user) {
        UpdateUserResponse response = new UpdateUserResponse();
        response.setEmail(user.getEmail());
        response.setLastName(user.getLastName());
        response.setFirstName(user.getFirstName());

        return response;
    }
}
