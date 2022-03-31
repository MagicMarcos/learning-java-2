package com.javatunes.personnel;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

public class SalariedEmployeeTest {
    // business object under test (FIXTURE)
    private SalariedEmployee emp;
    private SalariedEmployee emp2;

    @Before
    public void setUp() {
        System.out.println("setUp");
        emp = new SalariedEmployee("Marcos", Date.valueOf("2009-10-24"), 5_500.0);
        emp2 = new SalariedEmployee("Marcos", Date.valueOf("2009-10-24"), 5_500.0);
    }

    @Test
    public void testPay() {
        assertEquals(5500.0, emp.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(1650, emp.payTaxes(), .001);
    }

    @Test
    public void testHashCode() {
        assertEquals(emp.hashCode(), emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary() {
        emp2.setSalary(2_300.0);

        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary() {
        emp2.setHireDate(Date.valueOf("2000-02-02"));

        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate_sameSalary() {
        emp2.setName("DIFFERENT NAME");

        assertNotEquals(emp, emp2);
    }
}