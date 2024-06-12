package com.example.model;

import java.util.Date;

public class User
{
    private String email;
    private String fio;
    private Date birthDay;
    private double weight;
    private double height;
    public User(String email, String fio, Date birthDay, double weight, double height) {
        this.email = email;
        this.fio = fio;
        this.birthDay = birthDay;
        this.weight = weight;
        this.height = height;
    }
    public User(){}
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFio() {
        return fio;
    }
    public void setFio(String fio) {
        this.fio = fio;
    }
    public Date getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
}
