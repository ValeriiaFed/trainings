package com.epam.spring.core.movie_theater_manager.services;

import com.epam.spring.core.movie_theater_manager.entity.Event;
import com.epam.spring.core.movie_theater_manager.entity.User;

import java.util.Date;

public interface DiscountService extends Service {
    double getDiscount(User user, Event event, Date date);
}
