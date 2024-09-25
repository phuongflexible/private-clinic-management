/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.controllers;

import com.pthtw.pojo.Nurse;
import com.pthtw.services.NurseService;
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
public class NurseController {
    @Autowired
    private NurseService nurseService;
    
    @GetMapping(value = "/nurse")
    public String list(Model model) { 
        model.addAttribute("nurses", new Nurse());
        model.addAttribute("nurses", this.nurseService.getList());
        return "nurse";
    }
    
    @GetMapping(value = "/addNurse")
    public String createAddView(Model model) {
        model.addAttribute("nurse", new Nurse());
        return "addNurse";
    }
    
    @PostMapping(value = "/addNurse")
    public String add(@ModelAttribute(value = "nurse") @Valid Nurse n, BindingResult rs) {
        if (!rs.hasErrors()) {
            try {   
                this.nurseService.addOrUpdate(n);
                return "redirect:/nurse";
            } catch(Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return "addNurse";
    }
    
    @GetMapping(value = "/updateNurse/{nurseId}")
    public String update(Model model, @PathVariable(value = "nurseId") int id) {
        model.addAttribute("nurse", this.nurseService.getNurseById(id)); 
        return "addNurse";
    }
    
    @DeleteMapping("/deleteNurse/{nurseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctor(Model model, @PathVariable(value = "nurseId") int id) {  
        this.nurseService.deleteNurse(id);    
    } 
    
    @GetMapping(value = "/findNurse")
    public String find(Model model, @RequestParam(value = "kw") String kw) {       
        List<Nurse> listNurse = this.nurseService.find(kw);
        model.addAttribute("nurses", listNurse);
        return "nurse";    
    }
}
