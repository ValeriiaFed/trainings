package com.epam.spring.core.movie_theater_manager.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.spring.core.movie_theater_manager.dao.BookingDAO;
import com.epam.spring.core.movie_theater_manager.entity.Ticket;
import com.epam.spring.core.movie_theater_manager.entity.User;

public class InDbBookingDAO implements BookingDAO {

    public static final String BOOK_TICKET_QUERY = "INSERT INTO TICKET (ID, PRICE, EVENT_ID, SEAT_ID) VALUES(?, ?, ?, ?)";

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void bookTicket(User user, Ticket ticket) {
        jdbcTemplate.update(BOOK_TICKET_QUERY, new Object[] { ticket.getId(), ticket.getPrice(), ticket.getEvent().getId(), ticket.getSeat().getId() });
    }
}
