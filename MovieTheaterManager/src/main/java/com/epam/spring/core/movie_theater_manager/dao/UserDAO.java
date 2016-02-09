package com.epam.spring.core.movie_theater_manager.dao;

import com.epam.spring.core.movie_theater_manager.entity.User;

public interface UserDAO extends DAO {
    void createUser(User user);

    void removeUser(User user);

    User getUserById(int id);

    User getUserByEmail(String email);

    User getUserByName(String name);

}
