package com.microservices.template.users.domain;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;
    private String auth0Id;

    public void active() {
        this.active = true;
    }

    public String fullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}
