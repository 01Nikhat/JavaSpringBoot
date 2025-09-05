package com.tahkin.test;

import javax.persistence.*;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student_tbl")
public class StudentOneToMany {
    @Id
    private int sId;
    private String sName;
    private String branch;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<LaptopOneToMany> laptops = new ArrayList<>();

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

    public List<LaptopOneToMany> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<LaptopOneToMany> laptops) {
        this.laptops = laptops;
    }
}
