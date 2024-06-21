package com.example.model;

import java.util.Calendar;

public class User
{
    private String email;
    private String fio;
    private double weight;
    private double height;
    private String foto;
    public User(String email, String fio,double weight, double height,String foto) {
        this.email = email;
        this.fio = fio;
        this.weight = weight;
        this.height = height;
        this.foto=foto;
    }
    public User(){
    }
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
