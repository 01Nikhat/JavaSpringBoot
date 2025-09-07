package com.tahkin.test;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity (name = "Student_tbl")
public class StudentsForOneToOne {
    @Id
    private int sId;
    private String sName;
    private String branch;

    @OneToOne
    private LaptopForOneToOne laptop;


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

    public LaptopForOneToOne getLaptop() {
        return laptop;
    }

    public void setLaptop(LaptopForOneToOne laptop) {
        this.laptop = laptop;
    }
}
