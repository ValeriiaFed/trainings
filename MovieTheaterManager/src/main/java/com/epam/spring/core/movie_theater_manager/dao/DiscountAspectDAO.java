package com.epam.spring.core.movie_theater_manager.dao;


import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.epam.spring.core.movie_theater_manager.entity.Event;
import com.epam.spring.core.movie_theater_manager.entity.User;

public interface DiscountAspectDAO extends DAO {

    Map<String, AtomicInteger> getCounterTotalDiscount();
    Map<User, AtomicInteger> getCounterDiscountByUser();

    void increaseTotalDiscountCounter(String methodName);
    void increaseDiscountCounterByUser(User user);
}
