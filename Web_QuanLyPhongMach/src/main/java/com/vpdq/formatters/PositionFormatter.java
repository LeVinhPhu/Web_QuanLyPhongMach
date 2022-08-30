/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.formatters;

import com.vpdq.pojo.Position;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author vinhp
 */
public class PositionFormatter implements Formatter<Position> {

    @Override
    public String print(Position t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Position parse(String positionId,
             Locale locale) throws ParseException {
        Position p = new Position();
        p.setId(Integer.parseInt(positionId));

        return p;
    }

}
