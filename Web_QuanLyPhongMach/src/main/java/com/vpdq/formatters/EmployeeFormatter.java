/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.formatters;

import com.vpdq.pojo.Employee;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author vinhp
 */
public class EmployeeFormatter implements Formatter<Employee> {

    @Override
    public String print(Employee t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Employee parse(String id, Locale locale) throws ParseException {
        Employee e = new Employee();
        e.setId(Integer.parseInt(id));

        return e;
    }

}
