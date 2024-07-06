package org.enset.hospitalenset.web;

import org.enset.hospitalenset.entities.Patient;
import org.enset.hospitalenset.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/patientsList")
    public List<Patient> patientList(){
        return patientRepository.findAll();
    }

}
