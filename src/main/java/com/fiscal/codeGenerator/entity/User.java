package com.fiscal.codeGenerator.entity;

import java.time.LocalDate;

public class User {
    private String userName;
    private String userSurname;
    private LocalDate userDob;

    public User() {
    }

    public User(String userName, String userSurname, LocalDate userDob) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userDob = userDob;
    }

    public LocalDate getUserDob() {
        return userDob;
    }

    public void setUserDob(LocalDate userDob) {
        this.userDob = userDob;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userDob=" + userDob +
                '}';
    }
}
