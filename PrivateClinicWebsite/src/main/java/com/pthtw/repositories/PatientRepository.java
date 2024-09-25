/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.repositories;

import com.pthtw.pojo.Patient;

/**
 *
 * @author admin
 */
public interface PatientRepository {
    Patient getPatientById(int id);
    void addPatient(Patient patient);
}
