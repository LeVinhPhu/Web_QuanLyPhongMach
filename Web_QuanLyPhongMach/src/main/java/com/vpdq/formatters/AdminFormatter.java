/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.formatters;

import com.vpdq.pojo.Admin;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author vinhp
 */
public class AdminFormatter implements Formatter<Admin> {

    @Override
    public String print(Admin t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Admin parse(String id, Locale locale) throws ParseException {
        Admin adm = new Admin();
        adm.setId(Integer.parseInt(id));

        return adm;
    }

}
