/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.controllers;

import com.pthtw.pojo.Doctor;
import com.pthtw.services.DoctorService;
import com.pthtw.services.SpecialityService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Linh
 */
@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    
    @Autowired
    private SpecialityService specService;
    
    @GetMapping(value = "/doctor")
    public String list(Model model) { 
        model.addAttribute("doctors", new Doctor());
        model.addAttribute("doctors", this.doctorService.getList());
        return "doctor";
    }
    
    @GetMapping(value = "/addDoctor")
    public String createAddView(Model model) {
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("specialities", this.specService.getSpecialities());
        return "addDoctor";
    }
    
    @PostMapping(value = "/addDoctor")
    public String add(@ModelAttribute(value = "doctor") @Valid Doctor d, BindingResult rs) {
        if (!rs.hasErrors()) {
            try {   
                this.doctorService.addOrUpdate(d);
                return "redirect:/doctor";
            } catch(Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return "addDoctor";
    }
    
    @GetMapping(value = "/updateDoctor/{doctorId}")
    public String update(Model model, @PathVariable(value = "doctorId") int id) {
        model.addAttribute("doctor", this.doctorService.getDoctorById(id)); 
        model.addAttribute("specialities", this.specService.getSpecialities());
        return "addDoctor";
    }
    
    @DeleteMapping("/deleteDoctor/{doctorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctor(Model model, @PathVariable(value = "doctorId") int id) {  
        this.doctorService.deleteDoctor(id);    
    } 
    
    @GetMapping(value = "/findDoctor")
    public String find(Model model, @RequestParam(value = "kw") String kw) {       
        List<Doctor> listDoc = this.doctorService.find(kw);
        model.addAttribute("doctors", listDoc);
        return "doctor";    
    }
}
