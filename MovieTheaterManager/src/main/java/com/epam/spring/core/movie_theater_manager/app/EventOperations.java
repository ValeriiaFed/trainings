package com.epam.spring.core.movie_theater_manager.app;

import asg.cliche.Command;
import asg.cliche.Param;
import com.epam.spring.core.movie_theater_manager.entity.Auditorium;
import com.epam.spring.core.movie_theater_manager.entity.Event;
import com.epam.spring.core.movie_theater_manager.entity.RatingType;
import com.epam.spring.core.movie_theater_manager.services.AuditoriumService;
import com.epam.spring.core.movie_theater_manager.services.EventService;
import com.epam.spring.core.movie_theater_manager.services.UserService;
import com.epam.spring.core.movie_theater_manager.services.impl.UserServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventOperations {

    private UserService userService;
    private EventService eventService;
    private AuditoriumService auditoriumService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public EventService getEventService() {
        return eventService;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    public AuditoriumService getAuditoriumService() {
        return auditoriumService;
    }

    public void setAuditoriumService(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Command
    public Event createEvent(@Param(name = "eventName")
                            String eventName,
                            @Param(name = "price")
                            double price,
                            @Param(name = "rating")
                                String rate,
                            @Param(name = "dates")
                                String eventDate,
                            @Param(name = "auditorium")
                                int auditoriumId
    ) throws ParseException {
        RatingType ratingType = null;
        if (rate.equals(RatingType.HIGH.toString())){
            ratingType = RatingType.HIGH;
        } else if (rate.equals(RatingType.MID.toString())){
            ratingType = RatingType.MID;
        } else if (rate.equals(RatingType.LOW.toString())){
            ratingType = RatingType.LOW;
        }
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        Date date = ft.parse(eventDate);
        Auditorium auditorium = getAuditoriumService().getAuditoriumById(auditoriumId);
        Event event = new Event(eventName, price, ratingType, date, auditorium);
        getEventService().createEvent(event);
        return event;
    }

}

