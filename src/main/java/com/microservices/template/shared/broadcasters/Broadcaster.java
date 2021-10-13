package com.microservices.template.shared.broadcasters;

public interface Broadcaster<T> {
    public void broadcast(String queue, T message);
}
