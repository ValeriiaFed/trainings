package com.epam.spring.core.movie_theater_manager.services.impl;

import com.epam.spring.core.movie_theater_manager.dao.UserDAO;
import com.epam.spring.core.movie_theater_manager.entity.Ticket;
import com.epam.spring.core.movie_theater_manager.entity.User;
import com.epam.spring.core.movie_theater_manager.services.UserService;

public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void register(User user) {
        userDAO.createUser(user);
    }

    public void removeUserById(User user) {
        userDAO.removeUser(user);
    }

    public User getById(int id) {
        return userDAO.getUserById(id);
    }

    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    public User getUserByName(String name) {
        return userDAO.getUserByName(name);
    }

    public void updateBookedTickets(User user, Ticket ticket) {
        userDAO.updateBookedTickets(user, ticket);
    }

}
