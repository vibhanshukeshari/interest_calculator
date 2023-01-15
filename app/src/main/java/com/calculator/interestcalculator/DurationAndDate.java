package com.calculator.interestcalculator;

public class DurationAndDate {
    int year;
    int month;
    int day;
    String fromDate;
    String toDate;
    double duration;
    boolean radioButtonDurationOrDataStatus;







    public boolean isRadioButtonDurationOrDataStatus() {
        return radioButtonDurationOrDataStatus;
    }

    public void setRadioButtonDurationOrDataStatus(boolean radioButtonDurationOrDataStatus) {
        this.radioButtonDurationOrDataStatus = radioButtonDurationOrDataStatus;
    }

    public double getDuration() {




        if(radioButtonDurationOrDataStatus){

//            if(month <12 || day < 31){
//                duration = 0;
//            } else {

//            if(month == 12) {
//                year++;
//                month = 0;
//            }
//            Please note that the standard working days to be considered is 30 days irrespective of whether the number of days in a month is 28/29/30/31 days.
//            if(day == 30){
//                month++;
//                day = 0;
//            }
//                duration = ((year*365.0) + (month*30.0) + day);
//                duration = duration/365.00;

            duration = (year + (Double.parseDouble(String.valueOf(month))/12) + (Double.parseDouble(String.valueOf(day)) /(30 * 12)));

//            }



        }else {

        }









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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

}
