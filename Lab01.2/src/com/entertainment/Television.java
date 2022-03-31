package com.entertainment;

import java.util.Objects;

/**
 * "Equality" is defined by brand and volume
 *  This is handled in equals() and hashcode()
 *
 * To be consistent with equals - natural order should use the same,
 * properties as equality (brand and volume)
 *
 * Natural order is defined by brand (String), then by volume
 * "brand" is called the sort-key
 */

public class Television implements Comparable<Television> {
    private String brand;
    private int volume;

    private Tuner tuner = new Tuner();

    // constructors
    public Television() {
        // no arg constructor
    }

    public Television(String brand, int volume) {
        this.brand = brand;
        this.volume = volume;
    }

    // Business Methods
    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }

    // accessor methods

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    /*
    @Override
    public boolean equals(Object obj){
        boolean result = false;

        if (obj.getClass().equals(Television.class)) {  // ensure we are comparing EXACT classes - no IS-A issues
            // downcast obj to more specific reference type Television
            Television other = (Television) obj;

            // do the checks: brands AND volumes must match
            // result = this.getBrand().equals(other.getBrand());    // not null safe for Obj

            // Objects in java.util is an all static utility class, that does null-safe equal checks
            result = Objects.equals(this.getBrand(), other.getBrand()) && // null safe check
                    this.getVolume() == other.getVolume();
        }

        return result;
    }

    @Override
    public int hashCode() {
        // hash function below is not robust -- easily yields hash collisions (when diff objs have same hashCode)
        // return getBrand().length() + getVolume();

        // scientifically correct hash function
        return Objects.hash(getBrand(), getVolume());
    }
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;     // check if pointing to same object
        if (o == null || this.getClass() != o.getClass()) return false;     // check for null or diff classes

        // brand and volume checking
        Television that = (Television) o;      // downcast
        return getVolume() == that.getVolume() && Objects.equals(getBrand(), that.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
    }

    /*
     * Natural order is defined by brand (String) then by volume (int).
     *  We are using two sort keys to be consistent with equals
     */
    @Override   // interface comparable
    public int compareTo(Television other) {
        int result = this.getBrand().compareTo(other.getBrand());

        if(result == 0) {
            result = Integer.compare(this.getVolume(), other.getVolume());
        }

        return result;
    }

    // toString()
    public String toString() {
        return getClass().getSimpleName() + ": " + getBrand() + ", volume=" + getVolume() +
                ", channel= " + getCurrentChannel();
    }
}