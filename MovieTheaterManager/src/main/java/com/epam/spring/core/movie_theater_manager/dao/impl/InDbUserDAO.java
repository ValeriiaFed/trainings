package com.epam.spring.core.movie_theater_manager.dao.impl;

import javax.sql.DataSource;

import com.epam.spring.core.movie_theater_manager.entity.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.spring.core.movie_theater_manager.dao.UserDAO;
import com.epam.spring.core.movie_theater_manager.entity.User;

public class InDbUserDAO implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createUser(User user) {

        String query = "INSERT INTO USERS (ID, NAME, EMAIL) VALUES (?,?,?)";

        jdbcTemplate.update(query, new Object[] { user.getId(), user.getName(), user.getEmail() });
    }

    public void removeUser(User user) {
        // users.remove(user.getId());
    }

    public User getUserById(int id) {
        // return users.get(id);
        return null;
    }

    public User getUserByEmail(String email) {
        // for (User user : users.values()) {
        // if (user.getEmail().equals(email)) {
        // return user;
        // }
        // }
        return null;
    }

    public User getUserByName(String name) {
        // for (User user : users.values()) {
        // if (user.getName().equals(name)) {
        // return user;
        // }
        // }
        return null;
    }

    public void updateBookedTickets(User user, Ticket ticket) {

        String query = "INSERT INTO USER_TICKET (USER_ID, TICKET_ID) VALUES (?,?)";

        jdbcTemplate.update(query, new Object[] { user.getId(), ticket.getId()});
    }

}
