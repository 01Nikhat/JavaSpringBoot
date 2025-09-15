package com.nikhat.LearningRestAPI.service;

import com.nikhat.LearningRestAPI.DTO.AddStudentRequestDto;
import com.nikhat.LearningRestAPI.DTO.StudentDto;
import com.nikhat.LearningRestAPI.entity.StudentEntity;
import com.nikhat.LearningRestAPI.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Map;

@Service  // Marks this class as a Spring Service (business logic layer)
@RequiredArgsConstructor // Generates constructor for all final fields (dependency injection)
public class StudentServiceImpl implements StudentService {

    // Injecting StudentRepository to interact with DB
    private final StudentRepository studentRepository;

    // Injecting ModelMapper (used for converting Entity ↔ DTO easily)
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        // Step 1: Fetch all students from DB (List<StudentEntity>)
        List<StudentEntity> students = studentRepository.findAll();

        // Step 2: Convert List<StudentEntity> → List<StudentDto>
        // using stream and mapping entity fields into DTO fields
        List<StudentDto> studentDtoList = students
                .stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail()))
                .toList();

        // Step 3: Return DTO list to Controller
        return studentDtoList;

        // ✅ Alternative optimized way:
        // return students.stream()
        //        .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail()))
        //        .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        // Step 1: Fetch student from DB using ID
        // If not found, throw an exception
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id :" + id));

        // Step 2: Convert Entity → DTO and return
        return new StudentDto(student.getId(), student.getName(), student.getEmail());

        // ✅ Alternative if using ModelMapper:
        // return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto creatNewStudent(AddStudentRequestDto addStudentRequestDto) {
        StudentEntity newStudent = modelMapper.map(addStudentRequestDto, StudentEntity.class);
        StudentEntity student = studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exist by id :"+ id);

        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        StudentEntity student = studentRepository.findById(id).
                orElseThrow(()->new IllegalArgumentException("Student not found with this id :"+id));
        modelMapper.map(addStudentRequestDto,student);
        student = studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Students not found by id" + id));
        updates.forEach((field,value)->{
            switch (field){
                case "name": student.setName((String) value);
                break;
                case "email": student.setEmail((String) value);
                break;
                default:
                    throw new IllegalArgumentException("Field is not supported");
            }

        });
        StudentEntity savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent,StudentDto.class);
    }


}
