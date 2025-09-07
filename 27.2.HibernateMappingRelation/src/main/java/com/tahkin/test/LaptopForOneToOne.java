package com.tahkin.test;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "Laptop_tbl")
public class LaptopForOneToOne {
    @Id
    private int lId;
    private String name;
    private int ram;



    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
