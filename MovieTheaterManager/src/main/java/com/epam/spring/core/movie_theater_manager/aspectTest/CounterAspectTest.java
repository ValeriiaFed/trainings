package com.epam.spring.core.movie_theater_manager.aspectTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.core.movie_theater_manager.dao.CounterAspectDAO;
import com.epam.spring.core.movie_theater_manager.entity.Auditorium;
import com.epam.spring.core.movie_theater_manager.entity.Event;
import com.epam.spring.core.movie_theater_manager.entity.RatingType;
import com.epam.spring.core.movie_theater_manager.services.EventService;

public class CounterAspectTest {

    private static final String EVENT_NAME_1 = "Event 1";
    private static final String EVENT_NAME_2 = "Event 2";
    private static final String EVENT_NAME_3 = "Event 3";

    private EventService eventService;
    private CounterAspectDAO counterAspectDAO;

    public CounterAspectTest() {
    }

    public CounterAspectDAO getCounterAspectDAO() {
        return counterAspectDAO;
    }

    public void setCounterAspectDAO(CounterAspectDAO counterAspectDAO) {
        this.counterAspectDAO = counterAspectDAO;
    }

    public EventService getEventService() {
        return eventService;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @Test
    public void testName() {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        CounterAspectTest counterAspectTest = (CounterAspectTest) ctx.getBean("counterAspectTest");

        Date date = new Date();
        List<Integer> vipSeats = new ArrayList<Integer>();
        vipSeats.add(55);
        Auditorium auditorium = new Auditorium(1, "auditoriumName", 60, vipSeats);
        Event event1 = new Event(EVENT_NAME_1, 15.0, RatingType.HIGH, date, auditorium);
        Event event2 = new Event(EVENT_NAME_2, 15.0, RatingType.HIGH, date, auditorium);
        Event event3 = new Event(EVENT_NAME_3, 15.0, RatingType.HIGH, date, auditorium);

        System.out.println("COUNTER BEFORE: "+ counterAspectTest.getCounterAspectDAO().getCounter().get("getByName"));
        counterAspectTest.getEventService().getByName(EVENT_NAME_1);
        System.out.println("COUNTER AFTER 1 calling method: " + counterAspectTest.getCounterAspectDAO().getCounter().get("getByName"));
        counterAspectTest.getEventService().getByName(EVENT_NAME_2);
        System.out.println("COUNTER AFTER 2 calling method: " + counterAspectTest.getCounterAspectDAO().getCounter().get("getByName"));
        counterAspectTest.getEventService().getByName(EVENT_NAME_3);
        System.out.println("COUNTER AFTER 3 calling method: " + counterAspectTest.getCounterAspectDAO().getCounter().get("getByName"));
        counterAspectTest.getEventService().getByName(EVENT_NAME_3);
        System.out.println("COUNTER AFTER 4 calling method: " + counterAspectTest.getCounterAspectDAO().getCounter().get("getByName"));
    }
}
