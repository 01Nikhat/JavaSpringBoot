package com.nikhat.parvin.hospitalManagement.entity;

import com.nikhat.parvin.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(
        name = "patient",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique patient email",columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name_birtdate",columnNames = {"name","birthDate"})
        },
        indexes={
                @Index(name = "idx_patient_birthDate",columnList = "birthDate")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private LocalDate birthDate;
    @Column(unique = true,nullable = false)
    private String email;
    private String gender;

    @CreationTimestamp
    private  LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne()
    @JoinColumn(name = "patient_insurance_id")
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointment;

}
