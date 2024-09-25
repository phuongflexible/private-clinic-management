/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.controllers;

import com.pthtw.pojo.Medicine;
import com.pthtw.services.CategoryService;
import com.pthtw.services.MedicineService;
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
public class MedicineController {
    @Autowired
    private MedicineService medicineService;
    
    @Autowired
    private CategoryService cateService;
    @GetMapping(value = "/medicine")
    public String getList(Model model) {
        model.addAttribute("medicines", new Medicine());
        model.addAttribute("medicines", this.medicineService.getList());
        return "medicine";
    }
    
    @GetMapping(value = "/addMedicine")
    public String createAddView(Model model) {
        model.addAttribute("medicine", new Medicine());
        model.addAttribute("categories", this.cateService.getList());
        return "addMedicine";
    }
    
    @PostMapping(value = "/addMedicine")
    public String add(@ModelAttribute(value = "medicine") @Valid Medicine m, BindingResult rs) {
        if (!rs.hasErrors()) {
            try {
                this.medicineService.addOrUpdate(m);
                return "redirect:/medicine";
            } catch(Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return "addMedicine";
    }
    
    @GetMapping(value = "/updateMedicine/{medicineId}")
    public String update(@PathVariable(value = "medicineId") int id, Model model) {
        model.addAttribute("medicine", this.medicineService.getMedicineById(id));
        model.addAttribute("categories", this.cateService.getList());
        return "addMedicine";
    }
    
    @DeleteMapping(value = "/deleteMedicine/{medicineId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "medicineId") int id, Model model) {
        this.medicineService.deleteMedicine(id);
    }
    
    @GetMapping(value = "/findMedicine")
    public String find(Model model, @RequestParam(value = "kw") String kw) {
        List<Medicine> listMedicine = this.medicineService.find(kw);
        model.addAttribute("medicines", listMedicine);
        return "medicine";
    }
}
