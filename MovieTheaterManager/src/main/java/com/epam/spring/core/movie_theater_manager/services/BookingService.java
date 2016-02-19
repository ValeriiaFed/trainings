package com.epam.spring.core.movie_theater_manager.services;

import java.util.Date;
import java.util.List;

import com.epam.spring.core.movie_theater_manager.entity.Event;
import com.epam.spring.core.movie_theater_manager.entity.Seat;
import com.epam.spring.core.movie_theater_manager.entity.Ticket;
import com.epam.spring.core.movie_theater_manager.entity.User;

public interface BookingService extends Service {

    double getTicketPrice(Event event, Date date, Seat seat, User user);

    void bookTicket(User user, Ticket ticket);

    List<Ticket> getTicketsForEvent(Event event, Date date);
}
