package com.snacks;

import java.util.Comparator;

/*
 * Sort Key: tailLength (double)
 */
class RadishTailLengthComparator implements Comparator<Radish> {

    @Override
    public int compare(Radish radish1, Radish radish2) {
        return Double.compare(radish1.getTaiLength(), radish2.getTaiLength());
    }
}