package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee emp1;
    private Employee emp2;

    @Before
    public void setUp() {
        // this is an anonymous subclass of Employee
        // right here, right now, nowhere else subclass
        // also applies to interface implementation class, e.g., new Comparator<T>()
        emp1 = getEmployee();

        emp2 = getEmployee();

        // create 2 instances of DummyEmployee - named member level inner class
        // emp1 = new DummyEmployee("Marcos", Date.valueOf("2009-10-24"));
        // emp2 = new DummyEmployee("Marcos", Date.valueOf("2009-10-24"));
    }
    // create and return an instance of an anonymous subclass of employee
    private Employee getEmployee() {
        return new Employee("Marcos", Date.valueOf("2009-10-24")) {
            public double pay() { return 0; }
            public double payTaxes() { return 0; }
        };
    }

    @Test
    public void hashCode_shouldBeEqual_whenObjectsEqual() {
        assertEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        emp2.setName("DIFFERENT NAME");

        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2000-04-03"));

        assertNotEquals(emp1, emp2);
    }

    @Test
    // business_shouldDoWhat_whenWhat()
    public void equals_shouldReturnTrue_whenAllPropertiesSame() {
        assertEquals(emp1, emp2);
    }

    //NAMED, MEMBER-LEVEL INNER CLASSES
    private class DummyEmployee extends Employee {

        public DummyEmployee(String name , Date hireDate) {
            super(name, hireDate);
        }

        @Override
        public double pay() {
            return 0;
        }

        @Override
        public double payTaxes() {
            return 0;
        }
    }
}