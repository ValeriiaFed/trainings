package com.epam.spring.core.movie_theater_manager.services;

import com.epam.spring.core.movie_theater_manager.entity.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface BookingService extends Service {

    double getTicketPrice(Event event, Date date, Time time, Seat seat, User user);
    void bookTicket(User user, Ticket ticket);
    List<Ticket> getTicketsForEvent(Event event, Date date);
}
