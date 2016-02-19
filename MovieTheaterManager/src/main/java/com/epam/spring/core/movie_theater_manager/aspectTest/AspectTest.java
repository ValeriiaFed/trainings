package com.epam.spring.core.movie_theater_manager.aspectTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.core.movie_theater_manager.dao.CounterAspectDAO;
import com.epam.spring.core.movie_theater_manager.dao.DiscountAspectDAO;
import com.epam.spring.core.movie_theater_manager.entity.*;
import com.epam.spring.core.movie_theater_manager.services.BookingService;
import com.epam.spring.core.movie_theater_manager.services.EventService;

public class AspectTest {

    private static final String EVENT_NAME_1 = "Event 1";
    private static final String EVENT_NAME_2 = "Event 2";
    private static final String EVENT_NAME_3 = "Event 3";
    private static final String AUDITORIUM_NAME = "auditoriumName";
    private static final int AUDITORIUM_ID = 1;
    private static final int AUDITORIUM_SEATS = 60;
    private static final double EVENT_PRICE = 15.0;
    private static final int SEAT_ID = 12;
    private static final int SEAT_NUMBER_12 = 12;
    private static final String USER_EMAIL = "test@user.com";
    private static final String USER_NAME = "user name";
    private static final int TICKET_ID = 1;
    private static final String DD_MM_YYYY = "dd-MM-yyyy";
    private static final String DATE_1 = "11-02-2015";
    private static final String USER_EMAIL_2 = "user2@test.com";
    private static final String USER_NAME_2 = "user name 2";
    public static final String GET_DISCOUNT_METHOD_NAME = "getDiscount";

    private EventService eventService;
    private CounterAspectDAO counterAspectDAO;
    private BookingService bookingService;
    private DiscountAspectDAO discountAspectDAO;

    ConfigurableApplicationContext ctx;
    AspectTest counterAspectTest;
    Date date;
    Date date1;
    List<Integer> vipSeats;
    Auditorium auditorium;
    Event event1;
    Event event2;
    Event event3;
    Seat seat;
    User user;
    User user1;
    Ticket ticket;

    public DiscountAspectDAO getDiscountAspectDAO() {
        return discountAspectDAO;
    }

    public void setDiscountAspectDAO(DiscountAspectDAO discountAspectDAO) {
        this.discountAspectDAO = discountAspectDAO;
    }

    public BookingService getBookingService() {
        return bookingService;
    }

    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public AspectTest() {
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

    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("spring.xml");
        counterAspectTest = (AspectTest) ctx.getBean("aspectTest");
        date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat(DD_MM_YYYY);
        date1 = ft.parse(DATE_1);
        vipSeats = new ArrayList<Integer>();
        vipSeats.add(55);
        auditorium = new Auditorium(AUDITORIUM_ID, AUDITORIUM_NAME, AUDITORIUM_SEATS, vipSeats);
        event1 = new Event(EVENT_NAME_1, EVENT_PRICE, RatingType.HIGH, date, auditorium);
        event2 = new Event(EVENT_NAME_2, EVENT_PRICE, RatingType.HIGH, date, auditorium);
        event3 = new Event(EVENT_NAME_3, EVENT_PRICE, RatingType.HIGH, date, auditorium);
        seat = new Seat(SEAT_ID, SEAT_NUMBER_12, SeatType.BASE);
        user = new User(USER_EMAIL, USER_NAME, date);
        user1 = new User(USER_EMAIL_2, USER_NAME_2, date1);
        ticket = new Ticket(TICKET_ID, EVENT_PRICE, event1, seat);
    }

    @Test
    public void countEventAccessedByNameTest() {
        counterAspectTest.getEventService().createEvent(event1);
        counterAspectTest.getEventService().createEvent(event2);
        counterAspectTest.getEventService().createEvent(event3);

        Assert.assertNull("The CounterGetByName map should be null before calling getByName method",
                counterAspectTest.getCounterAspectDAO().getCounterGetByName().get(event1));

        counterAspectTest.getEventService().getByName(EVENT_NAME_1);
        Assert.assertEquals(new AtomicInteger(1).get(), counterAspectTest.getCounterAspectDAO().getCounterGetByName().get(event1).get());
        counterAspectTest.getEventService().getByName(EVENT_NAME_1);
        Assert.assertEquals(new AtomicInteger(2).get(), counterAspectTest.getCounterAspectDAO().getCounterGetByName().get(event1).get());

        counterAspectTest.getEventService().getByName(EVENT_NAME_2);
        Assert.assertEquals(new AtomicInteger(2).get(), counterAspectTest.getCounterAspectDAO().getCounterGetByName().get(event1).get());
        Assert.assertEquals(new AtomicInteger(1).get(), counterAspectTest.getCounterAspectDAO().getCounterGetByName().get(event2).get());

        counterAspectTest.getEventService().getByName(EVENT_NAME_3);
        Assert.assertEquals(new AtomicInteger(2).get(), counterAspectTest.getCounterAspectDAO().getCounterGetByName().get(event1).get());
        Assert.assertEquals(new AtomicInteger(1).get(), counterAspectTest.getCounterAspectDAO().getCounterGetByName().get(event2).get());
        Assert.assertEquals(new AtomicInteger(1).get(), counterAspectTest.getCounterAspectDAO().getCounterGetByName().get(event3).get());

        counterAspectTest.getEventService().getByName(EVENT_NAME_3);
        Assert.assertEquals(new AtomicInteger(1).get(), counterAspectTest.getCounterAspectDAO().getCounterGetByName().get(event2).get());
        Assert.assertEquals(new AtomicInteger(2).get(), counterAspectTest.getCounterAspectDAO().getCounterGetByName().get(event3).get());
    }

