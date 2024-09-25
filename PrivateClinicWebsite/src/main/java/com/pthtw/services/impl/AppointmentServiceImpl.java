/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.services.impl;

import com.pthtw.pojo.Appointment;
import com.pthtw.repositories.AppointmentRepository;
import com.pthtw.services.AppointmentService;
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
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepo;

    @Override
    public void addAppointment(Appointment appointment) {
        this.appointmentRepo.addAppointment(appointment);
    }

    @Override
    public List<Appointment> getList() {
        return this.appointmentRepo.getList();
    }

    @Override
    public Appointment getAppointmentById(int id) {
        return this.appointmentRepo.getAppointmentById(id);
    }
    
}
