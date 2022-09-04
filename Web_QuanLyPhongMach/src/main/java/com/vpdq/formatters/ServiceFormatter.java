/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.formatters;


import com.vpdq.pojo.Service;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author phamt
 */
public class ServiceFormatter implements Formatter<Service> {
    @Override
    public String print(Service t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Service parse(String sId, Locale locale) throws ParseException {
        Service s = new Service();
        s.setId(Integer.parseInt(sId));
        
        return s;
    }
}
