package com.microservices.template.users.application.responses;

import lombok.Data;

@Data
public class RegisterUserResponse {
    private final User user;
    private final String message;

    private RegisterUserResponse(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public static RegisterUserResponse from(com.microservices.template.users.domain.User entityUser, String message) {
        User user = new User();

        user.setId(entityUser.getId());
        user.setFirstName(entityUser.getFirstName());
        user.setLastName(entityUser.getLastName());
        user.setEmail(entityUser.getEmail());

        return new RegisterUserResponse(user, message);
    }

    @Data
    static class User {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
    }
}
