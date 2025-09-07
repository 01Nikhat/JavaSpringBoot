package com.tahkin.test.SQL;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "School_tbl")

public class Students {
    @Id
    private int sId;
    private String sName;
    private int marks;

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "Students{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", marks=" + marks +
                '}';
    }
}
