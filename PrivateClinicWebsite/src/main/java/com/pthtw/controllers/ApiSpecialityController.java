/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.controllers;

import com.pthtw.pojo.Speciality;
import com.pthtw.services.SpecialityService;
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
public class ApiSpecialityController {
    @Autowired
    private SpecialityService specService;
    
    @GetMapping("/specialities/")
    @CrossOrigin
    public ResponseEntity<List<Speciality>> list() {
        return new ResponseEntity<>(this.specService.getSpecialities(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/specialities/{specialityId}/", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    @CrossOrigin
    public ResponseEntity<Speciality> retrieve(@PathVariable(value = "specialityId") int id) {
        return new ResponseEntity<>(this.specService.getSpecById(id), HttpStatus.OK);
    }

}
