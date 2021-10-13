package com.microservices.template.shared.contracts;

public interface Listener<T> {
    public Void handle(T message);
}
