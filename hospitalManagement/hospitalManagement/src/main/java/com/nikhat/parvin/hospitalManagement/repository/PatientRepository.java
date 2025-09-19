package com.nikhat.parvin.hospitalManagement.repository;

import com.nikhat.parvin.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.nikhat.parvin.hospitalManagement.entity.Patient;
import com.nikhat.parvin.hospitalManagement.entity.type.BloodGroupType;
import org.hibernate.query.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate,String email) ;

    Patient findByName(String name);



    @Query("SELECT p FROM Patient p WHERE p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query(value = "SELECT * FROM patient WHERE birth_date > :birthDate", nativeQuery = true)
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    // projection it only work on jpql not on native query
    @Query("select new com.nikhat.parvin.hospitalManagement.dto.BloodGroupCountResponseEntity( p.bloodGroup, Count(p)) from Patient p group by p.bloodGroup")
    // List<Object[]> countEachBloodGroup();
    List<BloodGroupCountResponseEntity> countEachBloodGroup();



    //------------------Pagination ----------------------------
    @Query(value = "select * from patient",nativeQuery = true)
    List<Patient> findAllPatients(Pageable pageable);

}
