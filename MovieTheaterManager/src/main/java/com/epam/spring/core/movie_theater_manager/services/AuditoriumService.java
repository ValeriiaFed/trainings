package com.epam.spring.core.movie_theater_manager.services;

import com.epam.spring.core.movie_theater_manager.entity.Auditorium;
import com.epam.spring.core.movie_theater_manager.entity.Seat;

import java.util.List;

public interface AuditoriumService extends Service {

    List<Auditorium> getAuditoriums();
    Seat getSeat(Auditorium auditorium, int number);
    Auditorium getAuditoriumById(int id);
}
