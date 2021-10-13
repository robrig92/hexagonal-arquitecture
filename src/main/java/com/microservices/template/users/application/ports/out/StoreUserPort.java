package com.microservices.template.users.application.ports.out;

import com.microservices.template.users.domain.User;

public interface StoreUserPort {
    User storeUser(User user);
}
