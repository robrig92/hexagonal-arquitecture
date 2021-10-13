package com.microservices.template.users.application.responses;

import lombok.Data;

@Data
public class RetrieveUserResponse {
    private User user;

    private RetrieveUserResponse(User user) {
        this.user = user;
    }

    public static RetrieveUserResponse from(com.microservices.template.users.domain.User entity) {
        User user = new User();

        user.setId(entity.getId());
        user.setFirstName(entity.getFirstName());
        user.setLastName(entity.getLastName());
        user.setEmail(entity.getEmail());
        user.setFullName(entity.fullName());

        return new RetrieveUserResponse(user);
    }

    @Data
    public static class User {
        private Long id;
        private String firstName;
        private String lastName;
        private String fullName;
        private String email;
    }
}
