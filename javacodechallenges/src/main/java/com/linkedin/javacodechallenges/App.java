package com.linkedin.javacodechallenges;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class App 
{
    public static LocalDate calculate100DaysFromNow(LocalDate today){
        Period hunderedDays=Period.ofDays(100);
        return today.plus(hunderedDays);
    }
    public static void main( String[] args )
    {
        LocalDate today=LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("100 days from now is... "+calculate100DaysFromNow(today) );

    }
}
