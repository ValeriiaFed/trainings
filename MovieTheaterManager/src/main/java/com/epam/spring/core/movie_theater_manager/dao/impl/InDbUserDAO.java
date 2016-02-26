package com.epam.spring.core.movie_theater_manager.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epam.spring.core.movie_theater_manager.dao.UserDAO;
import com.epam.spring.core.movie_theater_manager.entity.Ticket;
import com.epam.spring.core.movie_theater_manager.entity.User;

public class InDbUserDAO implements UserDAO {

    private static final String CREATE_USER_QUERY = "INSERT INTO USERS (ID, NAME, EMAIL) VALUES (?,?,?)";
    private static final String DELETE_USER_QUERY = "DELETE FROM USERS WHERE ID = ?";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM USERS WHERE ID = ?";
    private static final String SELECT_USER_BY_EMAIL = "SELECT * FROM USERS WHERE EMAIL = ?";
    private static final String SELECT_USER_BY_NAME = "SELECT * FROM USERS WHERE NAME = ?";
    private static final String INSERT_INTO_USER_TICKETS = "INSERT INTO USER_TICKET (USER_ID, TICKET_ID) VALUES (?,?)";
    private static final String ID = "ID";
    private static final String NAME = "NAME";
    private static final String EMAIL = "EMAIL";

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final RowMapper<User> userMapper = new RowMapper<User>() {
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt(ID));
            user.setName(resultSet.getString(NAME));
            user.setEmail(resultSet.getString(EMAIL));
            return user;
        }
    };

    public void createUser(User user) {
        jdbcTemplate.update(CREATE_USER_QUERY, new Object[] { user.getId(), user.getName(), user.getEmail() });
    }

    public void removeUser(User user) {
        jdbcTemplate.update(DELETE_USER_QUERY, new Object[] { user.getId() });
    }

    public User getUserById(int id) {
        return jdbcTemplate.queryForObject(SELECT_USER_BY_ID, new Object[] { id }, userMapper);
    }

    public User getUserByEmail(String email) {
        return jdbcTemplate.queryForObject(SELECT_USER_BY_EMAIL, new Object[] { email }, userMapper);
    }

    public User getUserByName(String name) {
        return jdbcTemplate.queryForObject(SELECT_USER_BY_NAME, new Object[] { name }, userMapper);
    }

    public void updateBookedTickets(User user, Ticket ticket) {
        jdbcTemplate.update(INSERT_INTO_USER_TICKETS, new Object[] { user.getId(), ticket.getId() });
    }

}
