/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.repositories;

import com.pthtw.pojo.Doctor;
import java.util.List;

/**
 *
 * @author Linh
 */
public interface DoctorRepository {
    List<Doctor> getList();
    void addOrUpdate(Doctor d);
    Doctor getDoctorById(int id);
    void deleteDoctor(int id);
    List<Doctor> find(String kw);
    
    List<Doctor> getDoctorsBySpecId(int specId);
}
