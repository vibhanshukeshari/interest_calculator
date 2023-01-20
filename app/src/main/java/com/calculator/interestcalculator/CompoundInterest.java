package com.calculator.interestcalculator;

public class CompoundInterest extends CalculatorFragment {

    double principal;
    double rate;
    double time;
    int CompoundInterestRateTypePA;
    double totalCompoundInterestAmount;
    int compoundingFrequency;
    int rateTypeFrequencyYMWDHQBI;
//    double CompoundInterestAmountWithPrincipal;





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
//                    Frequency = yearly, rateTypeFrequencyYMWDHQBI = Yearly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 1)/1)/100),(time * 1))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                }

            } else if(rateTypeFrequencyYMWDHQBI == 1) {

                if (CompoundInterestRateTypePA == 0) {
//                    Frequency = yearly, rateTypeFrequencyYMWDHQBI = Monthly, rateTypePA = Percentage;
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + ((rate * 12)/1)/ 100), ( time * 1))));

                } else if (CompoundInterestRateTypePA == 1) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (time))));


                }

            } else if(rateTypeFrequencyYMWDHQBI == 2){

                    if(CompoundInterestRateTypePA == 0){
//                    Frequency = yearly, rateTypeFrequencyYMWDHQBI = Weekly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 52)/1)/100),(time * 1))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                    }


                } else if(rateTypeFrequencyYMWDHQBI == 3){

                    if(CompoundInterestRateTypePA == 0){

//                    Frequency = yearly, rateTypeFrequencyYMWDHQBI = Daily, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 365)/1)/100),(time * 1))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 4){

                    if(CompoundInterestRateTypePA == 0){
//                    Frequency = yearly, rateTypeFrequencyYMWDHQBI = half_yearly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 2)/1)/100),( time * 1))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 5){

                    if(CompoundInterestRateTypePA == 0){
//                    Frequency = yearly, rateTypeFrequencyYMWDHQBI = Quarterly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 4)/1)/100),( time * 1))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 6){

                    if(CompoundInterestRateTypePA == 0){

//                    Frequency = yearly, rateTypeFrequencyYMWDHQBI = BI annually, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 0.5)/1)/100),(time * 1))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(time))));
                    }
                }

            } else if(compoundingFrequency == 1){

            if(rateTypeFrequencyYMWDHQBI == 0){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Monthly, rateTypeFrequencyYMWDHQBI = Yearly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 1 )/12)/100),( time * 12))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 1) {

                if (CompoundInterestRateTypePA == 0) {
//                    Frequency = Monthly, rateTypeFrequencyYMWDHQBI = Monthly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 12 )/12)/100),( time * 12))));

                } else if (CompoundInterestRateTypePA == 1) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (1 * time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 2){

                    if(CompoundInterestRateTypePA == 0){
//                        Frequency = Monthly, rateTypeFrequencyYMWDHQBI = Weekly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 52 )/12)/100),( time * 12))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 3){

                    if(CompoundInterestRateTypePA == 0){
//                        Frequency = Monthly, rateTypeFrequencyYMWDHQBI = daily, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 365 )/12)/100),( time * 12))));


                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 4){

                    if(CompoundInterestRateTypePA == 0){
//                        Frequency = Monthly, rateTypeFrequencyYMWDHQBI = Half_Yearly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 2 )/12)/100),( time * 12))));


                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 5){

                    if(CompoundInterestRateTypePA == 0){
//                        Frequency = Monthly, rateTypeFrequencyYMWDHQBI = quarterly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 4 )/12)/100),( time * 12))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 6){

                    if(CompoundInterestRateTypePA == 0){
//                        Frequency = Monthly, rateTypeFrequencyYMWDHQBI = Bi_annually, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 0.5 )/12)/100),( time * 12))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                }
            } else if(compoundingFrequency == 2){

            if(rateTypeFrequencyYMWDHQBI == 0){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Weekly, rateTypeFrequencyYMWDHQBI = Yearly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 1 )/52)/100),( time * 52))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 1) {

                if (CompoundInterestRateTypePA == 0) {
//                    Frequency = Weekly, rateTypeFrequencyYMWDHQBI = Monthly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 12 )/52)/100),( time * 52))));


                } else if (CompoundInterestRateTypePA == 1) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (1 * time))));
                }
            }else if(rateTypeFrequencyYMWDHQBI == 2){

                    if(CompoundInterestRateTypePA == 0){
//                    Frequency = Weekly, rateTypeFrequencyYMWDHQBI = Weekly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 52 )/52)/100),( time * 52))));


                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 3){

                    if(CompoundInterestRateTypePA == 0){

                        // Frequency = Weekly, rateTypeFrequencyYMWDHQBI = Daily, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 365 )/52)/100),( time * 52))));


                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 4){

                    if(CompoundInterestRateTypePA == 0){
//                    Frequency = Weekly, rateTypeFrequencyYMWDHQBI = Half_yearly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 2 )/52)/100),( time * 52))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 5){

                    if(CompoundInterestRateTypePA == 0){
//                    Frequency = Weekly, rateTypeFrequencyYMWDHQBI = Quarterly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 4 )/52)/100),( time * 52))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 6){

                    if(CompoundInterestRateTypePA == 0){
//                    Frequency = Weekly, rateTypeFrequencyYMWDHQBI = Bi_annually, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 0.5 )/52)/100),( time * 52))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                }
            } else if(compoundingFrequency == 3){


            if(rateTypeFrequencyYMWDHQBI == 0){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Daily, rateTypeFrequencyYMWDHQBI = Yearly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 1 )/365)/100),( time * 365))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 1) {

                if (CompoundInterestRateTypePA == 0) {
//                    Frequency = Daily, rateTypeFrequencyYMWDHQBI = Monthly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 12 )/365)/100),( time * 365))));

                } else if (CompoundInterestRateTypePA == 1) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (1 * time))));
                }
            }else if(rateTypeFrequencyYMWDHQBI == 2){

                    if(CompoundInterestRateTypePA == 0){
//                        Frequency = Daily, rateTypeFrequencyYMWDHQBI = Weekly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 52 )/365)/100),( time * 365))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 3){

                    if(CompoundInterestRateTypePA == 0){
//                        Frequency = Daily, rateTypeFrequencyYMWDHQBI = Daily, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 365 )/365)/100),( time * 365))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 4){

                    if(CompoundInterestRateTypePA == 0){
//                        Frequency = Daily, rateTypeFrequencyYMWDHQBI = Half_Yearly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 2 )/365)/100),( time * 365))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 5){

                    if(CompoundInterestRateTypePA == 0){
//                        Frequency = Daily, rateTypeFrequencyYMWDHQBI = Quarterly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 4 )/365)/100),( time * 365))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 6){

                    if(CompoundInterestRateTypePA == 0){
//                        Frequency = Daily, rateTypeFrequencyYMWDHQBI = BI-annually, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 0.5 )/365)/100),( time * 365))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                }
            } else if(compoundingFrequency == 4){


            if(rateTypeFrequencyYMWDHQBI == 0){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Half_yearly, rateTypeFrequencyYMWDHQBI = Yearly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 1 )/2)/100),( time * 2))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 1) {

                if (CompoundInterestRateTypePA == 0) {
//                    Frequency = Half_yearly, rateTypeFrequencyYMWDHQBI = Monthly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 12 )/2)/100),( time * 2))));

                } else if (CompoundInterestRateTypePA == 1) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (1 * time))));
                }
            }else if(rateTypeFrequencyYMWDHQBI == 2){

                    if(CompoundInterestRateTypePA == 0){
//                    Frequency = Half_yearly, rateTypeFrequencyYMWDHQBI = Weekly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 52 )/2)/100),( time * 2))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 3){

                    if(CompoundInterestRateTypePA == 0){
//                    Frequency = Half_yearly, rateTypeFrequencyYMWDHQBI = Daily, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 365 )/2)/100),( time * 2))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 4){

                    if(CompoundInterestRateTypePA == 0){
//                    Frequency = Half_yearly, rateTypeFrequencyYMWDHQBI = Half_Yearly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 2 )/2)/100),( time * 2))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 5){

                    if(CompoundInterestRateTypePA == 0){
//                    Frequency = Half_yearly, rateTypeFrequencyYMWDHQBI = Quarterly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 4 )/2)/100),( time * 2))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 6){

                    if(CompoundInterestRateTypePA == 0){
//                    Frequency = Half_yearly, rateTypeFrequencyYMWDHQBI = Bi_annually, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 0.5 )/2)/100),( time * 2))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                }
            } else if(compoundingFrequency == 5){


            if(rateTypeFrequencyYMWDHQBI == 0){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Quarterly, rateTypeFrequencyYMWDHQBI = Yearly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 1 )/4)/100),( time * 4))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 1) {

                if (CompoundInterestRateTypePA == 0) {
//                    Frequency = Quarterly, rateTypeFrequencyYMWDHQBI = Monthly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 12 )/4)/100),( time * 4))));

                } else if (CompoundInterestRateTypePA == 1) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (1 * time))));
                }
            }else if(rateTypeFrequencyYMWDHQBI == 2){

                    if(CompoundInterestRateTypePA == 0){
//                    Frequency = Quarterly, rateTypeFrequencyYMWDHQBI = Weekly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 52 )/4)/100),( time * 4))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 3){

                    if(CompoundInterestRateTypePA == 0){
//                    Frequency = Quarterly, rateTypeFrequencyYMWDHQBI = Daily, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 365 )/4)/100),( time * 4))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 4){

                    if(CompoundInterestRateTypePA == 0){
//                    Frequency = Quarterly, rateTypeFrequencyYMWDHQBI = Half_Yearly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 2 )/4)/100),( time * 4))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 5){

                    if(CompoundInterestRateTypePA == 0){
//                    Frequency = Quarterly, rateTypeFrequencyYMWDHQBI = Quarterly, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 4 )/4)/100),( time * 4))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                } else if(rateTypeFrequencyYMWDHQBI == 6){

                    if(CompoundInterestRateTypePA == 0){

                        // Frequency = Quarterly, rateTypeFrequencyYMWDHQBI = Bi_annually, rateTypePA = Percentage;
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 0.5 )/4)/100),( time * 4))));

                    } else if(CompoundInterestRateTypePA == 1){
                        totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(1 * time))));
                    }
                }
            } else if(compoundingFrequency == 6){

            if(rateTypeFrequencyYMWDHQBI == 0){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Daily(360), rateTypeFrequencyYMWDHQBI = Yearly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 1)/360)/100),(time * 360))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(time * 1))));
                }

            } else if(rateTypeFrequencyYMWDHQBI == 1) {

                if (CompoundInterestRateTypePA == 0) {
//                    Frequency = Daily(360), rateTypeFrequencyYMWDHQBI = Monthly, rateTypePA = Percentage;
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + ((rate * 12)/360)/ 100), ( time * 360))));

                } else if (CompoundInterestRateTypePA == 1) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (time))));


                }

            } else if(rateTypeFrequencyYMWDHQBI == 2){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Daily(360), rateTypeFrequencyYMWDHQBI = Weekly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 52)/360)/100),(time * 360))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                }


            } else if(rateTypeFrequencyYMWDHQBI == 3){

                if(CompoundInterestRateTypePA == 0){

//                    Frequency = Daily(360), rateTypeFrequencyYMWDHQBI = Daily, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 365)/360)/100),(time * 360))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 4){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Daily(360), rateTypeFrequencyYMWDHQBI = half_yearly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 2)/360)/100),( time * 360))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 5){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Daily(360), rateTypeFrequencyYMWDHQBI = Quarterly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 4)/360)/100),( time * 360))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 6){

                if(CompoundInterestRateTypePA == 0){

//                    Frequency = Daily(360), rateTypeFrequencyYMWDHQBI = BI annually, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 0.5)/360)/100),(time * 360))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(time))));
                }
            }

        }else if(compoundingFrequency == 7){

            if(rateTypeFrequencyYMWDHQBI == 0){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Bi-Weekly, rateTypeFrequencyYMWDHQBI = Yearly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 1)/26)/100),(time * 26))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(time * 1))));
                }

            } else if(rateTypeFrequencyYMWDHQBI == 1) {

                if (CompoundInterestRateTypePA == 0) {
//                    Frequency = Bi-Weekly, rateTypeFrequencyYMWDHQBI = Monthly, rateTypePA = Percentage;
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + ((rate * 12)/26)/ 100), ( time * 26))));

                } else if (CompoundInterestRateTypePA == 1) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (time))));


                }

            } else if(rateTypeFrequencyYMWDHQBI == 2){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Bi-Weekly, rateTypeFrequencyYMWDHQBI = Weekly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 52)/26)/100),(time * 26))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                }


            } else if(rateTypeFrequencyYMWDHQBI == 3){

                if(CompoundInterestRateTypePA == 0){

//                    Frequency = Bi-Weekly, rateTypeFrequencyYMWDHQBI = Daily, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 365)/26)/100),(time * 26))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 4){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Bi-Weekly, rateTypeFrequencyYMWDHQBI = half_yearly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 2)/26)/100),( time * 26))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 5){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Bi-Weekly, rateTypeFrequencyYMWDHQBI = Quarterly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 4)/26)/100),( time * 26))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 6){

                if(CompoundInterestRateTypePA == 0){

//                    Frequency = Bi-Weekly, rateTypeFrequencyYMWDHQBI = BI annually, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 0.5)/26)/100),(time * 26))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(time))));
                }
            }

        }else if(compoundingFrequency == 8){

            if(rateTypeFrequencyYMWDHQBI == 0){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Half-Monthly, rateTypeFrequencyYMWDHQBI = Yearly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 1)/24)/100),(time * 24))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(time * 1))));
                }

            } else if(rateTypeFrequencyYMWDHQBI == 1) {

                if (CompoundInterestRateTypePA == 0) {
//                    Frequency = Half-Monthly, rateTypeFrequencyYMWDHQBI = Monthly, rateTypePA = Percentage;
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + ((rate * 12)/24)/ 100), ( time * 24))));

                } else if (CompoundInterestRateTypePA == 1) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (time))));


                }

            } else if(rateTypeFrequencyYMWDHQBI == 2){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Half-Monthly, rateTypeFrequencyYMWDHQBI = Weekly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 52)/24)/100),(time * 24))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                }


            } else if(rateTypeFrequencyYMWDHQBI == 3){

                if(CompoundInterestRateTypePA == 0){

//                    Frequency = Half-Monthly, rateTypeFrequencyYMWDHQBI = Daily, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 365)/24)/100),(time * 24))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 4){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Half-Monthly, rateTypeFrequencyYMWDHQBI = half_yearly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 2)/24)/100),( time * 24))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 5){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Half-Monthly, rateTypeFrequencyYMWDHQBI = Quarterly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 4)/24)/100),( time * 24))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 6){

                if(CompoundInterestRateTypePA == 0){

//                    Frequency = Half-Monthly, rateTypeFrequencyYMWDHQBI = BI annually, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 0.5)/24)/100),(time * 24))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(time))));
                }
            }

        }else if(compoundingFrequency == 9){

            if(rateTypeFrequencyYMWDHQBI == 0){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Bi-Monthly, rateTypeFrequencyYMWDHQBI = Yearly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 1)/6)/100),(time * 6))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(time * 1))));
                }

            } else if(rateTypeFrequencyYMWDHQBI == 1) {

                if (CompoundInterestRateTypePA == 0) {
//                    Frequency = Bi-Monthly, rateTypeFrequencyYMWDHQBI = Monthly, rateTypePA = Percentage;
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + ((rate * 12)/6)/ 100), ( time * 6))));

                } else if (CompoundInterestRateTypePA == 1) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (time))));


                }

            } else if(rateTypeFrequencyYMWDHQBI == 2){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Bi-Monthly, rateTypeFrequencyYMWDHQBI = Weekly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 52)/6)/100),(time * 6))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                }


            } else if(rateTypeFrequencyYMWDHQBI == 3){

                if(CompoundInterestRateTypePA == 0){

//                    Frequency = Bi-Monthly, rateTypeFrequencyYMWDHQBI = Daily, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 365)/6)/100),(time * 6))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 4){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Bi-Monthly, rateTypeFrequencyYMWDHQBI = half_yearly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 2)/6)/100),( time * 6))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 5){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Bi-Monthly, rateTypeFrequencyYMWDHQBI = Quarterly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 4)/6)/100),( time * 6))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 6){

                if(CompoundInterestRateTypePA == 0){

//                    Frequency = Bi-Monthly, rateTypeFrequencyYMWDHQBI = BI annually, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 0.5)/6)/100),(time * 6))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(time))));
                }
            }

        }else if(compoundingFrequency == 10){

            if(rateTypeFrequencyYMWDHQBI == 0){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Bi-Annually, rateTypeFrequencyYMWDHQBI = Yearly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 1)/0.5)/100),(time * 0.5))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(time * 1))));
                }

            } else if(rateTypeFrequencyYMWDHQBI == 1) {

                if (CompoundInterestRateTypePA == 0) {
//                    Frequency = Bi-Annually, rateTypeFrequencyYMWDHQBI = Monthly, rateTypePA = Percentage;
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + ((rate * 12)/0.5)/ 100), ( time * 0.5))));

                } else if (CompoundInterestRateTypePA == 1) {
                    totalCompoundInterestAmount = (principal * (Math.pow((1 + rate / 100), (time))));


                }

            } else if(rateTypeFrequencyYMWDHQBI == 2){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Bi-Annually, rateTypeFrequencyYMWDHQBI = Weekly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 52)/0.5)/100),(time * 0.5))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                }


            } else if(rateTypeFrequencyYMWDHQBI == 3){

                if(CompoundInterestRateTypePA == 0){

//                    Frequency = Bi-Annually, rateTypeFrequencyYMWDHQBI = Daily, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 365)/0.5)/100),(time * 0.5))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 4){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Bi-Annually, rateTypeFrequencyYMWDHQBI = half_yearly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 2)/0.5)/100),( time * 0.5))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 5){

                if(CompoundInterestRateTypePA == 0){
//                    Frequency = Bi-Annually, rateTypeFrequencyYMWDHQBI = Quarterly, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 4)/0.5)/100),( time * 0.5))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),( time))));
                }
            } else if(rateTypeFrequencyYMWDHQBI == 6){

                if(CompoundInterestRateTypePA == 0){

//                    Frequency = Bi-Annually, rateTypeFrequencyYMWDHQBI = BI-Annually, rateTypePA = Percentage;
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + ((rate * 0.5)/0.5)/100),(time * 0.5))));

                } else if(CompoundInterestRateTypePA == 1){
                    totalCompoundInterestAmount =    (principal * (Math.pow((1 + rate/100),(time))));
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