package com.tahkin.test;

import javax.persistence.*;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Laptop_tbl")
public class LaptopManyToMany {
    @Id
    private int lId;
    private String lName;
    private int ram;

   @ManyToMany(mappedBy = "laptops") // inverse side
    private List<StudentManyToMany> students = new ArrayList<>();

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

    public List<StudentManyToMany> getStudents() {
        return students;
    }

    public void setStudents(List<StudentManyToMany> students) {
        this.students = students;
    }
}
