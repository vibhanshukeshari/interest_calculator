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
            locale = new Locale("hi", "IN");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("₹",  "₹" + " ");

        } else if(countryName.equals("Afghanistan")){
            locale = new Locale("en", "AF");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("AFN",  "؋" + " ");


        }  else if(countryName.equals("Albania")){
            locale = new Locale("sq","AL");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("Lekë",  "L" + " ");

        } else if(countryName.equals("Algeria")){
            locale = new Locale("en","DZ");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("DZD",  "دج" + " ");

        }  else if(countryName.equals("Andorra")){
            locale = new Locale("ca","AD");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Angola")){
            locale = new Locale("pt","AO");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

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
