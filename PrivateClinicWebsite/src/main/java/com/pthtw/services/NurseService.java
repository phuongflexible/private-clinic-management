/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.services;

import com.pthtw.pojo.Nurse;
import java.util.List;

/**
 *
 * @author Linh
 */
public interface NurseService {
    List<Nurse> getList();
    void addOrUpdate(Nurse n);
    Nurse getNurseById(int id);
    void deleteNurse(int id);
    List<Nurse> find(String kw);
}
