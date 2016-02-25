package com.epam.spring.core.movie_theater_manager.services;

import com.epam.spring.core.movie_theater_manager.entity.Ticket;
import com.epam.spring.core.movie_theater_manager.entity.User;

import java.util.List;

public interface UserService extends Service {

    void register(User user);
    void removeUserById(User user);
    User getById(int id);
    User getUserByEmail(String email);
    User getUserByName(String name);
    void updateBookedTickets(User user, Ticket ticket);
}
