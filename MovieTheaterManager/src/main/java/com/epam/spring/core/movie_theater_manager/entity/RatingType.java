package com.epam.spring.core.movie_theater_manager.entity;

public enum RatingType {

    HIGH(1.5), MID(1), LOW(0.8);

    private double rate;



    RatingType(double rate) {
        this.rate = rate;
    }

    RatingType() {
    }

    public double getRate() {
        return rate;
    }
}
