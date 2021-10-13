package com.microservices.template.shared.repositories.repositories;

import com.microservices.template.shared.repositories.repositories.daos.UserDAO;
import org.springframework.data.repository.CrudRepository;

public interface JPAUserRepository extends CrudRepository<UserDAO, Long> {
}
