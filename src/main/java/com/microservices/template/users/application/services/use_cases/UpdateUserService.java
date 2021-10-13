package com.microservices.template.users.application.services.use_cases;

import com.microservices.template.users.application.ports.in.user_cases.update_user.UpdateUserCommandDTO;
import com.microservices.template.users.application.ports.out.LoadUserPort;
import com.microservices.template.users.application.ports.out.UpdateUserPort;
import com.microservices.template.users.domain.User;
import com.microservices.template.users.application.responses.UpdateUserResponse;
import com.microservices.template.users.application.ports.in.user_cases.update_user.UpdateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService implements UpdateUserUseCase {
    @Autowired
    private LoadUserPort loadUserPort;

    @Autowired
    private UpdateUserPort updateUserPort;

    @Override
    public UpdateUserResponse execute(UpdateUserCommandDTO command) {
        User found = loadUserPort.loadUser(command.getId());

        if (null == found) {
            return null;
        }

        found.setFirstName(command.getFirstName() == null ? found.getFirstName() : command.getFirstName());
        found.setLastName(command.getLastName() == null ? found.getLastName() : command.getLastName());

        updateUserPort.updateUser(found);

        return UpdateUserResponse.from(found);
    }
}
