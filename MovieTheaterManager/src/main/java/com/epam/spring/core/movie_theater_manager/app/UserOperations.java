package com.epam.spring.core.movie_theater_manager.app;

import asg.cliche.Command;
import asg.cliche.Param;
import com.epam.spring.core.movie_theater_manager.entity.Ticket;
import com.epam.spring.core.movie_theater_manager.entity.User;
import com.epam.spring.core.movie_theater_manager.services.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserOperations {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Command
    public User registerUser(@Param(name = "userName")
                             String userName,
                             @Param(name = "email")
                             String email,
                             @Param(name = "date")
                             String dateString
    ) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        Date date = ft.parse(dateString);
        User user = new User(userName, email, date);
        getUserService().register(user);
        return user;
    }

    @Command
    public void removeUser(@Param(name = "id")
                           int id) {
        getUserService().removeUserById(getUserService().getById(id));
    }

    @Command
    public User getUserById(@Param(name = "id")
                            int id) {
        return getUserService().getById(id);
    }

    @Command
    public User getUserByEmail(@Param(name = "email")
                               String email) {
        return getUserService().getUserByEmail(email);
    }

    @Command
    public User getUserByName(@Param(name = "name")
                              String name) {
        return getUserService().getUserByName(name);
    }

    @Command
    public List<Ticket> getBookedTickets(@Param(name = "id")
                           int id) {
        return getUserService().getById(id).getBookedTickets();
    }
}

