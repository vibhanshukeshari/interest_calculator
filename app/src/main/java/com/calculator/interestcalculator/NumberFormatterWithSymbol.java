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

            numberAfterFormat = numberFormat.format(number).replace("₹",  "₹ ");

        } else if(countryName.equals("Afghanistan")){
            locale = new Locale("en", "AF");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("AFN",  " ؋");


        }  else if(countryName.equals("Albania")){
            locale = new Locale("sq","AL");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("Lekë",  "L ");

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

        } else if(countryName.equals("Cambodia")){
            locale = new Locale("km","KH");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("៛"," ៛");

        } else if(countryName.equals("Cameroon")){
            locale = new Locale("fr","CM");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Canada")){
            locale = new Locale("en","CA");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Cape Verde")){
//            "kea" also // it has some confusion with it's symbol
            locale = new Locale("pt","CV");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace(",","$");

        } else if(countryName.equals("Central African Republic")){
            // language"sg" sango also spoken in CF
            locale = new Locale("fr","CF");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Chad")){
            locale = new Locale("fr","TD");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Chile")){
            locale = new Locale("es","CL");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("China")){
            locale = new Locale("zh","CN");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Colombia")){
            locale = new Locale("es","CO");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Comoros")){
            locale = new Locale("fr","KM");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Congo")){
            locale = new Locale("fr","CG");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Congo, The Democratic Republic Of The")){
            locale = new Locale("fr","CD");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Costa Rica")){
            locale = new Locale("es","CR");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("₡","₡ ");

        } else if(countryName.equals("Côte D'ivoire")){
            locale = new Locale("fr","CI");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Croatia")){
            locale = new Locale("hr","HR");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("HRK","Kn");

        } else if(countryName.equals("Cuba")){
            locale = new Locale("es","CU");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Cyprus")){
//            language turkish "tr" also support
            locale = new Locale("el","CY");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Czech Republic")){
            locale = new Locale("cs","CZ");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Denmark")){
            locale = new Locale("da","DK");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Djibouti")){
            // Djibouti uses somali and arabic as most spoken language somali language code is "so"
            // but "so" has period as decimal seprator  but "so" is not a official language and "fr"
            // is a a official language of Djibouti that is why we have used "fr".
            locale = new Locale("fr","DJ");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Dominica")){
            locale = new Locale("en","DM");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Dominican Republic")){
            locale = new Locale("es","DO");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("RD$","RD$ ");

        } else if(countryName.equals("Ecuador")){
            locale = new Locale("es","EC");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Egypt")){
            locale = new Locale("en","EG");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("EGP"," E£ ");

        } else if(countryName.equals("El Salvador")){
            locale = new Locale("es","SV");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Equatorial Guinea")){
            locale = new Locale("es","GQ");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("FCFA","FCFA ");

        } else if(countryName.equals("Eritrea")){
            locale = new Locale("ti","ER");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("Nfk","Nfk ");

        } else if(countryName.equals("Estonia")){
            locale = new Locale("et","EE");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Ethiopia")){
            locale = new Locale("am","ET");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("ብር","ብር ");

        } else if(countryName.equals("Fiji")){
            locale = new Locale("en","FJ");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Finland")){
            locale = new Locale("fi","FI");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("France")){
            locale = new Locale("fr","FR");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Gabon")){
            locale = new Locale("fr","GA");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Gambia")){
            locale = new Locale("en","GM");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("D", "D ");

        } else if(countryName.equals("Georgia")){
            locale = new Locale("ka","GE");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Germany")){
            locale = new Locale("de","DE");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Ghana")){
            //language("ak") also akan supports
            locale = new Locale("en","GH");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("GH₵","GH₵ ");

        } else if(countryName.equals("Greece")){
            //language("ak") also akan supports
            locale = new Locale("el","GR");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Grenada")){
            locale = new Locale("en","GD");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Guatemala")){
            locale = new Locale("es","GT");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("Q","Q ");

        } else if(countryName.equals("Guinea")){
            locale = new Locale("fr","GN");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Guinea-bissau")){
            locale = new Locale("pt","GW");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Guyana")){
            locale = new Locale("en","GY");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Haiti")){
            locale = new Locale("fr","HT");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Holy See (vatican City State)")){
            locale = new Locale("it","VA");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Honduras")){
            locale = new Locale("es","HN");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("L","L ");

        } else if(countryName.equals("Hungary")){
            locale = new Locale("hu","HU");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Iceland")){
            locale = new Locale("is","IS");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("ISK","Kr");

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
