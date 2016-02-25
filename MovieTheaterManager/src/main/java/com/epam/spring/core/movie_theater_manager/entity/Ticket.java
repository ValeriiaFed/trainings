package com.epam.spring.core.movie_theater_manager.entity;

public class Ticket {

    private int id;
    private double price;
    private Event event;
    private Seat seat;

    public Ticket(int id, double price, Event event, Seat seat) {
        this.id = (int )(Math. random() * 50 + 1);
        this.price = price;
        this.event = event;
        this.seat = seat;
    }

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", event=" + event +
                ", seat=" + seat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        if (Double.compare(ticket.price, price) != 0) return false;
        if (event != null ? !event.equals(ticket.event) : ticket.event != null) return false;
        return !(seat != null ? !seat.equals(ticket.seat) : ticket.seat != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (seat != null ? seat.hashCode() : 0);
        return result;
    }
}
