package com.nikhat.parvin.hospitalManagement;

import com.nikhat.parvin.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.nikhat.parvin.hospitalManagement.entity.Patient;
import com.nikhat.parvin.hospitalManagement.entity.type.BloodGroupType;
import com.nikhat.parvin.hospitalManagement.repository.PatientRepository;
import com.nikhat.parvin.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
           List <Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }
    @Test
    public void testTransactionMethod(){
        Patient patient = patientRepository.findByName("sam");

        System.out.println(patient);

        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(
                LocalDate.of(1998,10,1), "noorah@gmail.com"
        );

        for (Patient patient1: patientList){
            System.out.println(patient1);
        }

        List<Patient> patientLists = patientRepository.findByBloodGroup(BloodGroupType.AB_POSITIVE);

        for (Patient patient2: patientLists){
            System.out.println(patient2);
        }

        List<Patient> patientList3 = patientRepository.findByBornAfterDate(LocalDate.of(2000,01,01));

        for (Patient patient2: patientList3){
            System.out.println(patient2);
        }

       // List<Object[]> bloodGroupList = patientRepository.countEachBloodGroup();

        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroup();

        for (BloodGroupCountResponseEntity bloodGroupCountResponse: bloodGroupList){
            System.out.println(bloodGroupCountResponse);
        }

        //-------------------------Pagination-----------------
        List<Patient> patientList5 = patientRepository.findAllPatients(PageRequest.of(0,2, Sort.by("name")));
        for (Patient patient5: patientList5){
            System.out.println(patient5);
        }
    }
}
