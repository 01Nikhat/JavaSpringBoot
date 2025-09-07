package com.tahkin.test;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HibernateDemo {
    @Id
    private int userId;
    private String userName;
    private String userDesig;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDesig() {
        return userDesig;
    }

    public void setUserDesig(String userDesig) {
        this.userDesig = userDesig;
    }
}
