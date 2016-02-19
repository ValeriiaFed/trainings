package com.epam.spring.core.movie_theater_manager.aspects;

import com.epam.spring.core.movie_theater_manager.entity.Ticket;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.epam.spring.core.movie_theater_manager.dao.CounterAspectDAO;
import com.epam.spring.core.movie_theater_manager.entity.Event;

@Aspect
public class CounterAspect {

    private CounterAspectDAO counterAspectDAO;

    public CounterAspectDAO getCounterAspectDAO() {
        return counterAspectDAO;
    }

    public void setCounterAspectDAO(CounterAspectDAO counterAspectDAO) {
        this.counterAspectDAO = counterAspectDAO;
    }

    @Pointcut("execution(* com.epam.spring.core.movie_theater_manager.services.EventService.getByName(..))")
    private void countEventAccessedByName() {
    }

    @Pointcut("execution(* com.epam.spring.core.movie_theater_manager.services.BookingService.getTicketPrice(..))")
    private void countGetTicketPrice() {
    }

    @Pointcut("execution(* com.epam.spring.core.movie_theater_manager.services.BookingService.bookTicket(..))")
    private void countBookTicket() {
    }

    @AfterReturning(pointcut = "countEventAccessedByName()", returning = "returnVal")
    public void countEventAccessedByName(Object returnVal) {
        counterAspectDAO.increaseCounterGetByName((Event) returnVal);
    }

    @AfterReturning("countGetTicketPrice()")
    public void countGetTicketPriceAfterReturning(JoinPoint joinPoint) {
        Object[] methodArgs = joinPoint.getArgs();
        counterAspectDAO.increaseCounterGetTicketPrice((Event) methodArgs[0]);
    }

    @AfterReturning("countBookTicket()")
    public void countBookTicketAfterReturning(JoinPoint joinPoint) {
        Object[] methodArgs = joinPoint.getArgs();
        counterAspectDAO.increaseCounterBookTicket(((Ticket) methodArgs[1]).getEvent());
    }

}
