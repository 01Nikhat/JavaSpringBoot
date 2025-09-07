package com.tahkin.test.Level2Cache;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY) // ✅ or NONSTRICT_READ_WRITE
@Table(name = "student_tbl")
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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
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
                ", branch='" + branch + '\'' +
                '}';
    }
}
