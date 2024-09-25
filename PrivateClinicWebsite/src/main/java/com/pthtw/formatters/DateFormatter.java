/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.formatters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Linh
 */
public class DateFormatter implements Formatter<Date> {

    @Override
    public String print(Date date, Locale locale) {
        String pattern = "dd-MM-yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        String formattedDate = df.format(date);
        return formattedDate;
    }

    @Override
    public Date parse(String birthday, Locale locale) throws ParseException {
        String pattern = "dd-MM-yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        Date date = df.parse(birthday);
        return date;
    }
    
}
