package com.nikhat.LearningRestAPI.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // ✅ Lombok annotation that automatically generates:
// - Getters & Setters for all fields
// - toString() method
// - hashCode() and equals() methods
// - Required boilerplate code is removed → class is cleaner

@AllArgsConstructor // ✅ Lombok annotation that creates a constructor
// with parameters for all fields (id, name, email).
// Example: new StudentDto(1L, "Nikhat", "abc@gmail.com")

@NoArgsConstructor

public class StudentDto {
    private Long id;     // Unique identifier for the student
    private String name; // Student's name
    private String email; // Student's email
}

// 📌 DTO (Data Transfer Object):
// - DTO is used to transfer only required data between layers (Controller ↔ Service).
// - Helps hide Entity structure from the API response (good practice).
// - Prevents exposing database entities directly in REST API.
// - Makes it easier to change internal DB structure without breaking API response.
