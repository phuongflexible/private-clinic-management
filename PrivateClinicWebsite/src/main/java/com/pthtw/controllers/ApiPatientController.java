/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.controllers;

import com.pthtw.pojo.Patient;
import com.pthtw.services.PatientService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/api")
public class ApiPatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(path = "/patients/{patientId}/", 
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @CrossOrigin
    public ResponseEntity<Patient> retrieve(@PathVariable(value = "patientId") int id) {
        return new ResponseEntity<>(this.patientService.getPatientById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/patients/", consumes = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.MULTIPART_FORM_DATA_VALUE
    })
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public void create(
            @RequestParam Map<String, String> params,
            @RequestPart MultipartFile[] file
    ) {

            Patient p = new Patient();
            p.setName(params.get("name"));
            p.setGender(params.get("gender"));
            p.setPhoneNumber(params.get("phoneNumber"));
            p.setEmail(params.get("email"));

            if (file.length > 0) {
                p.setFile(file[0]);
            }

            this.patientService.addPatient(p);
    }
}
