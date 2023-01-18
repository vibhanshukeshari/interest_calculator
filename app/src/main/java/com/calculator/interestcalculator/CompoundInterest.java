package com.calculator.interestcalculator;

public class CompoundInterest extends CalculatorFragment {

    double principal;
    double rate;
    double time;
    int CompoundInterestRateTypePA;
    double totalCompoundInterestAmount;
    int compoundingFrequency;
    int rateTypeFrequencyYMWDHQBI;
    double CompoundInterestAmountWithPrincipal;





    public int getRateTypeFrequency() {
        return rateTypeFrequencyYMWDHQBI;
    }

    public void setRateTypeFrequencyYMWDHQBI(int rateTypeFrequency) {
        this.rateTypeFrequencyYMWDHQBI = rateTypeFrequency;
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
        return CompoundInterestRateTypePA;
    }

    public void setRateType(int rateType) {
        this.CompoundInterestRateTypePA = rateType;
    }

    public double getTotalCompoundInterestAmount() {


        if(compoundingFrequency == 0){

            if(rateTypeFrequencyYMWDHQBI == 0){

                if(CompoundInterestRateTypePA == 0){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                }

            } else if(rateTypeFrequencyYMWDHQBI == 1) {

                if (CompoundInterestRateTypePA == 0) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (1 * time))));

                } else if (CompoundInterestRateTypePA == 1) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (1 * time))));


                }

            } else if(rateTypeFrequencyYMWDHQBI == 2){

                    if(CompoundInterestRateTypePA == 0){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }


                } else if(rateTypeFrequencyYMWDHQBI == 3){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 4){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 5){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 6){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                }
            } else if(compoundingFrequency == 1){



            if(rateTypeFrequencyYMWDHQBI == 0){

                if(CompoundInterestRateTypePA == 0){

                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 1) {

                if (CompoundInterestRateTypePA == 0) {

                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (1 * time))));

                } else if (CompoundInterestRateTypePA == 1) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (1 * time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 2){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 3){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 4){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 5){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 6){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                }
            } else if(compoundingFrequency == 2){


            if(rateTypeFrequencyYMWDHQBI == 0){

                if(CompoundInterestRateTypePA == 0){

                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 1) {

                if (CompoundInterestRateTypePA == 0) {

                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (1 * time))));

                } else if (CompoundInterestRateTypePA == 1) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (1 * time))));
                }
            }else if(rateTypeFrequencyYMWDHQBI == 2){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 3){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 4){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 5){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 6){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                }
            } else if(compoundingFrequency == 3){


            if(rateTypeFrequencyYMWDHQBI == 0){

                if(CompoundInterestRateTypePA == 0){

                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 1) {

                if (CompoundInterestRateTypePA == 0) {

                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (1 * time))));

                } else if (CompoundInterestRateTypePA == 1) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (1 * time))));
                }
            }else if(rateTypeFrequencyYMWDHQBI == 2){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 3){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 4){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 5){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 6){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                }
            } else if(compoundingFrequency == 4){


            if(rateTypeFrequencyYMWDHQBI == 0){

                if(CompoundInterestRateTypePA == 0){

                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 1) {

                if (CompoundInterestRateTypePA == 0) {

                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (1 * time))));

                } else if (CompoundInterestRateTypePA == 1) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (1 * time))));
                }
            }else if(rateTypeFrequencyYMWDHQBI == 2){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 3){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 4){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 5){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 6){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                }
            } else if(compoundingFrequency == 5){


            if(rateTypeFrequencyYMWDHQBI == 0){

                if(CompoundInterestRateTypePA == 0){

                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 1) {

                if (CompoundInterestRateTypePA == 0) {

                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (1 * time))));

                } else if (CompoundInterestRateTypePA == 1) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (1 * time))));
                }
            }else if(rateTypeFrequencyYMWDHQBI == 2){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 3){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 4){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 5){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 6){

                    if(CompoundInterestRateTypePA == 0){

                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                }
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