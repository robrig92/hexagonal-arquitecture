package com.microservices.template.users.infrastructure.out.persistance.mappers;

import com.microservices.template.shared.repositories.repositories.daos.UserDAO;
import com.microservices.template.users.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User dao2Entity(UserDAO dao) {
        User entity = new User();

        entity.setId(dao.getId());
        entity.setFirstName(dao.getFirstName());
        entity.setLastName(dao.getLastName());
        entity.setEmail(dao.getUsername());
        entity.setAuth0Id(dao.getAuth0Id());
        entity.setActive(dao.isActive());

        return entity;
    }

    public UserDAO entity2Dao(User entity) {
        UserDAO dao = new UserDAO();

        dao.setId(entity.getId());
        dao.setFirstName(entity.getFirstName());
        dao.setLastName(entity.getLastName());
        dao.setUsername(entity.getEmail());
        dao.setAuth0Id(entity.getAuth0Id());
        dao.setActive(entity.isActive());

        return dao;
    }
}
