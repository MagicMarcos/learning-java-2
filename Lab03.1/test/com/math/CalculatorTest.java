/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.*;

public class CalculatorTest {
    // business object under test
    private Calculator calc;

    @BeforeClass
    public static void initFullTestRun() {
        // use judiciously, objects are not cleaned up until the end of the FULL test run - can dirty up some tests
        System.out.println("Initialize entire test run");
    }

    @AfterClass
    public static void cleanUpFullTestRun() {
        System.out.println("Clean up entire test run");
    }

    @Before
    // fires before each test method, giving up a "fresh" calc in each method
    // removes the need to manually initialize calc in each method + removes any danger of calc = null
    public void setUp() {
        System.out.println("setUp");
        calc = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        // can be used for closing files, dbs or other external resources opened in setUp()
        System.out.println("tearDown");
    }

    @Test
    public void testAdd() {
        System.out.println("Test Add");

        assertEquals(5, calc.add(1, 4));  // expected, actual
    }

    @Test
    public void testDivide() {
        System.out.println("Test Divide");

        assertEquals(2, calc.divide(8, 4), .001); // expected, actual, delta
    }

    @Test
    public void testIsEven() {
        System.out.println("Test IsEven");

        assertTrue(calc.isEven(8)); // return true
        assertFalse(calc.isEven(7)); // return false
    }
}