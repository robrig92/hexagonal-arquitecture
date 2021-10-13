package com.microservices.template.shared.contracts;

public interface Emitter {
    public void sendMessage(String channel, String event);
}
