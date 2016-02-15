package com.epam.spring.core.movie_theater_manager.dao;


import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public interface CounterAspectDAO extends DAO {

    void increaseCounter(String className);
    Map<String, AtomicInteger> getCounter();
}
