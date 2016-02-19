package com.epam.spring.core.movie_theater_manager.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.epam.spring.core.movie_theater_manager.dao.DiscountAspectDAO;
import com.epam.spring.core.movie_theater_manager.entity.User;

@Aspect
public class DiscountAspect {

    private DiscountAspectDAO discountAspectDAO;

    public DiscountAspectDAO getDiscountAspectDAO() {
        return discountAspectDAO;
    }

    public void setDiscountAspectDAO(DiscountAspectDAO discountAspectDAO) {
        this.discountAspectDAO = discountAspectDAO;
    }

    @Pointcut("execution(* com.epam.spring.core.movie_theater_manager.services.BookingService.getTicketPrice(..))")
    private void countDiscount() {
    }

    @AfterReturning(pointcut = "countDiscount()", returning = "returnVal")
    public void countDiscountTotal(Object returnVal) {
        Double discount = (Double) returnVal;
        if (discount != 0) {
            discountAspectDAO.increaseTotalDiscountCounter("getDiscount");
        }
    }

    @AfterReturning(pointcut = "countDiscount()", returning = "returnVal")
    public void countDiscountByUser(JoinPoint joinPoint, Object returnVal) {
        Double discount = (Double) returnVal;
        if (discount != 0) {
            Object[] methodArgs = joinPoint.getArgs();
            discountAspectDAO.increaseDiscountCounterByUser((User) methodArgs[3]);
        }
    }

}
