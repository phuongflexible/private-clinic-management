/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.repositories.impl;

import com.pthtw.pojo.Appointment;
import com.pthtw.repositories.AppointmentRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public void addAppointment(Appointment appointment) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(appointment);
    }

    @Override
    public List<Appointment> getList() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Appointment.findAll");
        return q.getResultList();
    }

    @Override
    public Appointment getAppointmentById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Appointment.class, id);
    }
    
}
