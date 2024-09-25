/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.pthtw.pojo.Patient;
import com.pthtw.repositories.PatientRepository;
import com.pthtw.services.PatientService;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepo;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public Patient getPatientById(int id) {
        return this.patientRepo.getPatientById(id);
    }

    @Override
    public void addPatient(Patient patient) {
        
        if (!patient.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(patient.getFile().getBytes(), 
                        ObjectUtils.asMap("resource_type", "auto"));
                patient.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(PatientServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.patientRepo.addPatient(patient);
    }
    
}
