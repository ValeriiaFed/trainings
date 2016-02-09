package com.epam.spring.core.movie_theater_manager.services;

import com.epam.spring.core.movie_theater_manager.entity.Auditorium;
import com.epam.spring.core.movie_theater_manager.entity.Event;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface EventService extends Service {

    void createEvent(Event event);
    void removeEvent(Event event);
    Event getByName(String name);
    Collection<Event> getAll();
    List<Event> getForDateRange(Date from, Date to);
    Event getNextEvent(Date to);
    void assignAuditorium(Event event, Auditorium auditorium, Date date);
}
