package com.microservices.template.shared.broadcasters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.template.shared.contracts.Emitter;
import com.microservices.template.shared.broadcasters.events.UserRegisteredEvent;

public class UserRegisteredBroadcaster implements Broadcaster<UserRegisteredEvent> {
    private final Emitter emitter;

    public UserRegisteredBroadcaster(Emitter emitter) {
        this.emitter = emitter;
    }

    @Override
    public void broadcast(String queue, UserRegisteredEvent message) {
        try {
            message.setId(1L);
            message.setAuth0Id("12345678900987654321abfc");

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(message);
            emitter.sendMessage(queue, json);
            System.out.printf("Pushing the message %s to the queue %s%n", json, queue);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
