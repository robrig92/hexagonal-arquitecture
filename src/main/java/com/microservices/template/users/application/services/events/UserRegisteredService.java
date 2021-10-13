package com.microservices.template.users.application.services.events;

import com.microservices.template.users.application.ports.in.events.user_registered.UserRegisteredEvent;
import com.microservices.template.users.application.ports.in.events.user_registered.UserRegisteredEventDTO;
import org.springframework.stereotype.Component;

@Component
public class UserRegisteredService implements UserRegisteredEvent {
    @Override
    public Void handle(UserRegisteredEventDTO event) {
        System.out.println("Running the UserRegisteredListener");
        return null;
    }
}
