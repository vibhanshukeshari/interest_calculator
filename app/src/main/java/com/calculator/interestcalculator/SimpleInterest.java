package com.calculator.interestcalculator;

import android.widget.Toast;

public class SimpleInterest extends CalculatorFragment{

    double principal;
    double rate;
    double time;
    int rateTypePA;
    int rateTypeFrequencyYMWDHQBI;
    double totalSimpleInterestAmount;



    public int getRateTypeFrequencyYMWDHQBI() {
        return rateTypeFrequencyYMWDHQBI;
    }

    public void setRateTypeFrequencyYMWDHQBI(int rateTypeFrequencyYMWDHQBI) {
        this.rateTypeFrequencyYMWDHQBI = rateTypeFrequencyYMWDHQBI;
    }




    public double getTotalSimpleInterestAmount() {


        if(rateTypeFrequencyYMWDHQBI == 0){

            if(rateTypePA == 0){
//             percentage wise
                totalSimpleInterestAmount = (principal * rate * time)/100;

            } else if(rateTypePA == 1){
//            Amount wise

                totalSimpleInterestAmount = ((principal * rate * time)/100) ;
            }

        } else if(rateTypeFrequencyYMWDHQBI == 1){
            if(rateTypePA == 0){
//             percentage wise
                totalSimpleInterestAmount = (principal * rate * time)/100;

            } else if(rateTypePA == 1){
//            Amount wise

                totalSimpleInterestAmount = ((principal * rate * time)/100) ;
            }

        } else if(rateTypeFrequencyYMWDHQBI == 2){
            if(rateTypePA == 0){
//             percentage wise
                totalSimpleInterestAmount = (principal * rate * time)/100;

            } else if(rateTypePA == 1){
//            Amount wise

                totalSimpleInterestAmount = ((principal * rate * time)/100) ;
            }

        } else if(rateTypeFrequencyYMWDHQBI == 3){
            if(rateTypePA == 0){
//             percentage wise
                totalSimpleInterestAmount = (principal * rate * time)/100;

            } else if(rateTypePA == 1){
//            Amount wise

                totalSimpleInterestAmount = ((principal * rate * time)/100) ;
            }

        } else if(rateTypeFrequencyYMWDHQBI == 4){
            if(rateTypePA == 0){
//             percentage wise
                totalSimpleInterestAmount = (principal * rate * time)/100;

            } else if(rateTypePA == 1){
//            Amount wise

                totalSimpleInterestAmount = ((principal * rate * time)/100) ;
            }

        } else if(rateTypeFrequencyYMWDHQBI == 5){
            if(rateTypePA == 0){
//             percentage wise
                totalSimpleInterestAmount = (principal * rate * time)/100;

            } else if(rateTypePA == 1){
//            Amount wise

                totalSimpleInterestAmount = ((principal * rate * time)/100) ;
            }

        } else if (rateTypeFrequencyYMWDHQBI == 6){
            if(rateTypePA == 0){
//             percentage wise
                totalSimpleInterestAmount = (principal * rate * time)/100;

            } else if(rateTypePA == 1){
//            Amount wise

                totalSimpleInterestAmount = ((principal * rate * time)/100) ;
            }

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
        return rateTypePA;
    }

    public void setRateType(int rateType) {
        this.rateTypePA = rateType;
    }





}
