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
            locale = new Locale("ar","DZ");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

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

        } else if(countryName.equals("Antigua and Barbuda")){
            locale = new Locale("en","AG");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Argentina")){
            locale = new Locale("es","AR");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Armenia")){
            locale = new Locale("hy","AM");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Australia")){
            locale = new Locale("en","AU");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Australia")){
            locale = new Locale("en","AU");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Austria")){
            locale = new Locale("de","AT");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Azerbaijan")){
            locale = new Locale("az","AZ");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Bahamas")){
            locale = new Locale("en","BS");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Bahrain")){
            locale = new Locale("en","BH");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("BHD",".د.ب ");

        } else if(countryName.equals("Bangladesh")){
            locale = new Locale("en","BD");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("BDT","৳ ");

        } else if(countryName.equals("Barbados")){
            locale = new Locale("en","BB");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Belarus")){
            locale = new Locale("be","BY");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Belgium")){
            locale = new Locale("nl","BE");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Belize")){
            locale = new Locale("en","BZ");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Benin")){
            locale = new Locale("fr","BJ");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Bhutan")){
            locale = new Locale("en","BT");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("BTN","Nu. ");

        } else if(countryName.equals("Bolivia, Plurinational State Of")){
            locale = new Locale("es","BO");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("Bs","Bs ");

        } else if(countryName.equals("Bosnia And Herzegovina")){
            locale = new Locale("hr","BA");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Botswana")){
            locale = new Locale("en","BW");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("P","P ");

        } else if(countryName.equals("Brazil")){
            locale = new Locale("pt","BR");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Brunei Darussalam")){
            locale = new Locale("ms","BN");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Bulgaria")){
            locale = new Locale("bg","BG");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Bulgaria")){
            locale = new Locale("bg","BG");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Burkina Faso")){
            locale = new Locale("fr","BF");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Burundi")){
            locale = new Locale("rn","BI");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("FBu"," FBu");

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
