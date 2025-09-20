package com.nikhat.parvin.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String name;

    @Column(nullable = false,length = 100)
    private String specialization;

    @Column(nullable = false,unique = true,length = 100)
    private String email;

    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments = new HashSet<>();

}
