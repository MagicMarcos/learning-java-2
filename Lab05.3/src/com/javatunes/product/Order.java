/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import com.javatunes.billing.Location;
import com.javatunes.billing.TaxCalculator;
import com.javatunes.billing.TaxCalculatorFactory;


import java.util.Collection;

public class Order {
    private String id;
    private Location location;
    private double subtotal;


    public Order(String id, Location location) {
        this.id = id;
        this.location = location;
    }

    /*
     * returns tax on this order
     * Actual work is delegated to a Tax Calculator
     * Few options:
     *  0. direct instantiation
     *   if (online) TaxCalculator calc = new OnlineTax()    // WORST OPTION
     *  1. look it up or fetch it from somewhere, e.g., a factory
     *  2. use dependency injection, i.e., some outside party (e.g., a client)
     *   "inject" the TaxCalculator into the order (perhaps at ctor time)
     */
    public double getTax() {
        TaxCalculator calc = TaxCalculatorFactory.createTaxCalculator(getLocation());

        return calc.taxAmount(getSubtotal()); // can't throw null pointer bc location is ENUM
    }

    /**
     * get the items from the cart and iterate over them, print each item's product code
     * get cart total and print
     */
    public void processCart(ShoppingCart<? extends Product> cart) {
        System.out.println("Order: " + getId() + " contains the following:");

        Collection<? extends Product> cartItems = cart.allItems();
        for (Product product : cartItems) {
            System.out.println(product.getCode());
        }

        subtotal = cart.total();

        System.out.println("Order Total: " + getSubtotal());
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public double getSubtotal() {
        return subtotal;
    }
}