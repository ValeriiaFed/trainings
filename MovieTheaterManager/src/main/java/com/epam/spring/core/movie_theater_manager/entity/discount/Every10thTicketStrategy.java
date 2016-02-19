package com.epam.spring.core.movie_theater_manager.entity.discount;

import com.epam.spring.core.movie_theater_manager.entity.Event;
import com.epam.spring.core.movie_theater_manager.entity.User;

import java.util.Date;

public class Every10thTicketStrategy implements DiscountStrategy {
    public double calculateDiscount(User user, Event event, Date date) {
        if (user.getBookedTickets().size() == 10){
            return 0.5;
        }
        return 0;
    }
}
