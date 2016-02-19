package com.epam.spring.core.movie_theater_manager.dao;


import com.epam.spring.core.movie_theater_manager.entity.Event;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public interface CounterAspectDAO extends DAO {

    void increaseCounterGetByName(Event event);
    void increaseCounterGetTicketPrice(Event event);
    void increaseCounterBookTicket(Event event);

    Map<Event, AtomicInteger> getCounterGetByName();
    Map<Event, AtomicInteger> getCounterByGetTicketPrice();
    Map<Event, AtomicInteger> getCounterBookTicket();
}
