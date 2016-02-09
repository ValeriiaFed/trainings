package com.epam.spring.core.movie_theater_manager.dao;

import com.epam.spring.core.movie_theater_manager.entity.Auditorium;

import java.util.List;

public interface AuditoriumDAO extends DAO {

    List<Auditorium> getAuditoriums();

    Auditorium getAuditoriumById(int id);
}
