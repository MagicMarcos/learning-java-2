package com.snacks;

class Radish implements Comparable<Radish>{
    // instance variables
    private final double diameter;
    private final double taiLength;
    private final int guysOnTop;

    // constructors
    public Radish(double diameter, double taiLength, int guysOnTop) {
        this.diameter = diameter;
        this.taiLength = taiLength;
        this.guysOnTop = guysOnTop;
    }

    // accessor methods (getters only)
    public double getDiameter() {
        return diameter;
    }

    public double getTaiLength() {
        return taiLength;
    }

    public int getGuysOnTop() {
        return guysOnTop;
    }

    /*
     * Natural order is defined by diameter.
     */
    @Override
    public int compareTo(Radish other) {
        return Double.compare(this.getDiameter(), other.getDiameter());
    }

    // toString()

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " +
                "diameter=" + getDiameter() +
                ", taiLength=" + getTaiLength() +
                ", guysOnTop=" + getGuysOnTop();
    }

}