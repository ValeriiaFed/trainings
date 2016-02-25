package com.epam.spring.core.movie_theater_manager.dao.impl;

import com.epam.spring.core.movie_theater_manager.dao.UserDAO;
import com.epam.spring.core.movie_theater_manager.entity.Ticket;
import com.epam.spring.core.movie_theater_manager.entity.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDAO implements UserDAO {

    private Map<Integer, User> users;

    public InMemoryUserDAO() {
        users = new HashMap<Integer, User>();
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }

    public void createUser(User user) {
        users.put(user.getId(), user);
   }

    public void removeUser(User user) {
        users.remove(user.getId());
    }

    public User getUserById(int id) {
        return users.get(id);
    }

    public User getUserByEmail(String email) {
        for (User user: users.values()){
            if (user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public User getUserByName(String name) {
        for (User user: users.values()){
            if (user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    public void updateBookedTickets(User user, Ticket ticket) {

    }
}
