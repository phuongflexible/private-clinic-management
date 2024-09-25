/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.repositories.impl;

import com.pthtw.pojo.Patient;
import com.pthtw.repositories.PatientRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public class PatientRepositoryImpl implements PatientRepository {
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public Patient getPatientById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Patient.class, id);
    }

    @Override
    public void addPatient(Patient patient) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(patient);
    }
    
}
