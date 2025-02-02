package com.userpatient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userpatient.entity.Patient;
import com.userpatient.exception.PatientNotFoundException;
import com.userpatient.service.PatientService;

@RestController
//@RequestMapping("/patient")
//@CrossOrigin(origins = "http://localhost:8999")
@CrossOrigin(origins = "http://localhost:4200")

public class PatientController { 
	@Autowired
    PatientService service;
	
	
    @GetMapping("/patients/patient/{id}")
    public Patient showPatientInformation(@PathVariable Integer id){
    	
    	
        Patient patient = service.showPatientInformation(id);
        if(patient == null){
            throw new PatientNotFoundException(id + " is not in database");
        }
        return patient;
    }

    @PostMapping("/patients/patient")
    public boolean createPatient(@RequestBody Patient patient){
        service.savePatientInformation(patient);
        return true;
    }



}
