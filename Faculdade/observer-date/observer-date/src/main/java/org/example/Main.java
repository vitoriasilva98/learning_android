package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

//        Observer<Temporal> timeObserver = message -> System.out.println("The time is: " + message);
//        Observer<Temporal> dateObserver = message -> System.out.println("The date is: " + message);
//        Observer<Temporal> dateTimeObserver = message -> {
//            if (message instanceof LocalDateTime) {
//                System.out.println("The date/time is: " + message);
//            }
//        };
//        Observer<Temporal> generalObserver = message -> System.out.println("Now is: " + message);
//
//        SimpleObservable<Temporal> clock = new SimpleObservable<>();
//        clock.subscribe(timeObserver, temporal -> temporal instanceof LocalTime);
//        clock.subscribe(dateObserver, temporal -> temporal.getClass().getSimpleName().equals("LocalDate"));
//        clock.subscribe(dateTimeObserver); // does its own filtering
//        clock.subscribe(generalObserver); // no filtering
//
//        clock.notifyObservers(LocalDate.now());
//        clock.notifyObservers(LocalTime.now());
//        clock.notifyObservers(LocalDateTime.now());
//        clock.notifyObservers(OffsetDateTime.now());

       // Calendar currentDate = Calendar.getInstance();
//        System.out.println(currentDate);
        //System.out.println(Calendar.MONTH);
        ///System.out.println(Calendar.MONTH + 1);

        System.out.println(LocalDateTime.now().getMonth().getValue());
        System.out.println(LocalDateTime.now().getMonth().getValue());

        Integer inicioDosSeisMeses = LocalDateTime.now().getMonthValue() - 5;
        Integer finalDosSeisMeses = LocalDateTime.now().getMonth().getValue();

        System.out.println("inicioDosSeisMeses: " + inicioDosSeisMeses);
        System.out.println("finalDosSeisMeses: " + finalDosSeisMeses);

//        System.out.println(new Date(1664582400000));



    }
}