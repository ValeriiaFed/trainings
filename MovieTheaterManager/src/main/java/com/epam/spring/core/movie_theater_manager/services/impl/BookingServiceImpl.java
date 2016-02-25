package com.epam.spring.core.movie_theater_manager.services.impl;

import com.epam.spring.core.movie_theater_manager.dao.BookingDAO;
import com.epam.spring.core.movie_theater_manager.entity.*;
import com.epam.spring.core.movie_theater_manager.services.BookingService;
import com.epam.spring.core.movie_theater_manager.services.DiscountService;
import com.epam.spring.core.movie_theater_manager.services.UserService;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class BookingServiceImpl implements BookingService{

    private DiscountService discountService;

    private BookingDAO bookingDAO;

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public DiscountService getDiscountService() {
        return discountService;
    }

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public BookingDAO getBookingDAO() {
        return bookingDAO;
    }

    public void setBookingDAO(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    public double getTicketPrice(Event event, Date date, Seat seat, User user) {
        double ticketPrice = 0;
        double basePrise = event.getBasePrice();
        double discount = discountService.getDiscount(user, event, date);
        ticketPrice = basePrise;
        ticketPrice *=event.getRating().getRate();
        ticketPrice *=seat.getSeatType().getRate();
        return ticketPrice * discount;
    }

    public void bookTicket(User user, Ticket ticket) {
        bookingDAO.bookTicket(user, ticket);
        userService.updateBookedTickets(user, ticket);
    }

    public List<Ticket> getTicketsForEvent(Event event, Date date) {
        throw new UnsupportedOperationException("Method is not implemented yet");
    }
}
