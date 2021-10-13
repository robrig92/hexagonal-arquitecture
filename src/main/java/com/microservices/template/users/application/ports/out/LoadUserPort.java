package com.microservices.template.users.application.ports.out;

import com.microservices.template.users.domain.User;

public interface LoadUserPort {
    User loadUser(Long id);
}
