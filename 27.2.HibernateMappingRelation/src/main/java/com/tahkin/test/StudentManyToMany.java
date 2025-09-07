package com.tahkin.test;

import javax.persistence.*;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student_tbl")
public class StudentManyToMany {
    @Id
    private int sId;
    private String sName;
    private String branch;

   @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_laptop", // join table
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "laptop_id")
    )
    private List<LaptopManyToMany> laptops = new ArrayList<>();

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<LaptopManyToMany> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<LaptopManyToMany> laptops) {
        this.laptops = laptops;
    }
}
