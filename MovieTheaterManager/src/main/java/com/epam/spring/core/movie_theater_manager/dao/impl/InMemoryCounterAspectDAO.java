package com.epam.spring.core.movie_theater_manager.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.epam.spring.core.movie_theater_manager.dao.CounterAspectDAO;
import com.epam.spring.core.movie_theater_manager.entity.Event;

public class InMemoryCounterAspectDAO implements CounterAspectDAO {

    private Map<Event, AtomicInteger> counterGetByName;
    private Map<Event, AtomicInteger> counterByGetTicketPrice;
    private Map<Event, AtomicInteger> counterBookTicket;

    public InMemoryCounterAspectDAO() {
        counterGetByName = new HashMap<Event, AtomicInteger>();
        counterByGetTicketPrice = new HashMap<Event, AtomicInteger>();
        counterBookTicket = new HashMap<Event, AtomicInteger>();
    }

    public Map<Event, AtomicInteger> getCounterBookTicket() {
        return counterBookTicket;
    }

    public void setCounterBookTicket(Map<Event, AtomicInteger> counterBookTicket) {
        this.counterBookTicket = counterBookTicket;
    }

    public Map<Event, AtomicInteger> getCounterByGetTicketPrice() {
        return counterByGetTicketPrice;
    }

    public void setCounterByGetTicketPrice(Map<Event, AtomicInteger> counterByGetTicketPrice) {
        this.counterByGetTicketPrice = counterByGetTicketPrice;
    }

    public InMemoryCounterAspectDAO(Map<Event, AtomicInteger> counter) {
        this.counterGetByName = counter;
    }

    public Map<Event, AtomicInteger> getCounterGetByName() {
        return counterGetByName;
    }

    public void increaseCounterGetTicketPrice(Event event) {
        if (counterByGetTicketPrice.get(event) == null) {
            counterByGetTicketPrice.put(event, new AtomicInteger(1));
        } else {
            counterByGetTicketPrice.get(event).getAndIncrement();
        }
    }

    public void increaseCounterBookTicket(Event event) {
        if (counterBookTicket.get(event) == null) {
            counterBookTicket.put(event, new AtomicInteger(1));
        } else {
            counterBookTicket.get(event).getAndIncrement();
        }
    }

    public void setCounterGetByName(Map<Event, AtomicInteger> counterGetByName) {
        this.counterGetByName = counterGetByName;
    }

    public void increaseCounterGetByName(Event event) {
        if (counterGetByName.get(event) == null) {
            counterGetByName.put(event, new AtomicInteger(1));
        } else {
            counterGetByName.get(event).getAndIncrement();
        }
    }
}
