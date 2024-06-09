package com.example.model;

public class Eat {
    private String name;
    private double protein;
    private double fat;
    private double carbs;
    private double calories;

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getCalories() {
        return calories;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
