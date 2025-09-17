package com.nikhat.parvin.hospitalManagement.service;

import com.nikhat.parvin.hospitalManagement.entity.Patient;
import com.nikhat.parvin.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private  PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id){

       Patient p1 = patientRepository.findById(id).orElseThrow();
       Patient p2 =  patientRepository.findById(id).orElseThrow();
        System.out.println(p1 == p2);
       return p1;
    }

}
