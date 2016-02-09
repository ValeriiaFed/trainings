package com.epam.spring.core.movie_theater_manager.dao.impl;

import com.epam.spring.core.movie_theater_manager.dao.AuditoriumDAO;
import com.epam.spring.core.movie_theater_manager.entity.Auditorium;

import java.util.ArrayList;
import java.util.List;

public class InPropertyFileAuditoriumDAO implements AuditoriumDAO {

    private List<Auditorium> auditoriums;

    public InPropertyFileAuditoriumDAO() {
        auditoriums = new ArrayList<Auditorium>();
    }

    public void setAuditoriums(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    public List<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public Auditorium getAuditoriumById(int id) {
        System.out.println("getAuditoriumById " + "start");
        for (Auditorium auditorium: auditoriums){
            if (auditorium.getId() == id){
                return auditorium;
            }
        }
        return null;
    }
}
