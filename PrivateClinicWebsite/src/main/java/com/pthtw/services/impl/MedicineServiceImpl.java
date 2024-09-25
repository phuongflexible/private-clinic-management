/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.services.impl;

import com.pthtw.pojo.Medicine;
import com.pthtw.repositories.MedicineRepository;
import com.pthtw.services.MedicineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Linh
 */
@Service
public class MedicineServiceImpl implements MedicineService {
    
    @Autowired
    private MedicineRepository medicineRepo;
    
    @Override
    public List<Medicine> getList() {
        return this.medicineRepo.getList();
    }

    @Override
    public void addOrUpdate(Medicine m) {
        this.medicineRepo.addOrUpdate(m);
    }

    @Override
    public Medicine getMedicineById(int id) {
        return this.medicineRepo.getMedicineById(id);
    }

    @Override
    public void deleteMedicine(int id) {
        this.medicineRepo.deleteMedicine(id);
    }

    @Override
    public List<Medicine> find(String kw) {
        return this.medicineRepo.find(kw);
    }
    
}
