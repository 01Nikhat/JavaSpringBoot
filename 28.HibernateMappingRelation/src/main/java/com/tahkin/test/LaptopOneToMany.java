package com.tahkin.test;

import javax.persistence.*;

@Entity
@Table(name = "Laptop_tbl")
public class LaptopOneToMany {
    @Id
    private int lId;
    private String lName;
    private int ram;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentOneToMany student;

    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public StudentOneToMany getStudent() {
        return student;
    }

    public void setStudent(StudentOneToMany student) {
        this.student = student;
    }
}
