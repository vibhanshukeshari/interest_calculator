package com.calculator.interestcalculator;

import android.widget.Toast;

public class SimpleInterest extends CalculatorFragment{

    double principal;
    double rate;
    double time;
    int rateType;
    double totalSimpleInterestAmount;



//    public double getTotalInterestAmount() {
//        return totalInterestAmount;
//
//
//
//    }
//
//    public void setTotalInterestAmount(double totalInterestAmount) {
//        this.totalInterestAmount = totalInterestAmount;
//    }

    public double getTotalSimpleInterestAmount() {


        if(rateType == 0){

            totalSimpleInterestAmount = (principal * rate * time)/100;

        }

        return totalSimpleInterestAmount;
    }

    public void setInterestAmount(double totalAmount) {
        this.totalSimpleInterestAmount = totalAmount;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getRateType() {
        return rateType;
    }

    public void setRateType(int rateType) {
        this.rateType = rateType;
    }





}
