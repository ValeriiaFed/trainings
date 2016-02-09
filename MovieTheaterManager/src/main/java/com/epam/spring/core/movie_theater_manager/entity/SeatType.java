package com.epam.spring.core.movie_theater_manager.entity;

public enum SeatType {

    BASE(1.0), VIP(2.0);

    private double rate;

    SeatType() {
    }

    SeatType(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
