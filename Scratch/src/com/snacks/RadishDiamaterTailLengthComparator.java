package com.snacks;

import java.util.Comparator;

class RadishDiamaterTailLengthComparator implements Comparator<Radish> {

    @Override
    public int compare(Radish radish1, Radish radish2) {
        int result = Double.compare(radish1.getDiameter(), radish2.getDiameter());

        if(result == 0) { // tied on diameter -> break the tie based on tail length
            result = Double.compare(radish1.getTaiLength(), radish2.getTaiLength());
        }
        return result;
    }
}