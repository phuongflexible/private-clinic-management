/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.repositories.impl;

import com.pthtw.pojo.Patient;
import com.pthtw.pojo.Receipt;
import com.pthtw.repositories.StatsRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
public class StatsRepositoryImpl implements StatsRepository{
    
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public long statsNumberOfPatients() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Long> q = b.createQuery(Long.class);
        Root rP = q.from(Patient.class);
        q.select(b.count(rP));
        Query query = s.createQuery(q);
        return (long) query.getSingleResult();

        
    }

    @Override
    public List<Object[]> statsRevenueByPeriod(int year, String period) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
