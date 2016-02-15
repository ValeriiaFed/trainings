package com.epam.spring.core.movie_theater_manager.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.epam.spring.core.movie_theater_manager.dao.CounterAspectDAO;

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

    @AfterReturning("countEventAccessedByName()")
    public void countEventAccessedByNameAfterReturning(JoinPoint joinPoint) {
        counterAspectDAO.increaseCounter(joinPoint.getSignature().getName());
    }

    @AfterReturning("countGetTicketPrice()")
    public void countGetTicketPriceAfterReturning(JoinPoint joinPoint) {
        counterAspectDAO.increaseCounter(joinPoint.getSignature().getName());
    }

    @AfterReturning("countBookTicket()")
    public void countBookTicketAfterReturning(JoinPoint joinPoint) {
        counterAspectDAO.increaseCounter(joinPoint.getSignature().getName());
    }

}
