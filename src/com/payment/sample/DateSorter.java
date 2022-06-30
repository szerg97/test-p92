package com.payment.sample;

import java.time.LocalDate;
import java.util.Set;
import java.util.SortedSet;

public interface DateSorter {
    SortedSet<LocalDate> sortDates(Set<LocalDate> unsortedDates);
}
