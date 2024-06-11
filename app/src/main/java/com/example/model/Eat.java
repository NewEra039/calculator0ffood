package com.example.model;

import java.util.Date;

public class Eat {
    private TypeOfEat typeOfEat;
    private Date date;
    private String name;
    private double protein;
    private double fat;
    private double carbs;
    private double calories;
    public Eat(){}

    public Eat(TypeOfEat typeOfEat, Date date, String name, double protein, double fat, double carbs, double calories) {
        this.typeOfEat = typeOfEat;
        this.date = date;
        this.name = name;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
        this.calories = calories;
    }

    public TypeOfEat getTypeOfEat() {
        return typeOfEat;
    }

    public void setTypeOfEat(TypeOfEat typeOfEat) {
        this.typeOfEat = typeOfEat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
