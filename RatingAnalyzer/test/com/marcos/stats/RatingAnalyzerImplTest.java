package com.marcos.stats;

import org.junit.Test;
import org.stats.AnalyzerConfigurationException;
import org.stats.RatingAnalyzer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RatingAnalyzerImplTest {

    // EMPTY TEST
    @Test(expected = AnalyzerConfigurationException.class)
    public void ratingAnalyzerNewInstance_shouldThrowAnalyzerConfigurationException_whenEmptyArray() {
        int[] ratings = {};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
    }

    // NULL TEST
    @Test(expected = AnalyzerConfigurationException.class)
    public void ratingAnalyzerInstance_shouldThrowAnalyzerConfigurationException_whenNullArray() {
        int[] ratings = null;
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
    }

    // MEAN TESTS
    @Test
    public void mean_shouldReturnAverage_WhenLargeArray() {
        int[] ratings = {365, 24, 5, 1066, 7, 78, -989, 0, 1, -8};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);

        assertEquals(54.9, analyzer.mean(), .001);
    }

    @Test
    public void mean_shouldReturnAverage_WhenDoubleLength() {
        int[] ratings = {-323, 4};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);

        assertEquals(-159.5, analyzer.mean(), .001);
    }

    @Test
    public void mean_shouldReturnAverage_WhenSingleLength() {
        int[] ratings = {3};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);

        assertEquals(3.0, analyzer.mean(), .001);
    }

    // MODE TESTS
    @Test
    public void mode_shouldReturnModes_whenMultipleModes() {
        int[] ratings = {3, 4, 5, 6, 6, 7, 8, 9, 0, 1, 1, 1, 6, 5, 8, 4, 6, 3, 1, -8, 0, 0};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);

        int[] expected = {1, 6};
        assertArrayEquals(expected, analyzer.mode());
    }

    @Test
    public void mode_shouldReturnMode_whenSingleMode() {
        int[] ratings = {3, 4, 5, 6, 6, 7, 8, 9, 0, 1, 1, 6, 5, 8, 4, 6, 3, 1, -8, 0, 0};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);

        int[] expected = {6};
        assertArrayEquals(expected, analyzer.mode());
    }

    @Test
    public void mode_whenSingleMode() {
        int[] ratings = {3};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);

        for(int i : analyzer.mode()) {
            System.out.println(i);
        }
    }

    @Test
    public void mode_shouldReturnMode_whenDoubleLengthArray() {
        int[] ratings = {3, 2};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);

        int[] expected = {2, 3};
        assertArrayEquals(expected, analyzer.mode());
    }

    @Test
    public void mode_shouldReturnMode_whenSingleLengthArray() {
        int[] ratings = {3};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);

        int[] expected = {3};
        assertArrayEquals(expected, analyzer.mode());
    }

    // MEDIAN TESTS
    @Test
    public void median_shouldReturnMedian_whenEvenLengthArray() {
        int[] ratings = {-5,-8,-19,-20,-32,8,65,22,21,4};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);

        assertEquals(-0.5, analyzer.median(), .001);
    }

    @Test
    public void median_shouldReturnMedian_whenOddLengthArray() {
        int[] ratings = {3, 44, 5, 6, 787, 898, 98, 0, 13};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);

        assertEquals(13.0, analyzer.median(), .001);
    }

    @Test
    public void median_shouldReturnMedian_whenDoubleLengthArray() {
        int[] ratings = {-3, 15};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);

        assertEquals(6.0, analyzer.median(), .001);
    }

    @Test
    public void median_shouldReturnMedian_whenSingleLengthArray() {
        int[] ratings = {0};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);

        assertEquals(0.0, analyzer.median(), .001);
    }
}