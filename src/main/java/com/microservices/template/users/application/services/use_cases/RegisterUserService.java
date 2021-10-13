package com.microservices.template.users.application.services.use_cases;

import com.microservices.template.shared.broadcasters.Broadcaster;
import com.microservices.template.shared.adapters.Emitter.RabbitMQEmitter;
import com.microservices.template.shared.broadcasters.UserRegisteredBroadcaster;
import com.microservices.template.users.application.ports.in.user_cases.register_user.RegisterUserCommandDTO;
import com.microservices.template.users.application.ports.out.StoreUserPort;
import com.microservices.template.users.domain.User;
import com.microservices.template.shared.broadcasters.events.UserRegisteredEvent;
import com.microservices.template.users.application.responses.RegisterUserResponse;
import com.microservices.template.users.application.ports.in.user_cases.register_user.RegisterUserUserCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService implements RegisterUserUserCase {
    @Autowired
    private StoreUserPort storeUserPort;

    private final String QUEUE = "spring-boot";

    @Override
    public RegisterUserResponse execute(RegisterUserCommandDTO request) {
        User user = new User();

        System.out.println(request);
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.active();

        User registered = storeUserPort.storeUser(user);
        System.out.println(registered);

        Broadcaster<UserRegisteredEvent> broadcaster = new UserRegisteredBroadcaster(new RabbitMQEmitter());
        broadcaster.broadcast(QUEUE, new UserRegisteredEvent());

        return RegisterUserResponse.from(registered, registeredMessage());
    }

    private String registeredMessage() {
        return "User has been registered...";
    }
}
