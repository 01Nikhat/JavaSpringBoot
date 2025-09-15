package com.nikhat.LearningRestAPI.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStudentRequestDto {
    @NotBlank(message = "Name is required...")
    @Size(min = 3,max = 30,message = "Name should be length of 3 to 30 character")
    private String name;
    @Email
    @NotBlank(message = "email is required...")
    private String email;
}
