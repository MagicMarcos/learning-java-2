package com.snacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class RadishSortTest {

    public static void main(String[] args) {
        Radish r1 = new Radish(0.5, 3.0, 5);
        Radish r2 = new Radish(1.25, 0.0, 3);
        Radish r3 = new Radish(0.75, 2.8, 0);
        Radish r4 = new Radish(0.5, 0.0, 0);
        Radish r5 = new Radish(0.5 , 8.5, 8);

        //  all collections have several constructors
        // and they all offer one that takes in another collection
        List<Radish> radishes = new ArrayList<>(List.of(r1, r2, r3, r4, r5));

        // sort by natural order
        radishes.sort(null);

        for (Radish radish : radishes) {
            System.out.println(radish);
        }
        System.out.println();

        // sort by specified Comparator (this one does it by "tailLength")
        radishes.sort(new RadishTailLengthComparator());

        for (Radish radish : radishes) {
            System.out.println(radish);
        }
        System.out.println();

        // sort by specified Comparator (if we tie on diameter, we go by tailLength)
        radishes.sort(new RadishDiamaterTailLengthComparator());

        // LAMBDA EXPRESSION - does what above comparator does, without having to defined a separate comparator class
        radishes.sort((radish1, radish2) -> Double.compare(radish1.getTaiLength(), radish2.getTaiLength()));

        for (Radish radish : radishes) {
            System.out.println(radish);
        }
        System.out.println();

        // ANONYMOUS CLASS!
        radishes.sort(new Comparator<>() {
            @Override
            public int compare(Radish r1, Radish r2) {
                return Integer.compare(r1.getGuysOnTop(), r2.getGuysOnTop());
            }
        });

        // LAMBDA EXPRESSION - does what above anon class does, but less verbose + more readable
        radishes.sort((radish1, radish2) -> Integer.compare(radish1.getGuysOnTop(), radish2.getGuysOnTop()));


        for (Radish radish : radishes) {
            System.out.println(radish);
        }
    }
}