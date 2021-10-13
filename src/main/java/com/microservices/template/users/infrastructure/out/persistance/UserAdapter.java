package com.microservices.template.users.infrastructure.out.persistance;

import com.microservices.template.users.application.ports.out.LoadUserPort;
import com.microservices.template.users.application.ports.out.StoreUserPort;
import com.microservices.template.users.application.ports.out.UpdateUserPort;
import com.microservices.template.users.domain.User;
import com.microservices.template.users.infrastructure.out.persistance.mappers.UserMapper;
import com.microservices.template.shared.repositories.repositories.JPAUserRepository;
import com.microservices.template.shared.repositories.repositories.daos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAdapter implements
        LoadUserPort,
        UpdateUserPort,
        StoreUserPort {
    @Autowired
    private JPAUserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User loadUser(Long id) {
        Optional<UserDAO> found = userRepository.findById(id);
        return found.map(userDAO -> userMapper.dao2Entity(userDAO)).orElse(null);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(userMapper.entity2Dao(user));
    }

    @Override
    public User storeUser(User user) {
        UserDAO stored = userRepository.save(userMapper.entity2Dao(user));
        return userMapper.dao2Entity(stored);
    }
}
