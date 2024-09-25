/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.controllers;

import com.pthtw.services.StatsService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Linh
 */
@Controller
public class StatsController {
    @Autowired
    private StatsService statsService;
    
    @GetMapping("/stats")
    public String statsView(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("numberOfPatients", this.statsService.statsNumberOfPatients());
        return "stats";
    }
}
