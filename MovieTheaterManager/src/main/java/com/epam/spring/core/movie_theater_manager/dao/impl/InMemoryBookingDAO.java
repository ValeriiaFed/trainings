package com.epam.spring.core.movie_theater_manager.dao.impl;

import com.epam.spring.core.movie_theater_manager.dao.BookingDAO;
import com.epam.spring.core.movie_theater_manager.entity.Event;
import com.epam.spring.core.movie_theater_manager.entity.Ticket;
import com.epam.spring.core.movie_theater_manager.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookingDAO implements BookingDAO {

    private Map<Event, List<Ticket>> bookedTickets;

    public InMemoryBookingDAO() {
        bookedTickets = new HashMap<Event, List<Ticket>>();
    }

    public Map<Event, List<Ticket>> getBookedTickets() {
        return bookedTickets;
    }

    public void setBookedTickets(Map<Event, List<Ticket>> bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

    public void bookTicket(User user, Ticket ticket) {
        List<Ticket> ticketList = bookedTickets.get(ticket.getEvent());
        if (ticketList == null){
            ticketList = new ArrayList<Ticket>();
        }
        ticketList.add(ticket);
        bookedTickets.put(ticket.getEvent(), ticketList);
    }
}
