/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.controllers;

import com.pthtw.pojo.Doctor;
import com.pthtw.services.DoctorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/api")
public class ApiDoctorController {
    @Autowired
    private DoctorService doctorService;
    
    @GetMapping("/doctors/")
    @CrossOrigin
    public ResponseEntity<List<Doctor>> list() {
        return new ResponseEntity<>(this.doctorService.getList(), HttpStatus.OK);
    }
            
    @GetMapping(path = "/specialities/{specialityId}/doctors/", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    @CrossOrigin
    public ResponseEntity<List<Doctor>> listDoctorsInSpeciality(@PathVariable(value = "specialityId") int specId) {
        return new ResponseEntity<>(this.doctorService.getDoctorsBySpecId(specId), HttpStatus.OK);
    }
}
