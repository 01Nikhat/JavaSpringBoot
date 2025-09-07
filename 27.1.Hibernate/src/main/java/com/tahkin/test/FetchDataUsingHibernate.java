package com.tahkin.test;

public class FetchDataUsingHibernate {

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

    @Override
    public String toString() {
        return "FetchDataUsingHibernate{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userDesig='" + userDesig + '\'' +
                '}';
    }
}
