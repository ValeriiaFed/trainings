package com.epam.spring.core.movie_theater_manager.entity.discount;

import com.epam.spring.core.movie_theater_manager.entity.Event;
import com.epam.spring.core.movie_theater_manager.entity.User;

import java.util.Date;

/**
 * Created by Valeriia_Fed on 05.02.2016.
 */
public interface DiscountStrategy {

    double calculateDiscount(User user, Event event, Date date);
}
