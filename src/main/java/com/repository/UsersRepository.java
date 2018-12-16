package com.repository;

import com.database.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity,Long> {

    UsersEntity findByLogin(String login);

    UsersEntity findByLoginAndAndPassword(String login, String password);
}
