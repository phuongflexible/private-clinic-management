/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.controllers;

import com.pthtw.pojo.Schedule;
import com.pthtw.services.DoctorService;
import com.pthtw.services.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Linh
 */
@Controller
public class ScheduleController {
    
    @Autowired
    private DoctorService doctorService;
    
    @Autowired
    private NurseService nurseService;
    
    @GetMapping(value = "/schedule")
    public void list() {
        
    }
    
    @GetMapping(value = "/arrangeSchedule")
    public void createAddView(Model model) {
        model.addAttribute("schedule", new Schedule());
        model.addAttribute("doctors", this.doctorService.getList());
        model.addAttribute("nurses", this.nurseService.getList());
        //return "arrangeSchedule";
    }
    
    @PostMapping(value = "/arrangeSchedule")
    public void add(@ModelAttribute(value = "schedule") Schedule s, BindingResult rs) {
        
    }
    
    @GetMapping(value = "/updateSchedule/{scheduleId}")
    public void update() {
        
    }
    
    @DeleteMapping(value = "/deleteSchedule/{scheduleId}")
    public void delete() {
        
    }
    
    @GetMapping(value = "/findSchedule")
    public void find() {
        
    }
}
