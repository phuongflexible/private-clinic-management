/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.repositories;

import com.pthtw.pojo.Speciality;
import java.util.List;

/**
 *
 * @author admin
 */
public interface SpecialityRepository {
    List<Speciality> getSpecialities();
    Speciality getSpecById(int id);
}
