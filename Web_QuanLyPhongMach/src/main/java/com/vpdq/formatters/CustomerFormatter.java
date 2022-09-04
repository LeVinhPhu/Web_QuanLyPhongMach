/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.formatters;

import com.vpdq.pojo.Customer;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author phamt
 */
public class CustomerFormatter implements Formatter<Customer> {
    @Override
    public String print(Customer t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Customer parse(String id,
             Locale locale) throws ParseException {
        Customer c = new Customer();
        c.setId(Integer.parseInt(id));

        return c;
    }
}
