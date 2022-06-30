package com.payment;

import com.payment.sample.DateSorter;
import com.payment.sample.DateSorterImpl;

import java.time.LocalDate;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) {
        Random rnd = new Random();
        DateSorter sorter = new DateSorterImpl();
        Set<LocalDate> unsortedDates = new TreeSet<>();
        for (int i = 0; i < 60; i++) {
            unsortedDates.add(
                    LocalDate.of(2019,
                            rnd.nextInt(12) + 1,
                            rnd.nextInt(28) + 1));
        }
        SortedSet<LocalDate> sortedDates = sorter.sortDates(unsortedDates);

        sortedDates.forEach(System.out::println);
    }
}
