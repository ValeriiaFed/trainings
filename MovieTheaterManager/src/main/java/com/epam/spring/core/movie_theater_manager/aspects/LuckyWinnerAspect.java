package com.epam.spring.core.movie_theater_manager.aspects;

import java.util.Random;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.epam.spring.core.movie_theater_manager.entity.Ticket;

@Aspect
public class LuckyWinnerAspect {

    @Pointcut("execution(* com.epam.spring.core.movie_theater_manager.services.BookingService.bookTicket(..))")
    private void luckyWinner() {
    }

    @AfterReturning(pointcut = "luckyWinner()")
    public void countDiscountTotal(JoinPoint joinPoint) {
        if (userIsLucky()) {
            Object[] methodArgs = joinPoint.getArgs();
            ((Ticket) methodArgs[1]).setPrice(0);
        }
    }

    private boolean userIsLucky() {
        int number = generateRandomSixDigitsNumber();

        char[] firstPart = Integer.toString(number).substring(0, 3).toCharArray();
        char[] secondPart = Integer.toString(number).substring(3, 6).toCharArray();
        int sumFirst = getSumOfDigits(number, firstPart);
        int sumSecond = getSumOfDigits(number, secondPart);

        return isNumbersEqual(sumFirst, sumSecond);
    }

    private boolean isNumbersEqual(int first, int second) {
        return first == second;
    }

    private int getSumOfDigits(int number, char[] digitsArray) {
        int sumOfDigits = 0;
        for (int i = 0; i < digitsArray.length; i++) {
            sumOfDigits += Integer.parseInt(String.valueOf(digitsArray[i]));
        }
        return sumOfDigits;
    }

    private int generateRandomSixDigitsNumber() {
        Random rnd = new Random();
        return 100000 + rnd.nextInt(900000);
    }

}
