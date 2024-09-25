/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.services;

import com.pthtw.pojo.Medicine;
import java.util.List;

/**
 *
 * @author Linh
 */
public interface MedicineService {
    List<Medicine> getList();
    void addOrUpdate(Medicine m);
    Medicine getMedicineById(int id);
    void deleteMedicine(int id);
    List<Medicine> find(String kw);
}
