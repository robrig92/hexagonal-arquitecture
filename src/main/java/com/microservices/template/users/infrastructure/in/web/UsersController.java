package com.microservices.template.users.infrastructure.in.web;

import com.microservices.template.shared.utils.Validator;
import com.microservices.template.users.application.ports.in.user_cases.register_user.RegisterUserCommandDTO;
import com.microservices.template.users.application.ports.in.user_cases.register_user.RegisterUserUserCase;
import com.microservices.template.users.application.ports.in.user_cases.retrieve_user.RetrieveUserQueryDTO;
import com.microservices.template.users.application.ports.in.user_cases.retrieve_user.RetrieveUserUseCase;
import com.microservices.template.users.application.ports.in.user_cases.update_user.UpdateUserCommandDTO;
import com.microservices.template.users.application.ports.in.user_cases.update_user.UpdateUserUseCase;
import com.microservices.template.users.application.responses.UpdateUserResponse;
import com.microservices.template.users.infrastructure.requests.RegisterUserRequest;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class UsersController {
    @Autowired
    private RegisterUserUserCase registerUserUserCase;

    @Autowired
    private RetrieveUserUseCase retrieveUserUseCase;

    @Autowired
    private UpdateUserUseCase updateUserUseCase;

    @PostMapping("/users")
    public Object create(@RequestBody RegisterUserRequest request) {
        RegisterUserCommandDTO command = new RegisterUserCommandDTO(request.getFirstName(), request.getLastName(), request.getEmail());

        Validator<RegisterUserCommandDTO> validator = new Validator<>();
        Set<ConstraintViolation<RegisterUserCommandDTO>> errors = validator.validate(command);

        if (!errors.isEmpty()) {
            for (ConstraintViolation<RegisterUserCommandDTO> violation : errors) {
                System.out.printf("%s: %s%n", violation.getPropertyPath(), violation.getMessage());
            }

            return null;
        }

        return registerUserUserCase.execute(command);
    }

    @GetMapping("/users/{id}")
    public Object show(@PathVariable(name = "id") Long id) {
        RetrieveUserQueryDTO command = new RetrieveUserQueryDTO(id);

        Validator<RetrieveUserQueryDTO> validator = new Validator<>();
        Set<ConstraintViolation<RetrieveUserQueryDTO>> errors = validator.validate(command);

        if (!errors.isEmpty()) {
            for (ConstraintViolation<RetrieveUserQueryDTO> violation : errors) {
                System.out.printf("%s: %s%n", violation.getPropertyPath(), violation.getMessage());
            }

            return null;
        }

        try {
            return retrieveUserUseCase.execute(command);
        } catch (NotFoundException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    @PutMapping("/users/{id}")
    public Object update(@PathVariable(name = "id") Long id, @RequestBody RegisterUserRequest request) {
        UpdateUserCommandDTO command = new UpdateUserCommandDTO(id, request.getFirstName(), request.getLastName());

        Validator<UpdateUserCommandDTO> validator = new Validator<>();
        Set<ConstraintViolation<UpdateUserCommandDTO>> errors = validator.validate(command);

        if (!errors.isEmpty()) {
            for (ConstraintViolation<UpdateUserCommandDTO> violation : errors) {
                System.out.printf("%s: %s%n", violation.getPropertyPath(), violation.getMessage());
            }

            return null;
        }

        UpdateUserResponse result = updateUserUseCase.execute(command);

        if (result == null) {
            return new UsersController.ErrorResponse(null, "Nothing found");
        }

        return result;
    }

    @Data
    @AllArgsConstructor
    public static class ErrorResponse {
        private Set<ConstraintViolation<RegisterUserCommandDTO>> errors;
        private String message;
    }
}
