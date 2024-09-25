/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.formatters;

import com.pthtw.pojo.Speciality;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Linh
 */
public class SpecialityFormatter implements Formatter<Speciality> {

    @Override
    public String print(Speciality spec, Locale locale) {
        return String.valueOf(spec.getId());
    }

    @Override
    public Speciality parse(String id, Locale locale) throws ParseException {
        Speciality s = new Speciality();
        s.setId(Integer.parseInt(id));  
        return s;
    }
    
}
