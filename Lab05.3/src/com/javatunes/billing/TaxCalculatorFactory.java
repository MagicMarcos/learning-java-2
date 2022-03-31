package com.javatunes.billing;

public class TaxCalculatorFactory {

    // this is an all static class - all static method(s) -> make private ctor
    private TaxCalculatorFactory(){}

    /*
     * Creates and returns the correct TaxCalculator, given a location
     *
     * NOTE: these implementation classes are "stateless", they have no fields or instance variables
     * This means Orders can use the same instances. We don't need to create new every time we're asked for one
     *
     * OPTIONAL CHALLENGE:
     *  Implement a simple "cache" of previously-created TaxCalculators
     *  consult your cache before returning the TaxCalculator
     *  If cache contains that one already, fetch it and return it.
     *  If not, create new, put it in the cache (for later) and return it.
     */
    public static TaxCalculator createTaxCalculator(Location location) {
        switch (location) {
            case USA:
                return new USATax();
            case ONLINE:
                return new OnlineTax();
            case EUROPE:
                return new EuropeTax();
            default:
                return null;
        }
    }
}