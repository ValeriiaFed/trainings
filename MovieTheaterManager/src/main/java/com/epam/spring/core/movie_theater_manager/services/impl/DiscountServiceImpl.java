package com.epam.spring.core.movie_theater_manager.services.impl;

import com.epam.spring.core.movie_theater_manager.entity.discount.DiscountStrategy;
import com.epam.spring.core.movie_theater_manager.entity.Event;
import com.epam.spring.core.movie_theater_manager.entity.User;
import com.epam.spring.core.movie_theater_manager.services.DiscountService;

import java.util.Date;
import java.util.List;

public class DiscountServiceImpl implements DiscountService {


    private List<DiscountStrategy> discountStrategies;

    public List<DiscountStrategy> getDiscountStrategies() {
        return discountStrategies;
    }

    public void setDiscountStrategies(List<DiscountStrategy> discountStrategies) {
        this.discountStrategies = discountStrategies;
    }

    public double getDiscount(User user, Event event, Date date) {
        double discount = 0;
        for (DiscountStrategy strategy: discountStrategies){
            double discountTmp = strategy.calculateDiscount(user, event, date);
            if (discountTmp > discount){
                discount = discountTmp;
            }
        }
        return discount;
    }
}
