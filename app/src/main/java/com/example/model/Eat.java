package com.example.model;

import java.util.Date;

public class Eat {
    private Date date;
    private TypeOfEat typeOfEat;
    private String name;
    private double protein;
    private double fat;
    private double carbs;
    private double calories;

    public Eat(Date date,TypeOfEat typeOfEat, String name, double protein, double fat, double carbs, double calories) {
        this.date=date;
        this.typeOfEat=typeOfEat;
        this.name = name;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
        this.calories = calories;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TypeOfEat getTypeOfEat() {
        return typeOfEat;
    }

    public void setTypeOfEat(TypeOfEat typeOfEat) {
        this.typeOfEat = typeOfEat;
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
