package com.epam.spring.core.movie_theater_manager.entity;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Event {

    private String name;
    private double basePrice;
    private RatingType rating;
    private Date date;
    private Auditorium auditorium;

    public Event(String name, double basePrice, RatingType rating, Date date, Auditorium auditorium) {
        this.name = name;
        this.basePrice = basePrice;
        this.rating = rating;
        this.date = date;
        this.auditorium = auditorium;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", rating=" + rating +
                ", date=" + date +
                ", auditorium=" + auditorium +
                '}';
    }

    public Event() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public RatingType getRating() {
        return rating;
    }

    public void setRating(RatingType rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (Double.compare(event.basePrice, basePrice) != 0) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (rating != event.rating) return false;
        if (date != null ? !date.equals(event.date) : event.date != null) return false;
        return !(auditorium != null ? !auditorium.equals(event.auditorium) : event.auditorium != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(basePrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (auditorium != null ? auditorium.hashCode() : 0);
        return result;
    }
}
