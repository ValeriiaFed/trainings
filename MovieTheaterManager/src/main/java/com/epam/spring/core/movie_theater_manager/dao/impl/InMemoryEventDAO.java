package com.epam.spring.core.movie_theater_manager.dao.impl;

import com.epam.spring.core.movie_theater_manager.dao.EventDAO;
import com.epam.spring.core.movie_theater_manager.entity.Auditorium;
import com.epam.spring.core.movie_theater_manager.entity.Event;

import java.util.*;

public class InMemoryEventDAO implements EventDAO{

    private Map<String, Event> events;

    public InMemoryEventDAO() {
        events = new HashMap<String, Event>();
    }

    public Map<String, Event> getEvents() {
        return events;
    }

    public void setEvents(Map<String, Event> events) {
        this.events = events;
    }

    public void createEvent(Event event) {
        events.put(event.getName(), event);
    }

    public void removeEvent(Event event) {
        events.remove(event.getName());
    }

    public Event getByName(String name) {
        return events.get(name);
    }

    public Collection<Event> getAll() {
        return events.values();
    }

    public List<Event> getForDateRange(Date from, Date to) {
        return null;
    }

    public Event getNextEvent(Date to) {
        return null;
    }

    public void assignAuditorium(Event event, Auditorium auditorium, Date date) {
        throw new UnsupportedOperationException("Method is not implemented yet");
    }
}
