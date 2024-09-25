/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.repositories.impl;

import com.pthtw.pojo.Medicine;
import com.pthtw.repositories.MedicineRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Linh
 */
@Repository
@Transactional
public class MedicineRepositoryImpl implements MedicineRepository {
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Medicine> getList() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Medicine.class);
        Root<Medicine> root = query.from(Medicine.class);
        query.select(root);
        
        Query q = s.createQuery(query);
        List<Medicine> listMedicine = q.getResultList();
        return listMedicine;
    }

    @Override
    public void addOrUpdate(Medicine m) {
        Session s = this.factory.getObject().getCurrentSession();
        if (m.getId() != null) 
            s.update(m);
        else
            s.save(m);
    }

    @Override
    public Medicine getMedicineById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Medicine.class, id);
    }

    @Override
    public void deleteMedicine(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Medicine m = this.getMedicineById(id);
        s.delete(m);
    }

    @Override
    public List<Medicine> find(String kw) {
        List<Medicine> listAll= this.getList();
        List<Medicine> listMedicine = new ArrayList<>();
        if (kw != null) { 
            for (int i = 0; i < listAll.size(); i++) {  
                if (listAll.get(i).getName().contains(kw)) {
                    Medicine d = listAll.get(i);
                    listMedicine.add(d);
                }
            }
            return listMedicine;
        }
        return listAll;
    }
    
}
