package com.epam.spring.core.movie_theater_manager.entity;

import java.util.List;

public class Auditorium {

    private int id;
    private String name;
    private int number;
    private List<Integer> vipSeats;

    public Auditorium(int id, String name, int number, List<Integer> vipSeats) {
        this.id = (int )(Math. random() * 50 + 1);
        this.name = name;
        this.number = number;
        this.vipSeats = vipSeats;
    }

    public Auditorium() {
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", vipSeats=" + vipSeats +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatsNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Integer> getVipSeats() {
        return vipSeats;
    }

    public void setVipSeats(List<Integer> vipSeats) {
        this.vipSeats = vipSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auditorium that = (Auditorium) o;

        if (id != that.id) return false;
        if (number != that.number) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return !(vipSeats != null ? !vipSeats.equals(that.vipSeats) : that.vipSeats != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + number;
        result = 31 * result + (vipSeats != null ? vipSeats.hashCode() : 0);
        return result;
    }
}
