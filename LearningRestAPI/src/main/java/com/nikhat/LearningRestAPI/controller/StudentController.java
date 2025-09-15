package com.nikhat.LearningRestAPI.controller;

import com.nikhat.LearningRestAPI.DTO.AddStudentRequestDto;
import com.nikhat.LearningRestAPI.DTO.StudentDto;
import com.nikhat.LearningRestAPI.entity.StudentEntity;

import com.nikhat.LearningRestAPI.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Map;


@RestController //this controller two annotatioon one is controller which help in maping
//second it return response in json format
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;
    //controller always talk to service

    // making constructor for service
    public StudentController( StudentService studentService) {
        this.studentService = studentService;

    }


    @GetMapping
    public ResponseEntity<List<StudentDto> >getStudentEntity(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());  // ✅ use injected service, not interface name
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id)); // ✅ return DTO, not just String
    }

// ------------------post method ----------------------------
    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
            return ResponseEntity.status(HttpStatus.CREATED).body(studentService.creatNewStudent(addStudentRequestDto));
    }

    //--------------------delete method------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    //-----------put method to change all information---------------------
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,@RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(studentService.updateStudent(id,addStudentRequestDto));
    }


    //=============patch method to change partial information---------------
    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String,Object>updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id,updates));
    }
}
