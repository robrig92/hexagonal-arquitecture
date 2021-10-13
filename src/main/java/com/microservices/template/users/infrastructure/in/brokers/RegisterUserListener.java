package com.microservices.template.users.infrastructure.in.brokers;

import com.microservices.template.users.application.ports.in.events.user_registered.UserRegisteredEvent;
import com.microservices.template.users.application.ports.in.events.user_registered.UserRegisteredEventDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserListener {
    @Autowired
    private UserRegisteredEvent userRegisteredEvent;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public Void handle(RegisteredUserEventDTO message) {
        System.out.println(message);

        UserRegisteredEventDTO eventDTO = new UserRegisteredEventDTO();
        eventDTO.setId(message.getId());
        eventDTO.setAuth0Id(message.getAuth0Id());

        userRegisteredEvent.handle(eventDTO);

        return null;
    }
}
