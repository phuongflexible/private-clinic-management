/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.formatters;

import com.pthtw.pojo.Category;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Linh
 */
public class CategoryFormatter implements Formatter<Category>{

    @Override
    public String print(Category cate, Locale locale) {
        return String.valueOf(cate.getId());
    }

    @Override
    public Category parse(String id, Locale locale) throws ParseException {
        Category c = new Category();
        c.setId(Integer.parseInt(id));
        return c;
    }
    
}
