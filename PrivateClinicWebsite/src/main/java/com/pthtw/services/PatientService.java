/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.services;
import com.pthtw.pojo.Patient;

/**
 *
 * @author admin
 */
public interface PatientService {
    public Patient getPatientById(int id);
    void addPatient(Patient patient);
}
