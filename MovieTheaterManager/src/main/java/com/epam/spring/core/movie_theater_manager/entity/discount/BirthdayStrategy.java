package com.epam.spring.core.movie_theater_manager.entity.discount;

import com.epam.spring.core.movie_theater_manager.entity.Event;
import com.epam.spring.core.movie_theater_manager.entity.User;

import java.util.Date;

/**
 * Created by Valeriia_Fed on 06.02.2016.
 */
public class BirthdayStrategy implements DiscountStrategy{
    public double calculateDiscount(User user, Event event, Date date) {
        if (user.getBirthday().equals(date)){
            return 0.05;
        }
        return 0;
    }
}
