package com.entertainment;

import java.util.Comparator;

/*
 * Two-part Comparator.
 *  primary sort key: brand (String)
 *  secondary sort key: channel (int)
 */
public class TelevisionBrandChannelComparator implements Comparator<Television> {

    @Override
    public int compare(Television tv1, Television tv2) {
        // primary sort key: brand (String)
        int result = tv1.getBrand().compareTo(tv2.getBrand());

        if (result == 0) { // tie on brand -> sort by channel (int)
            result = Integer.compare(tv1.getCurrentChannel(), tv2.getCurrentChannel());
        }

        return result;
    }
}