package com.epam.spring.core.movie_theater_manager.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.spring.core.movie_theater_manager.dao.BookingDAO;
import com.epam.spring.core.movie_theater_manager.entity.Event;
import com.epam.spring.core.movie_theater_manager.entity.Ticket;
import com.epam.spring.core.movie_theater_manager.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class InDbBookingDAO implements BookingDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void bookTicket(User user, Ticket ticket) {

        String query = "INSERT INTO TICKET (ID, PRICE, EVENT_ID, SEAT_ID) VALUES(?, ?, ?, ?)";

        jdbcTemplate.update(query, new Object[] { ticket.getId(), ticket.getPrice(), ticket.getEvent().getId(), ticket.getSeat().getId()});
    }
}
