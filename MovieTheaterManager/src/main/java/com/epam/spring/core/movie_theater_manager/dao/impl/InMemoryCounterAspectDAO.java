package com.epam.spring.core.movie_theater_manager.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.epam.spring.core.movie_theater_manager.dao.CounterAspectDAO;

public class InMemoryCounterAspectDAO implements CounterAspectDAO {

    private Map<String, AtomicInteger> counter;

    public InMemoryCounterAspectDAO() {
        counter = new HashMap<String, AtomicInteger>();
    }

    public InMemoryCounterAspectDAO(Map<String, AtomicInteger> counter) {
        this.counter = counter;
    }

    public Map<String, AtomicInteger> getCounter() {
        return counter;
    }

    public void setCounter(Map<String, AtomicInteger> counter) {
        this.counter = counter;
    }

    public void increaseCounter(String className) {
        if (counter.get(className) == null){
            counter.put(className, new AtomicInteger(1));
        } else {
            counter.get(className).getAndIncrement();
        }
        System.out.println(counter.toString());
    }
}
