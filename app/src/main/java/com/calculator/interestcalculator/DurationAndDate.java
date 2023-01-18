package com.calculator.interestcalculator;

public class DurationAndDate {
    int year;
    int month;
    int day;

    public double getFromDateAndToDate() {
        return fromDateAndToDate;
    }

    public void setFromDateAndToDate(double fromDateAndToDate) {
        this.fromDateAndToDate = fromDateAndToDate;
    }

    double fromDateAndToDate;
    double duration;








    public double getDuration() {





            duration = (year + (Double.parseDouble(String.valueOf(month))/12) + (Double.parseDouble(String.valueOf(day)) /(30 * 12)));









        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

}
