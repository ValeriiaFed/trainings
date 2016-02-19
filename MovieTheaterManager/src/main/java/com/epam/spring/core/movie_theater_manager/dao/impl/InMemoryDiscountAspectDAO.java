package com.epam.spring.core.movie_theater_manager.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.epam.spring.core.movie_theater_manager.dao.DiscountAspectDAO;
import com.epam.spring.core.movie_theater_manager.entity.Event;
import com.epam.spring.core.movie_theater_manager.entity.User;

public class InMemoryDiscountAspectDAO implements DiscountAspectDAO {

    private Map<String, AtomicInteger> counterTotalDiscount;
    private Map<User, AtomicInteger> counterDiscountByUser;

    public InMemoryDiscountAspectDAO() {
        counterTotalDiscount = new HashMap<String, AtomicInteger>();
        counterDiscountByUser = new HashMap<User, AtomicInteger>();
    }

    public Map<User, AtomicInteger> getCounterDiscountByUser() {
        return counterDiscountByUser;
    }

    public void setCounterDiscountByUser(Map<User, AtomicInteger> counterDiscountByUser) {
        this.counterDiscountByUser = counterDiscountByUser;
    }

    public Map<String, AtomicInteger> getCounterTotalDiscount() {
        return counterTotalDiscount;
    }

    public void setCounterTotalDiscount(Map<String, AtomicInteger> counterTotalDiscount) {
        this.counterTotalDiscount = counterTotalDiscount;
    }

    public void increaseTotalDiscountCounter(String methodName) {
        if (counterTotalDiscount.get(methodName) == null) {
            counterTotalDiscount.put(methodName, new AtomicInteger(1));
        } else {
            counterTotalDiscount.get(methodName).getAndIncrement();
        }
    }

    public void increaseDiscountCounterByUser(User user) {
        if (counterDiscountByUser.get(user) == null) {
            counterDiscountByUser.put(user, new AtomicInteger(1));
        } else {
            counterDiscountByUser.get(user).getAndIncrement();
        }
    }

}
