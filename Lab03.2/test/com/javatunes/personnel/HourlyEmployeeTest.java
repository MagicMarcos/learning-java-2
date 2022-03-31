package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    // business object under test (FIXTURE)
    private HourlyEmployee emp;
    private HourlyEmployee emp1;
    private HourlyEmployee emp2;

    @Before
    public void setUp() {
        System.out.println("setUp");

        emp = new HourlyEmployee("Bagheera", Date.valueOf("1993-10-11"), 85.0, 32.0);
        emp1 = new HourlyEmployee("Milo", Date.valueOf("2003-10-11"), 54.0, 40.0);
        emp2 = new HourlyEmployee("Bagheera", Date.valueOf("1993-10-11"), 85.0, 32.0);

    }

    @Test
    public void testPay() {
        System.out.println("testPay");

        assertEquals(2720.0, emp.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        System.out.println("testPayTaxes");

        assertEquals(680.0, emp.payTaxes(), .001);
    }

    @Test
    public void testHashCode() {
        System.out.println("testHashCode");

        assertEquals(emp.hashCode(), emp2.hashCode());
        assertNotEquals(emp.hashCode(), emp1.hashCode());
    }

    @Test
    public void testEquals() {
        System.out.println("testEquals");

        assertEquals(emp, emp2);
        assertNotEquals(emp,emp1);
    }
}