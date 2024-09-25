/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.pthtw.pojo.Doctor;
import com.pthtw.repositories.DoctorRepository;
import com.pthtw.services.DoctorService;
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
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository docRepo;
    @Autowired
    private Cloudinary cloudinary;
  
    @Override
    public List<Doctor> getList() {
        return this.docRepo.getList();
    }

    @Override
    public void addOrUpdate(Doctor d) {
        if (!d.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(d.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                d.setAvatar(res.get("secure_url").toString());     
            } catch (IOException ex) {
                Logger.getLogger(DoctorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.docRepo.addOrUpdate(d);
    }

    @Override
    public Doctor getDoctorById(int id) {
        return this.docRepo.getDoctorById(id);
    }

    @Override
    public void deleteDoctor(int id) {
        this.docRepo.deleteDoctor(id);
    }

    @Override
    public List<Doctor> find(String kw) {
        return this.docRepo.find(kw);
    }

    @Override
    public List<Doctor> getDoctorsBySpecId(int specId) {
        return this.docRepo.getDoctorsBySpecId(specId);
    }
}
