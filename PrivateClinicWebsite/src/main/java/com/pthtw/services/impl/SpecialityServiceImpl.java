/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.services.impl;

import com.pthtw.pojo.Speciality;
import com.pthtw.repositories.SpecialityRepository;
import com.pthtw.services.SpecialityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Service
@Transactional
public class SpecialityServiceImpl implements SpecialityService {
    @Autowired
    private SpecialityRepository specRepo;
    
    @Override
    public List<Speciality> getSpecialities() {
        return this.specRepo.getSpecialities();
    }

    @Override
    public Speciality getSpecById(int id) {
        return this.specRepo.getSpecById(id);
    }
    
}
