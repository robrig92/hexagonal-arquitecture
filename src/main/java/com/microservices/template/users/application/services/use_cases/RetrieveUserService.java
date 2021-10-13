package com.microservices.template.users.application.services.use_cases;

import com.microservices.template.users.application.ports.in.user_cases.retrieve_user.RetrieveUserQueryDTO;
import com.microservices.template.users.application.ports.out.LoadUserPort;
import com.microservices.template.users.domain.User;
import com.microservices.template.users.application.responses.RetrieveUserResponse;
import com.microservices.template.users.application.ports.in.user_cases.retrieve_user.RetrieveUserUseCase;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetrieveUserService implements RetrieveUserUseCase {
    @Autowired
    private LoadUserPort loadUserPort;

    @Override
    public RetrieveUserResponse execute(RetrieveUserQueryDTO command) throws NotFoundException {
        User found = loadUserPort.loadUser(command.getId());

        if (null == found) {
            throw new NotFoundException("User not found");
        }

        return RetrieveUserResponse.from(found);
    }
}
