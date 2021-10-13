package com.microservices.template.users.application.ports.in.events.user_registered;

public interface UserRegisteredEvent {
    public Void handle(UserRegisteredEventDTO event);
}
