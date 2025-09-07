package com.tahkin.test.cacheLevel1;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="student_tbl") // 👈 match actual DB table
public class Students {
    @Id
    private int sId;
    private String sName;
    private String branch;

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getName() {
        return sName;
    }

    public void setName(String name) {
        this.sName = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Students{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
