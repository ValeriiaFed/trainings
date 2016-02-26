package com.epam.spring.core.movie_theater_manager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    private int id;
    private String email;
    private String name;
    private List<Ticket> tickets;
    private Date birthday;

    public User(String email, String name, Date birthday) {
        this.id = (int )(Math. random() * 50 + 1);
        this.email = email;
        this.name = name;
        this.birthday = birthday;
        tickets = new ArrayList<Ticket>();
    }

    public User(int id, String email, String name,Date birthday) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.birthday = birthday;
    }

    public User() {
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", tickets=" + tickets +
                ", birthday=" + birthday +
                '}';
    }

    public List<Ticket> getBookedTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (tickets != null ? !tickets.equals(user.tickets) : user.tickets != null) return false;
        return !(birthday != null ? !birthday.equals(user.birthday) : user.birthday != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (tickets != null ? tickets.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
