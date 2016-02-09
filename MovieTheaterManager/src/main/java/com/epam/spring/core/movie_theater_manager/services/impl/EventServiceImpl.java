package com.epam.spring.core.movie_theater_manager.services.impl;

import com.epam.spring.core.movie_theater_manager.dao.EventDAO;
import com.epam.spring.core.movie_theater_manager.entity.Auditorium;
import com.epam.spring.core.movie_theater_manager.entity.Event;
import com.epam.spring.core.movie_theater_manager.services.EventService;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class EventServiceImpl implements EventService {

    private EventDAO eventDAO;

    public EventDAO getEventDAO() {
        return eventDAO;
    }

    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public void createEvent(Event event) {
        eventDAO.createEvent(event);
    }

    public void removeEvent(Event event) {
        eventDAO.removeEvent(event);
    }

    public Event getByName(String name) {
        return eventDAO.getByName(name);
    }

    public Collection<Event> getAll() {
        return eventDAO.getAll();
    }

    public List<Event> getForDateRange(Date from, Date to) {
        return eventDAO.getForDateRange(from, to);
    }

    public Event getNextEvent(Date to) {
        return eventDAO.getNextEvent(to);
    }

    public void assignAuditorium(Event event, Auditorium auditorium, Date date) {
        eventDAO.assignAuditorium(event, auditorium, date);
    }
}
