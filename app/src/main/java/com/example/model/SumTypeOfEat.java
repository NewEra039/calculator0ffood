package com.example.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SumTypeOfEat
{
    private Date data;
    private double SumColories;
    public SumTypeOfEat(Date data, double sumColories) {
        this.data = data;
        SumColories = sumColories;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public double getSumColories() {
        return SumColories;
    }
    public void setSumColories(double sumColories) {
        SumColories = sumColories;
    }
}
