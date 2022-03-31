package com.marcos.stats;

import org.stats.AnalyzerConfigurationException;
import org.stats.RatingAnalyzer;

import java.util.*;

public class RatingAnalyzerImpl implements RatingAnalyzer {

    private int[] ratings;

    public RatingAnalyzerImpl(int[] ratings) throws IllegalArgumentException {
        if (ratings.length < 1) {
            throw new AnalyzerConfigurationException();
        }

        this.ratings = ratings;
    }

    @Override
    public double mean() { // average

        return Arrays.stream(ratings).average().getAsDouble();
    }

    @Override
    public double median() { // value in the middle of the data set
        double result;
        int index = ratings.length / 2;

        Arrays.sort(ratings);

        if (ratings.length % 2 == 0) {
            result = (ratings[index] + ratings[index - 1]) / 2.0;
        } else {
            result = ratings[(int) Math.floor(index)];
        }

        return result;
    }

    @Override
    public int[] mode() { // values that appears the most

        List<Integer> modesList = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> keys = map.keySet();

        int max = 1;

        for (Integer rating : ratings) {
            if (map.containsKey(rating)) {
                map.put(rating, map.get(rating) + 1);

                if(map.get(rating) > max) {
                    max = map.get(rating);
                }

            } else {
                map.put(rating, 1);
            }
        }

        for (Integer key : keys) {
            if (map.get(key) == max) {
                modesList.add(key);
            }
        }

        return modesList.stream().mapToInt(Integer::intValue).toArray();
    }
}