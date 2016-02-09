package com.epam.spring.core.movie_theater_manager.services.impl;

import com.epam.spring.core.movie_theater_manager.dao.AuditoriumDAO;
import com.epam.spring.core.movie_theater_manager.entity.Auditorium;
import com.epam.spring.core.movie_theater_manager.entity.Seat;
import com.epam.spring.core.movie_theater_manager.entity.SeatType;
import com.epam.spring.core.movie_theater_manager.services.AuditoriumService;

import java.util.List;

public class AuditoriumServiceImpl implements AuditoriumService {

    private AuditoriumDAO auditoriumDAO;

    public AuditoriumDAO getAuditoriumDAO() {
        return auditoriumDAO;
    }

    public void setAuditoriumDAO(AuditoriumDAO auditoriumDAO) {
        this.auditoriumDAO = auditoriumDAO;
    }

    public List<Auditorium> getAuditoriums() {
        return auditoriumDAO.getAuditoriums();
    }

    public Seat getSeat(Auditorium auditorium, int number) {
        final int auditoriumSeatsNumber = auditorium.getSeatsNumber();

        if (number > auditoriumSeatsNumber) {
            throw new IllegalArgumentException("Wrong seat number");
        }

        Seat seat = new Seat();
        seat.setNumber(number);

        final List<Integer> vipSeats = auditorium.getVipSeats();

        if (vipSeats.contains(number)) {
            seat.setSeatType(SeatType.VIP);
        } else {
            seat.setSeatType(SeatType.BASE);
        }
        return seat;
    }

    public Auditorium getAuditoriumById(int id) {
        return auditoriumDAO.getAuditoriumById(id);
    }


}
