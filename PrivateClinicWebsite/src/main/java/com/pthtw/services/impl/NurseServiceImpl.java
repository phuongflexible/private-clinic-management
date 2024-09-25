/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.pthtw.pojo.Nurse;
import com.pthtw.repositories.NurseRepository;
import com.pthtw.services.NurseService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Linh
 */
@Service
public class NurseServiceImpl implements NurseService {
    
    @Autowired
    private NurseRepository nurseRepo;
    
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<Nurse> getList() {
        return this.nurseRepo.getList();
    }

    @Override
    public void addOrUpdate(Nurse n) {
        if (!n.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(n.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                n.setAvatar(res.get("secure_url").toString());     
            } catch (IOException ex) {
                Logger.getLogger(DoctorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.nurseRepo.addOrUpdate(n);
    }

    @Override
    public Nurse getNurseById(int id) {
        return this.nurseRepo.getNurseById(id);
    }

    @Override
    public void deleteNurse(int id) {
        this.nurseRepo.deleteNurse(id);
    }

    @Override
    public List<Nurse> find(String kw) {
        return this.nurseRepo.find(kw);
    }
    
}
