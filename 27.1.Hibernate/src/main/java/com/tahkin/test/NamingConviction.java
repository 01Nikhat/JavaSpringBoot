package com.tahkin.test;

import javax.persistence.*;

@Entity
@Table(name = "employee_tbl")
public class NamingConviction {
    @Embedded
    private EmbeddableInsertion name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // optional, auto-increment
    private int eId;
    private String city;

    public EmbeddableInsertion getName() {
        return name;
    }

    public void setName(EmbeddableInsertion name) {
        this.name = name;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
