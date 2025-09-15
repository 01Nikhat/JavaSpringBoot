package com.nikhat.LearningRestAPI.service;

import com.nikhat.LearningRestAPI.DTO.AddStudentRequestDto;
import com.nikhat.LearningRestAPI.DTO.StudentDto;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public interface StudentService {

    // Service layer interface keeps the business logic separate from controller.
    // Controller → Service → Repository (flow of data)

    // This method will return a list of students.
    // We are returning List<StudentDto> instead of List<StudentEntity>
    // because DTO is safer to expose outside (Entity directly represents the DB structure).
    List<StudentDto> getAllStudents(); //here it return list of students

    // This method will return a single student based on ID.
    // Again, returning StudentDto instead of Entity for data security and clarity.
    StudentDto getStudentById(Long id);

    StudentDto creatNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id,AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
