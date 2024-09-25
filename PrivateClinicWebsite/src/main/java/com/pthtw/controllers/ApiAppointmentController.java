/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.controllers;

import com.pthtw.pojo.Appointment;
import com.pthtw.pojo.Doctor;
import com.pthtw.pojo.Patient;
import com.pthtw.services.AppointmentService;
import com.pthtw.services.DoctorService;
import com.pthtw.services.PatientService;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/api")
public class ApiAppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private DoctorService docService;
    @Autowired
    private PatientService patientService;

    @GetMapping("/appointments/")
    @CrossOrigin
    public ResponseEntity<List<Appointment>> list() {
        return new ResponseEntity<>(this.appointmentService.getList(), HttpStatus.OK);
    }

    @GetMapping(path = "/appointments/{appointmentId}/", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Appointment> retrieve(@PathVariable(value = "appointmentId") int id) {
        return new ResponseEntity<>(this.appointmentService.getAppointmentById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/appointments/", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> create(
            @RequestBody Map<String, String> params,
            @DateTimeFormat(pattern = "dd/MM/yyyy") Date appointmentDate) {

        try {
            // Kiểm tra và chuyển đổi doctorId
            String doctorIdStr = params.get("doctorId");
            if (doctorIdStr == null || doctorIdStr.isEmpty()) {
                return new ResponseEntity<>("Doctor ID is required", HttpStatus.BAD_REQUEST);
            }
            int doctorId = Integer.parseInt(doctorIdStr);
            Doctor doctor = docService.getDoctorById(doctorId);
            if (doctor == null) {
                return new ResponseEntity<>("Doctor not found", HttpStatus.NOT_FOUND);
            }

            // Kiểm tra và chuyển đổi patientId
            String patientIdStr = params.get("patientId");
            if (patientIdStr == null || patientIdStr.isEmpty()) {
                return new ResponseEntity<>("Patient ID is required", HttpStatus.BAD_REQUEST);
            }
            int patientId = Integer.parseInt(patientIdStr);
            Patient patient = patientService.getPatientById(patientId);
            if (patient == null) {
                return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
            }

            // Chuyển đổi appointmentDate từ chuỗi sang Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date parsedAppointmentDate = dateFormat.parse(params.get("appointmentDate"));

            Appointment a = new Appointment();
            a.setPatientId(patient);
            a.setDoctorId(doctor);
            a.setReason(params.get("reason"));
            a.setAppointmentDate(parsedAppointmentDate);
            a.setShift(params.get("shift"));
            a.setStatus("Chờ xác nhận");
            a.setEmailSent((short) 0);
            a.setCreatedTime(new Date());

            this.appointmentService.addAppointment(a);
            return new ResponseEntity<>("Appointment created successfully", HttpStatus.CREATED);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid doctorId or patientId format", HttpStatus.BAD_REQUEST);
        } catch (ParseException e) {
            return new ResponseEntity<>("Invalid appointmentDate format", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("An error occurred while creating the appointment", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
