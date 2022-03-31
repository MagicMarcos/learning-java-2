/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

public class EmployeeFactory {

    // prevent direct instantiation - this is an all-static factory class
    private EmployeeFactory() {
    }

    /**
     * DONE: given the input map, create and return the correct object (with its properties set).
     * If the input map's "type" value is not "HE" or "SE", throw IllegalArgumentException with a suitable message.
     */
    public static Employee createEmployee(Map<String, String> inputMap)
            throws IllegalArgumentException {
        // return value
        Employee emp = null;

        // read "type" from map -> respond accordingly
        String type = inputMap.get("type");

        if (!"SE".equals(type) && !"HE".equals(type)) {
            throw new IllegalArgumentException("Invalid type: " + type);
        }

        // type can only be HE or SE at this point -> we can avoid redundancy
        // we can safely extract common properties (name && hireDate) from inputMap
        String name = inputMap.get("name");
        Date hireDate = Date.valueOf(inputMap.get("hireDate"));

        if ("SE".equals(type)) {
            double salary = Double.parseDouble(inputMap.get("salary"));
            emp = new SalariedEmployee(name, hireDate, salary)  ;
        }
        else {
            double rate = Double.parseDouble(inputMap.get("rate"));
            double hours = Double.parseDouble(inputMap.get("hours"));
            emp = new HourlyEmployee(name, hireDate, rate, hours);
        }


//        switch (type) {
//            case "HE":
//            case "SE":
//            default:
//                throw new IllegalArgumentException("Invalid type: " + type);
//        }
        return emp;
    }
}