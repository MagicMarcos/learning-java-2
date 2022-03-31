package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    // Fixtures
    Television tv;
    Television tv1;

    @Before
    public void setUp() {
        tv = new Television("Sony", 5, DisplayType.LED);
        tv1 = new Television("Sony", 5, DisplayType.LED);
    }

    // setVolume() tests
    @Test
    public void setVolume_shouldStoreVolume_whenValidValue_LowerBound() {
        tv.setVolume(0);

        assertEquals(0, tv.getVolume());
    }

    @Test
    public void setVolume_shouldStoreVolume_whenValidValue_NextTo_LowerBound() {
        tv.setVolume(1);

        assertEquals(1, tv.getVolume());
    }

    @Test
    public void setVolume_shouldStoreVolume_whenValidValue_UpperBound() {
        tv.setVolume(100);

        assertEquals(100, tv.getVolume());
    }

    @Test
    public void setVolume_shouldStoreVolume_whenValidValue_NextTo_UpperBound() {
        tv.setVolume(99);

        assertEquals(99, tv.getVolume());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalidValue_LowerBound() {
        tv.setVolume(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalidValue_UpperBound() {
        tv.setVolume(101);
    }

    // changeChannel() tests
    @Test
    public void changeChannel_shouldStoreChannel_whenValidValue_LowerBound() throws InvalidChannelException {
        tv.changeChannel(1);

        assertEquals(1, tv.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreChannel_whenValidValue_NextTo_LowerBound() throws InvalidChannelException {
        tv.changeChannel(2);

        assertEquals(2, tv.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreChannel_whenValidValue_UpperBound() throws InvalidChannelException {
        tv.changeChannel(999);

        assertEquals(999, tv.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreChannel_whenValidValue_NextTo_UpperBound() throws InvalidChannelException {
        tv.changeChannel(998);

        assertEquals(998, tv.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldThrowIllegalChannelException_whenInvalidValueLowerBound() {
        try {
            tv.changeChannel(0);

            fail("Should have thrown IllegalChannelException");
        } catch (InvalidChannelException e) {
            assertEquals("Invalid channel: " + 0 + ". " +
                    "Allowed range: [" + 1 + "," + 999 + "].", e.getMessage());
        }
    }

    @Test
    public void changeChannel_shouldThrowIllegalChannelException_whenInvalidValueUpperBound() {
        try {
            tv.changeChannel(1000);
            fail("Should have thrown IllegalChannelException");
        } catch(InvalidChannelException e) {
            assertEquals("Invalid channel: " + 1000 + ". " +
                    "Allowed range: [" + 1 + "," + 999 + "]." , e.getMessage());
        }
    }

    // compareTo()
    @Test
    public void compareTo_shouldReturnZero_whenBrandAreEqual() {
        assertEquals(0, tv1.compareTo(tv));
    }

    @Test
    public void compareTo_shouldReturnPositiveNumber_whenBrandDifferent() {
        tv1.setBrand("Toshiba");
        // tv1 is greater than tv
        assertTrue(tv1.compareTo(tv) > 0);
    }

    // hashCode()
    @Test
    public void hashCode_shouldBeEqual_whenObjectsEqual() {
        assertEquals(tv.hashCode(), tv1.hashCode());
    }

    // equals()
    @Test
    public void equals_shouldBeTrue_whenSameBrand_SameVolume_SameDisplay() {
        assertEquals(tv, tv1);
    }

    @Test
    public void equals_shouldBeFalse_whenSameBrand_SameVolume_DifferentDisplay() {
        tv1.setDisplay(DisplayType.PLASMA);

        assertNotEquals(tv, tv1);
    }

    @Test
    public void equals_shouldBeFalse_whenSameBrand_DifferentVolume_SameDisplay() {
        tv1.setVolume(50);

        assertNotEquals(tv, tv1);
    }

    @Test
    public void equals_shouldBeFalse_whenDifferentBrand_SameVolume_SameDisplay() {
        tv1.setBrand("DIFFERENT BRAND");

        assertNotEquals(tv, tv1);
    }
}