    @Test
    public void countEventGetTicketPriceTest() {
        Assert.assertNull("The counter map should be null before calling getTicketPrice method",
                counterAspectTest.getCounterAspectDAO().getCounterByGetTicketPrice().get(event1));

        counterAspectTest.getBookingService().getTicketPrice(event1, date, seat, user);
        Assert.assertEquals(new AtomicInteger(1).get(), counterAspectTest.getCounterAspectDAO().getCounterByGetTicketPrice().get(event1).get());

        counterAspectTest.getBookingService().getTicketPrice(event2, date, seat, user);
        Assert.assertEquals(new AtomicInteger(1).get(), counterAspectTest.getCounterAspectDAO().getCounterByGetTicketPrice().get(event1).get());
        Assert.assertEquals(new AtomicInteger(1).get(), counterAspectTest.getCounterAspectDAO().getCounterByGetTicketPrice().get(event2).get());

        counterAspectTest.getBookingService().getTicketPrice(event1, date, seat, user);
        Assert.assertEquals(new AtomicInteger(2).get(), counterAspectTest.getCounterAspectDAO().getCounterByGetTicketPrice().get(event1).get());
    }

    @Test
    public void countBookTicketForEventTest() {
        counterAspectTest.getEventService().createEvent(event1);

        Assert.assertNull("The counter map should be null before calling getTicketPrice method",
                counterAspectTest.getCounterAspectDAO().getCounterBookTicket().get(event1));

        counterAspectTest.getBookingService().bookTicket(user, ticket);
        Assert.assertEquals(new AtomicInteger(1).get(), counterAspectTest.getCounterAspectDAO().getCounterBookTicket().get(event1).get());

        counterAspectTest.getBookingService().bookTicket(user, ticket);
        Assert.assertEquals(new AtomicInteger(2).get(), counterAspectTest.getCounterAspectDAO().getCounterBookTicket().get(event1).get());
    }

    @Test
    public void countDiscountTest() {
        counterAspectTest.getEventService().createEvent(event1);

        Assert.assertNull("The counter map should be null before calling getTicketPrice method",
                counterAspectTest.getDiscountAspectDAO().getCounterTotalDiscount().get("getDiscount"));

        counterAspectTest.getBookingService().getTicketPrice(event1, date, seat, user);
        counterAspectTest.getBookingService().getTicketPrice(event1, date, seat, user);
        Assert.assertEquals(new AtomicInteger(2).get(), counterAspectTest.getDiscountAspectDAO().getCounterTotalDiscount().get(GET_DISCOUNT_METHOD_NAME).get());
        Assert.assertEquals(new AtomicInteger(2).get(), counterAspectTest.getDiscountAspectDAO().getCounterDiscountByUser().get(user).get());

        counterAspectTest.getBookingService().getTicketPrice(event2, date, seat, user1);
        Assert.assertEquals(new AtomicInteger(2).get(), counterAspectTest.getDiscountAspectDAO().getCounterTotalDiscount().get(GET_DISCOUNT_METHOD_NAME).get());
        Assert.assertEquals(new AtomicInteger(2).get(), counterAspectTest.getDiscountAspectDAO().getCounterDiscountByUser().get(user).get());
        Assert.assertNull("The counter map should be null before calling getTicketPrice method",
                counterAspectTest.getDiscountAspectDAO().getCounterTotalDiscount().get(user1));
    }

    @Test
    public void luckyWinnerTest() {
        counterAspectTest.getEventService().createEvent(event1);

        counterAspectTest.getBookingService().bookTicket(user, ticket);
        System.out.println(ticket.getPrice());
    }
}
