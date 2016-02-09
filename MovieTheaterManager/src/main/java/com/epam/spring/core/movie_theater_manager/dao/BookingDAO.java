package com.epam.spring.core.movie_theater_manager.dao;

import com.epam.spring.core.movie_theater_manager.entity.Ticket;
import com.epam.spring.core.movie_theater_manager.entity.User;

public interface BookingDAO extends DAO {

    void bookTicket(User user, Ticket ticket);
}
