package com.calculator.interestcalculator;

public class CompoundInterest extends CalculatorFragment {

    double principal;
    double rate;
    int time;
    int rateType;
    double totalCompoundInterestAmount;
    int compoundingFrequency;

    double CompoundInterestAmountWithPrincipal;



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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getRateType() {
        return rateType;
    }

    public void setRateType(int rateType) {
        this.rateType = rateType;
    }

    public double getTotalCompoundInterestAmount() {

        if(compoundingFrequency == 0){

            totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),time)));


        }

        return totalCompoundInterestAmount;
    }

    public void setTotalCompoundInterestAmount(double totalCompoundInterestAmount) {
        this.totalCompoundInterestAmount = totalCompoundInterestAmount;
    }

    public int getCompoundingFrequency() {
        return compoundingFrequency;
    }

    public void setCompoundingFrequency(int compoundingFrequency) {
        this.compoundingFrequency = compoundingFrequency;
    }




}