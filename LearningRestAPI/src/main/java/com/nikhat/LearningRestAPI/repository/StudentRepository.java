package com.nikhat.LearningRestAPI.repository;

import com.nikhat.LearningRestAPI.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is the Data Access Layer (Repository) for StudentEntity.
 * By extending JpaRepository, we automatically get all the basic CRUD
 * (Create, Read, Update, Delete) methods without writing any implementation.
 */
@Repository  // Marks this as a Spring Data Repository (Spring will scan and manage it)
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    // ✅ Explanation:
    // - StudentEntity → The entity class this repository will manage.
    // - Long → The type of the primary key (id) in StudentEntity.

    // Example methods inherited from JpaRepository:
    //   save(entity)         → Insert/Update a student
    //   findById(id)         → Find student by primary key
    //   findAll()            → Get all students
    //   deleteById(id)       → Delete student by primary key
    //   count()              → Count total records

    // We don’t need to write any method here because JpaRepository
    // already provides all the common database operations.
    // If needed, we can add custom query methods like:
    //   List<StudentEntity> findByName(String name);
}
