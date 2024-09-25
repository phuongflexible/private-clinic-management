/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.repositories.impl;

import com.pthtw.pojo.Nurse;
import com.pthtw.repositories.NurseRepository;
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
public class NurseRepositoryImpl implements NurseRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Nurse> getList() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Nurse.class);
        Root<Nurse> root = query.from(Nurse.class);
        query.select(root);
        
        Query q = s.createQuery(query);
        List<Nurse> listNurse = q.getResultList();
        return listNurse;
    }

    @Override
    public void addOrUpdate(Nurse n) {
        Session s = this.factory.getObject().getCurrentSession();
        if (n.getId() != null)
            s.update(n);
        else
            s.save(n);
    }

    @Override
    public Nurse getNurseById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Nurse.class, id);
    }

    @Override
    public void deleteNurse(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Nurse d = this.getNurseById(id);
        s.delete(d);
    }

    @Override
    public List<Nurse> find(String kw) {
        List<Nurse> listAll= this.getList();
        List<Nurse> listNurse = new ArrayList<>();
        if (kw != null) { 
            for (int i = 0; i < listAll.size(); i++) {  
                if (listAll.get(i).getName().contains(kw)) {
                    Nurse n = listAll.get(i);
                    listNurse.add(n);
                }
            }
            return listNurse;
        }
        return listAll;
    }
    
}
