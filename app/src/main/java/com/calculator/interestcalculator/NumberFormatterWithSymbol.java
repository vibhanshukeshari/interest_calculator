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

            numberAfterFormat = numberFormat.format(number).replace("AFN",  "؋ ");


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

            numberAfterFormat = numberFormat.format(number).replace("د.ج.", "DZD");
            System.out.println(numberAfterFormat);

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

            numberAfterFormat = numberFormat.format(number).replace("BHD","BD ");

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

        } else if(countryName.equals("Indonesia")){
            locale = new Locale("id","ID");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("Rp","Rp ");

        } else if(countryName.equals("Iran, Islamic Republic Of")){
            locale = new Locale("en","IR");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("IRR","IRR ");

        } else if(countryName.equals("Iraq")){
            locale = new Locale("en","IQ");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("IQD","IQD ");

        } else if(countryName.equals("Ireland")){
            locale = new Locale("ga","IE");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("€","€ ");

        } else if(countryName.equals("Israel")){
            locale = new Locale("he","IL");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Italy")){
            locale = new Locale("it","IT");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Jamaica")){
            locale = new Locale("en","JM");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Japan")){
            locale = new Locale("ja","JP");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Jordan")){
            locale = new Locale("en","JO");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("JOD","JOD ");

        } else if(countryName.equals("Kazakhstan")){
            locale = new Locale("kk","KZ");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Kenya")){
            locale = new Locale("sw","KE");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Kiribati")){
            locale = new Locale("en","KI");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Kuwait")){
            locale = new Locale("en","KW");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("KWD","KD ");

        } else if(countryName.equals("Kyrgyzstan")){
            locale = new Locale("ky","KG");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Lao People's Democratic Republic")){
            locale = new Locale("lo","LA");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("₭","₭ ");

        } else if(countryName.equals("Latvia")){
            locale = new Locale("lv","LV");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Lebanon")){
            locale = new Locale("en","LB");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("LBP","LBP ");

        } else if(countryName.equals("Lesotho")){
            locale = new Locale("en","LS");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("R","R ");

        } else if(countryName.equals("Liberia")){
            locale = new Locale("en","LR");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Libya")){
            locale = new Locale("ar","LY");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("د.ل.","LD");
            System.out.println(numberAfterFormat);

        } else if(countryName.equals("Liechtenstein")){
            locale = new Locale("de","LI");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Lithuania")){
            locale = new Locale("lt","LT");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Luxembourg")){
            locale = new Locale("lb","LU");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Macedonia (FYROM)")){
            locale = new Locale("mk","MK");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Madagascar")){
            locale = new Locale("mg","MG");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Malawi")){
            locale = new Locale("en","MW");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("MK","MK ");

        } else if(countryName.equals("Malaysia")){
            locale = new Locale("ms","MY");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("RM","RM ");

        } else if(countryName.equals("Maldives")){
            locale = new Locale("dv","MV");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("MVR","MVR ");

        } else if(countryName.equals("Mali")){
            locale = new Locale("fr","ML");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Malta")){
            locale = new Locale("mt","MT");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("€","€ ");

        } else if(countryName.equals("Marshall Islands")){
            locale = new Locale("en","MH");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Mauritania")){
            locale = new Locale("en","MR");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("MRU","UM ");

        } else if(countryName.equals("Mauritius")){
            locale = new Locale("en","MU");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("Rs","Rs ");

        } else if(countryName.equals("Mexico")){
            locale = new Locale("es","MX");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Micronesia, Federated States Of")){
            locale = new Locale("en","FM");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("US$","US$ ");

        } else if(countryName.equals("Moldova, Republic Of")){
            locale = new Locale("ro","MD");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Monaco")){
            locale = new Locale("fr","MC");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Mongolia")){
            locale = new Locale("mn","MN");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Montenegro")){
            locale = new Locale("sr","ME");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Morocco")){
            locale = new Locale("ar","MA");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("د.م.","MAD ");

        } else if(countryName.equals("Mozambique")){
            locale = new Locale("pt","MZ");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Myanmar")){
            locale = new Locale("en","MM");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("MMK","K ");

        } else if(countryName.equals("Namibia")){
            locale = new Locale("en","NA");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Nauru")){
            locale = new Locale("en","NR");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Nepal")){
            locale = new Locale("en","NP");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("NPR","NPR ");

        } else if(countryName.equals("Netherlands")){
            locale = new Locale("nl","NL");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("New Zealand")){
            locale = new Locale("en","NZ");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        } else if(countryName.equals("Nicaragua")){
            locale = new Locale("es","NI");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("C$","C$ ");

        } else if(countryName.equals("Niger")){
            locale = new Locale("fr","NE");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Nigeria")){
            locale = new Locale("en","NG");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("₦","₦ ");

        } else if(countryName.equals("North Korea")){
            locale = new Locale("ko","KP");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("KPW","₩ ");

        } else if(countryName.equals("Norway")){
            locale = new Locale("no","NO");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        } else if(countryName.equals("Oman")){
            locale = new Locale("en","OM");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("OMR","OMR ");

        } else if(countryName.equals("Pakistan")){
            locale = new Locale("en","PK");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("Rs","Rs ");

        } else if(countryName.equals("Palau")){
            locale = new Locale("en","PW");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("US$","US$ ");

        } else if(countryName.equals("Palestine")){
            locale = new Locale("en","PS");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("₪","₪ ");

        } else if(countryName.equals("Panama")){
            locale = new Locale("es","PA");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("B/.","B/. ");

        } else if(countryName.equals("Papua New Guinea")){
            locale = new Locale("en","PG");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("K","K ");

        }else if(countryName.equals("Paraguay")){
            locale = new Locale("es","PY");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("Gs.","₲");

        }else if(countryName.equals("Peru")){
            locale = new Locale("es","PE");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("S/","S/ ");

        }else if(countryName.equals("Philippines")){
            locale = new Locale("en","PH");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("₱","₱ ");

        }else if(countryName.equals("Poland")){
            locale = new Locale("pl","PL");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Portugal")){
            locale = new Locale("pt","PT");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Qatar")){
            locale = new Locale("en","QA");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("QAR","QR ");

        }else if(countryName.equals("Romania")){
            locale = new Locale("ro","RO");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Russian Federation")){
            locale = new Locale("ru","RU");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Rwanda")){
            locale = new Locale("rw","RW");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Saint Kitts and Nevis")){
            locale = new Locale("en","KN");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$", "$ ");

        }else if(countryName.equals("Saint Lucia")){
            locale = new Locale("en","LC");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$", "$ ");

        }else if(countryName.equals("Saint Vincent & The Grenadines")){
            locale = new Locale("en","VC");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$", "$ ");

        }else if(countryName.equals("Samoa")){
            locale = new Locale("en","WS");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("WS$", "WS$ ");

        }else if(countryName.equals("San Marino")){
            locale = new Locale("it","SM");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Sao Tome And Principe")){
            locale = new Locale("pt","ST");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Saudi Arabia")){
            locale = new Locale("en","SA");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("SAR","SR ");

        }else if(countryName.equals("Senegal")){
//            wo also supports wolof language grouping separator is . but in fr it is space
            locale = new Locale("fr","SN");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Serbia")){
            locale = new Locale("sr","RS");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Seychelles")){
            locale = new Locale("fr","SC");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Sierra Leone")){
            locale = new Locale("en","SL");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("Le","Le ");

        }else if(countryName.equals("Singapore")){
            locale = new Locale("en","SG");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        }else if(countryName.equals("Slovakia")){
            locale = new Locale("sk","SK");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Slovenia")){
            locale = new Locale("sl","SL");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Solomon Islands")){
            locale = new Locale("en","SB");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        }else if(countryName.equals("Somalia")){
            locale = new Locale("so","SO");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("S ","S ");

        }else if(countryName.equals("South Africa")){
            locale = new Locale("en","ZA");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("R","R ");

        }else if(countryName.equals("South Korea")){
            locale = new Locale("ko","KR");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("₩","₩ ");

        }else if(countryName.equals("South Sudan")){
            locale = new Locale("en","SS");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("£","£ ");

        }else if(countryName.equals("Spain")){
            locale = new Locale("es","ES");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Sri Lanka")){
            // si also supports
            locale = new Locale("ta","LK");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Sudan")){
            locale = new Locale("en","SD");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("SDG","SDG ");

        }else if(countryName.equals("Suriname")){
            locale = new Locale("nl","SR");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Swaziland")){
            locale = new Locale("en","SZ");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("E","E ");

        }else if(countryName.equals("Sweden")){
            locale = new Locale("sv","SE");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Switzerland")){
            locale = new Locale("de","CH");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Syrian Arab Republic")){
            locale = new Locale("en","SY");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("SYP","£S ");

        }else if(countryName.equals("Tajikistan")){
            locale = new Locale("tg","TJ");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Tanzania, United Republic Of")){
            locale = new Locale("sw","TZ");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Thailand")){
            locale = new Locale("th","TH");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("฿","฿ ");

        }else if(countryName.equals("Timor-leste")){
            locale = new Locale("pt","TL");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Togo")){
            locale = new Locale("fr","TG");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Tonga")){
            // en also
            locale = new Locale("to","TO");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Trinidad & Tobago")){
            locale = new Locale("en","TT");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");

        }else if(countryName.equals("Tunisia")){
            locale = new Locale("en","TN");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("TND","DT ");

        }else if(countryName.equals("Turkey")){
            locale = new Locale("tr","TR");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("₺","₺ ");

        }else if(countryName.equals("Turkmenistan")){
            locale = new Locale("tk","TM");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Tuvalu")){
            locale = new Locale("bi","TV");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("A$","$ ");

        }else if(countryName.equals("Uganda")){
            locale = new Locale("lg","UG");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("USh"," USh");

        }else if(countryName.equals("Ukraine")){
            locale = new Locale("uk","UA");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("грн.","₴");

        }else if(countryName.equals("United Arab Emirates (UAE)")){
            locale = new Locale("en","AE");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("AED","AED ");

        }else if(countryName.equals("United Kingdom")){
            locale = new Locale("en","GB");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("£","£ ");

        }else if(countryName.equals("Uruguay")){
            locale = new Locale("es","UY");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Uzbekistan")){
            locale = new Locale("uz","UZ");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Vanuatu")){
            locale = new Locale("en","VU");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("VT","VT ");

        }else if(countryName.equals("Venezuela, Bolivarian Republic Of")){
            locale = new Locale("es","VE");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("Bs.S","Bs. ");

        }else if(countryName.equals("Vietnam")){
            locale = new Locale("vi","VN");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number);

        }else if(countryName.equals("Yemen")){
            locale = new Locale("en","YE");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("YER","YER ");

        }else if(countryName.equals("Zambia")){
            locale = new Locale("en","ZM");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("K","K ");

        }else if(countryName.equals("Zimbabwe")){
            locale = new Locale("sn","ZW");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("US$","US$ ");

        } else {
            // it is used default for USA because string was not comparing "United States".
            locale = new Locale("en","US");

            numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setMinimumFractionDigits(2);

            numberAfterFormat = numberFormat.format(number).replace("$","$ ");



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
