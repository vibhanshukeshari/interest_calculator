package com.calculator.interestcalculator;

import androidx.constraintlayout.motion.widget.FloatLayout;

import java.text.NumberFormat;
import java.util.Locale;


public class NumberFormatterWithSymbol {

    Locale locale;
    NumberFormat numberFormat;
    String countryName;
    String numberAfterFormat;
    double number;

    public String getNumberAfterFormat() {

        if(countryName.equals("India")){
            locale = new Locale("(hi", "IN");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);



            numberAfterFormat = numberFormat.format(number);
            numberAfterFormat = numberFormat.format(number).replace("₹",  "₹" + " ");

        } else if(countryName.equals("Afghanistan")){
            locale = new Locale("en", "AF");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("AFN",  "؋" + " ");


        } else if(countryName.equals("Åland Islands")){
            locale = new Locale("sv","AX");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number)/*.replace("","", + " ")*/;
        }








        return numberAfterFormat;
    }

    public void setNumberAfterFormat(String numberAfterFormat) {
        this.numberAfterFormat = numberAfterFormat;
    }


    public double getNumber() {

        return number;
    }

    public void setNumber(double number) {





        this.number = number;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
