package com.epam.spring.core.movie_theater_manager.app;

import com.epam.spring.core.movie_theater_manager.services.BookingService;

public class BookingOperations {

    private BookingService bookingService;

    public BookingService getBookingService() {
        return bookingService;
    }

    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }


}

