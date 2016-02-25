package com.epam.spring.core.movie_theater_manager.entity;

public class Seat {

    private int id;
    private int number;
    private SeatType seatType;

    public Seat(int id, int number, SeatType seatType) {
        this.id = id;
        this.number = number;
        this.seatType = seatType;
    }

    public Seat(int number, SeatType seatType) {
        this.id = (int )(Math. random() * 50 + 1);
        this.number = number;
        this.seatType = seatType;
    }

    public Seat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", number=" + number +
                ", seatType=" + seatType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (id != seat.id) return false;
        if (number != seat.number) return false;
        return seatType == seat.seatType;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + number;
        result = 31 * result + (seatType != null ? seatType.hashCode() : 0);
        return result;
    }
}
