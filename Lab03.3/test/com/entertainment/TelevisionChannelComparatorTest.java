package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
    Television tv;
    Television tv1;
    TelevisionChannelComparator comparator = new TelevisionChannelComparator();

    @Before
    public void setUp() {
        tv = new Television("Sony", 6);
        tv1 = new Television("Sony", 5);
    }

    @Test
    public void compare_shouldReturn0_whenSameChannel() {
        assertEquals(0, comparator.compare(tv1, tv));
    }

    @Test
    public void compare_shouldReturnNegativeOne_whenSameChannel() throws InvalidChannelException {
        tv1.changeChannel(999);
        assertEquals(-1, comparator.compare(tv, tv1));
    }

    // probably not needed -> if the above works, then the opposite is also true
    @Test
    public void compare_shouldReturnPositiveOne_whenSameChannel() throws InvalidChannelException {
        tv.changeChannel(999);
        assertEquals(1, comparator.compare(tv, tv1));
    }
}