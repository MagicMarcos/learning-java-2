package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {
    public static void main(String[] args) {

        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Sony", 52);
        Television tvD = new Television("Sony", 12);

        System.out.println("tvA == tvB: " + (tvA == tvB));            // false -- not the same physical obj
        System.out.println("tvA.equals(tvB): " + tvA.equals(tvB));    // true*
        // * it is up to the developer to determine what "sameness" is, otherwise .equals() returns false
        // in this case we say that TV are same if brand and volume match, so we override .equals() method
        System.out.println();

        // NO DUPLICATES
        // Set<Television> tvs = new HashSet<>(); // goes by hashcodes order ('chaotic')
        // Set<Television> tvs = new LinkedHashSet<>(); // goes by order added into set
         Set<Television> tvs = new TreeSet<>(); // goes by natural order (brand then volume) ONLY!
        // if natural order and equality are different, TreeSet may behave strangely (natural order sort ONLY)

        tvs.add(tvA);
        tvs.add(tvB);
        tvs.add(tvC);
        tvs.add(tvD);

        System.out.println("The size of the set is: " + tvs.size());

        for (Television tv : tvs) {
            System.out.println(tv);
        }
    }
}