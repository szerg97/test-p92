package com.payment.sample;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class DateSorterImpl implements DateSorter {

    @Override
    public SortedSet<LocalDate> sortDates(Set<LocalDate> unsortedDates) {

        SortedSet<LocalDate> sortedDates = new TreeSet<>(new MonthComparator());
        sortedDates.addAll(unsortedDates);
        return sortedDates;
    }

    static class MonthComparator implements Comparator <LocalDate>{

        @Override
        public int compare(LocalDate o1, LocalDate o2) {
            if (monthContainsR(o1) && monthContainsR(o2)){
                return compareStepByStep(o1, o2);
            }
            else if ((!monthContainsR(o1) && !monthContainsR(o2))){
                return compareStepByStep(o1, o2) * (-1);
            }
            else if (!monthContainsR(o1) && o2.getMonthValue() > 8 ||
                    o1.getMonthValue() > 8 && !monthContainsR(o2)){
                return compareStepByStep(o1, o2) * (-1);
            }
            return compareStepByStep(o1, o2);
        }

        private boolean monthContainsR(LocalDate o){
            return o.getMonthValue() < 5 || o.getMonthValue() > 8;
        }

        private int compareStepByStep(LocalDate o1, LocalDate o2){
            int monthCompare = Integer.compare(o1.getMonthValue(), o2.getMonthValue());
            int dayCompare = Integer.compare(o1.getDayOfMonth(), o2.getDayOfMonth());
            return monthCompare == 0 ? dayCompare : monthCompare;
        }
    }
}

