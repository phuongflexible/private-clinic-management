/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.repositories.impl;

import com.pthtw.pojo.Doctor;
import com.pthtw.repositories.DoctorRepository;
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
public class DoctorRepositoryImpl implements DoctorRepository{

    @Autowired
    private LocalSessionFactoryBean factory; 
    
    @Override
    public List<Doctor> getList() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Doctor.class);
        Root<Doctor> root = query.from(Doctor.class);
        query.select(root);
        
        Query q = s.createQuery(query);
        List<Doctor> listDoc = q.getResultList();
        return listDoc;
    }

    @Override
    public void addOrUpdate(Doctor d) {
        Session s = this.factory.getObject().getCurrentSession();      
        if (d.getId() != null) {
            s.update(d);
        }
        else
            s.save(d);
    }

    @Override
    public Doctor getDoctorById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Doctor.class, id);
    }

    @Override
    public void deleteDoctor(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Doctor d = this.getDoctorById(id);
        s.delete(d);
    }

    @Override
    public List<Doctor> find(String kw) {
        List<Doctor> listAll= this.getList();
        List<Doctor> listDoc = new ArrayList<>();
        if (kw != null) { 
            for (int i = 0; i < listAll.size(); i++) {  
                if (listAll.get(i).getName().contains(kw)) {
                    Doctor d = listAll.get(i);
                    listDoc.add(d);
                }
            }
            return listDoc;
        }
        return listAll;
    }

    @Override
    public List<Doctor> getDoctorsBySpecId(int specId) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Doctor.findBySpecId");
        q.setParameter("specialityId", specId);
        return q.getResultList();
    }
    
    
    
}
