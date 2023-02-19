package com.calculator.interestcalculator;

import android.widget.Toast;

public class CountryNameToSymbol{

    String mYcountryName;
    String mYcountryCurrency;
    String mYcountrySymbol;
    Boolean mCommaOrPeriod;




    // this feature is currently not supported, in future i will think about adding it;
    public String getmYcountryCurrency() {

        if(mYcountryName.equals("India")){
            mYcountryCurrency = "Indian Rupee";
        }else if(mYcountryName.equals("")){
            mYcountryCurrency = "Afghan Afghani";
        }else if(mYcountryName.equals("Åland Islands")){
            mYcountryCurrency = "Euro";
        }else if(mYcountryName.equals("Albania")){
            mYcountryCurrency = "Albanian Lek";
        }else if(mYcountryName.equals("Algeria")){
            mYcountryCurrency = "Algerian Dinar";
        }else if(mYcountryName.equals("American Samoa")){
            mYcountryCurrency = "US";
        }else if(mYcountryName.equals("Andorra")){
            mYcountryCurrency = "Euro";
        }else if(mYcountryName.equals("Angola")){
            mYcountryCurrency = "Angolan Kwanza";
        }else if(mYcountryName.equals("Anguilla")){
            mYcountryCurrency = "EC";
        }else if(mYcountryName.equals("Antarctica")){
            mYcountryCurrency = "Antarctican Dollar";
        }else if(mYcountryName.equals("Antigua and Barbuda")){
            mYcountryCurrency = "EC";
        }else if(mYcountryName.equals("Argentina")){
            mYcountryCurrency = "Argentine Peso";
        }else if(mYcountryName.equals("Armenia")){
            mYcountryCurrency = "Armenian Dram";
        }else if(mYcountryName.equals("Aruba")){
            mYcountryCurrency = "Aruban Florin";
        }else if(mYcountryName.equals("Australia")){
            mYcountryCurrency = "Australian Dollar";
        }else if(mYcountryName.equals("Austria")){
            mYcountryCurrency = "Euro";
        }


        return mYcountryCurrency;
    }










































    public String getmYcountrySymbol() {
        switch (mYcountryName) {
            case "India":
                mYcountrySymbol = "₹";
                break;
            case "Afghanistan":
                mYcountrySymbol = "؋";

                break;
            case "Albania":
                mYcountrySymbol = "L";

                break;
            case "Algeria":
                mYcountrySymbol = "دج";

                break;
            case "Andorra":
                mYcountrySymbol = "€";

                break;
            case "Angola":
                mYcountrySymbol = "Kz";

                break;
            case "Antigua and Barbuda":
                mYcountrySymbol = "$";

                break;
            case "Argentina":
                mYcountrySymbol = "$";

                break;
            case "Armenia":
                mYcountrySymbol = "֏";

                break;

            case "Australia":
                mYcountrySymbol = "$";

                break;
            case "Austria":
                mYcountrySymbol = "€";

                break;
            case "Azerbaijan":
                mYcountrySymbol = "₼";

                break;
            case "Bahamas":
                mYcountrySymbol = "$";

                break;
            case "Bahrain":
                mYcountrySymbol = ".د.ب";

                break;
            case "Bangladesh":
                mYcountrySymbol = "৳";

                break;
            case "Barbados":
                mYcountrySymbol = "$";

                break;
            case "Belarus":
                mYcountrySymbol = "Br";

                break;
            case "Belgium":
                mYcountrySymbol = "€";

                break;
            case "Belize":
                mYcountrySymbol = "$";

                break;
            case "Benin":
                mYcountrySymbol = "CFA";

                break;
            case "Bhutan":
                mYcountrySymbol = "Nu.";

                break;
            case "Bolivia, Plurinational State Of":
                mYcountrySymbol = "Bs";

                break;
            case "Bosnia And Herzegovina":
                mYcountrySymbol = "KM";

                break;
            case "Botswana":
                mYcountrySymbol = "P";
                break;
            case "Brazil":
                mYcountrySymbol = "R$";

                break;
            case "Brunei Darussalam":
                mYcountrySymbol = "$";

                break;
            case "Bulgaria":
                mYcountrySymbol = "Лв.";

                break;
            case "Burkina Faso":
                mYcountrySymbol = "CFA";

                break;
            case "Burundi":
                mYcountrySymbol = "FBu";

                break;
            case "Cambodia":
                mYcountrySymbol = "៛";

                break;
            case "Cameroon":
                mYcountrySymbol = "FCFA";

                break;
            case "Canada":
                mYcountrySymbol = "$";

                break;

                // There is a confusion with cape verde because it uses $ as decimal separator ex. 20$00 means 20 escudos.
            case "Cape Verde":
                mYcountrySymbol = "CVE";
                break;
            case "Central African Republic":
                mYcountrySymbol = "FCFA";

                break;
            case "Chad":
                mYcountrySymbol = "FCFA";

                break;
            case "Chile":
                mYcountrySymbol = "$";

                break;
            case "China":
                mYcountrySymbol = "¥";

                break;
            case "Colombia":
                mYcountrySymbol = "$";

                break;
            case "Comoros":
                mYcountrySymbol = "CF";

                break;
            case "Congo":
                mYcountrySymbol = "FCFA";

                break;
            case "Congo, The Democratic Republic Of The":
                mYcountrySymbol = "FC";

                break;
            case "Costa Rica":
                mYcountrySymbol = "₡";

                break;
            case "Côte D'ivoire":
                mYcountrySymbol = "CFA";

                break;
            case "Croatia":
                mYcountrySymbol = "kn";

                break;
            case "Cuba":
                mYcountrySymbol = "$";

                break;
            case "Cyprus":
                mYcountrySymbol = "€";

                break;
            case "Czech Republic":
                mYcountrySymbol = "Kč";

                break;
            case "Denmark":
                mYcountrySymbol = "Kr.";

                break;
            case "Djibouti":
                mYcountrySymbol = "Fdj";

                break;
            case "Dominica":
                mYcountrySymbol = "$";

                break;
            case "Dominican Republic":
                mYcountrySymbol = "RD$";

                break;
            case "Ecuador":
                mYcountrySymbol = "$";

                break;
            case "Egypt":
                mYcountrySymbol = "E£";

                break;
            case "El Salvador":
                mYcountrySymbol = "$";

                break;
            case "Equatorial Guinea":
                mYcountrySymbol = "FCFA";

                break;
            case "Eritrea":
                mYcountrySymbol = "Nfk";

                break;
            case "Estonia":
                mYcountrySymbol = "€";

                break;
            case "Ethiopia":
                mYcountrySymbol = "ብር";

                break;
            case "Fiji":
                mYcountrySymbol = "$";

                break;
            case "Finland":
                mYcountrySymbol = "€";

                break;
            case "France":
                mYcountrySymbol = "€";

                break;
            case "Gabon":
                mYcountrySymbol = "FCFA";

                break;
            case "Gambia":
                mYcountrySymbol = "D";

                break;
            case "Georgia":
                mYcountrySymbol = "₾";

                break;
            case "Germany":
                mYcountrySymbol = "€";

                break;
            case "Ghana":
                mYcountrySymbol = "GH₵";

                break;
            case "Greece":
                mYcountrySymbol = "€";

                break;
            case "Grenada":
                mYcountrySymbol = "$";

                break;
            case "Guatemala":
                mYcountrySymbol = "Q";

                break;
            case "Guinea":
                mYcountrySymbol = "FG";

                break;
            case "Guinea-bissau":
                mYcountrySymbol = "CFA";

                break;
            case "Guyana":
                mYcountrySymbol = "$";

                break;
            case "Haiti":
                mYcountrySymbol = "G";

                break;
            case "Holy See (vatican City State)":
                mYcountrySymbol = "€";

                break;
            case "Honduras":
                mYcountrySymbol = "L";

                break;
            case "Hungary":
                mYcountrySymbol = "Ft";

                break;
            case "Iceland":
                mYcountrySymbol = "kr";

                break;
            case "Indonesia":
                mYcountrySymbol = "";

                break;
            case "Iran, Islamic Republic Of":
                mYcountrySymbol = "";

                break;
            case "Iraq":
                mYcountrySymbol = "";

                break;
            case "Ireland":
                mYcountrySymbol = "";

                break;
            case "Israel":
                mYcountrySymbol = "";

                break;
            case "Italy":
                mYcountrySymbol = "";

                break;
            case "Jamaica":
                mYcountrySymbol = "";

                break;
            case "Japan":
                mYcountrySymbol = "";

                break;
            case "Jordan":
                mYcountrySymbol = "";

                break;
            case "Kazakhstan":
                mYcountrySymbol = "";

                break;
            case "Kenya":
                mYcountrySymbol = "";

                break;
            case "Kiribati":
                mYcountrySymbol = "";

                break;
            case "Kuwait":
                mYcountrySymbol = "";

                break;
            case "Kyrgyzstan":
                mYcountrySymbol = "";

                break;
            case "Lao People's Democratic Republic":
                mYcountrySymbol = "";

                break;
            case "Latvia":
                mYcountrySymbol = "";

                break;
            case "Lebanon":
                mYcountrySymbol = "";

                break;
            case "Lesotho":
                mYcountrySymbol = "";

                break;
            case "Liberia":
                mYcountrySymbol = "";

                break;
            case "Libya":
                mYcountrySymbol = "";

                break;
            case "Liechtenstein":
                mYcountrySymbol = "";

                break;
            case "Lithuania":
                mYcountrySymbol = "";

                break;
            case "Luxembourg":
                mYcountrySymbol = "";

                break;
            case "Macedonia (FYROM)":
                mYcountrySymbol = "";

                break;
            case "Madagascar":
                mYcountrySymbol = "";

                break;
            case "Malawi":
                mYcountrySymbol = "";

                break;
            case "Malaysia":
                mYcountrySymbol = "";

                break;
            case "Maldives":
                mYcountrySymbol = "";

                break;
            case "Mali":
                mYcountrySymbol = "";

                break;
            case "Malta":
                mYcountrySymbol = "";

                break;
            case "Marshall Islands":
                mYcountrySymbol = "";

                break;
            case "Mauritania":
                mYcountrySymbol = "";

                break;
            case "Mauritius":
                mYcountrySymbol = "";

                break;
            case "Mexico":
                mYcountrySymbol = "";

                break;
            case "Micronesia, Federated States Of":
                mYcountrySymbol = "";

                break;
            case "Moldova, Republic Of":
                mYcountrySymbol = "";

                break;
            case "Monaco":
                mYcountrySymbol = "";

                break;
            case "Mongolia":
                mYcountrySymbol = "";

                break;
            case "Montenegro":
                mYcountrySymbol = "";

                break;
            case "Morocco":
                mYcountrySymbol = "";

                break;
            case "Mozambique":
                mYcountrySymbol = "";

                break;
            case "Myanmar":
                mYcountrySymbol = "";

                break;
            case "Namibia":
                mYcountrySymbol = "";

                break;
            case "Nauru":
                mYcountrySymbol = "";

                break;
            case "Nepal":
                mYcountrySymbol = "";

                break;
            case "Netherlands":
                mYcountrySymbol = "";

                break;
            case "New Zealand":
                mYcountrySymbol = "";

                break;
            case "Nicaragua":
                mYcountrySymbol = "";

                break;
            case "Niger":
                mYcountrySymbol = "";

                break;
            case "Nigeria":
                mYcountrySymbol = "";

                break;
            case "North Korea":
                mYcountrySymbol = "";

                break;
            case "Norway":
                mYcountrySymbol = "";

                break;
            case "Oman":
                mYcountrySymbol = "";

                break;
            case "Pakistan":
                mYcountrySymbol = "";

                break;
            case "Palau":
                mYcountrySymbol = "";

                break;
            case "Palestine":
                mYcountrySymbol = "";

                break;
            case "Panama":
                mYcountrySymbol = "";

                break;
            case "Papua New Guinea":
                mYcountrySymbol = "";

                break;
            case "Paraguay":
                mYcountrySymbol = "";

                break;
            case "Peru":
                mYcountrySymbol = "";

                break;
            case "Philippines":
                mYcountrySymbol = "";

                break;
            case "Poland":
                mYcountrySymbol = "";

                break;
            case "Portugal":
                mYcountrySymbol = "";

                break;
            case "Qatar":
                mYcountrySymbol = "";

                break;
            case "Romania":
                mYcountrySymbol = "";

                break;
            case "Russian Federation":
                mYcountrySymbol = "";

                break;
            case "Rwanda":
                mYcountrySymbol = "";

                break;
            case "Saint Kitts and Nevis":
                mYcountrySymbol = "";

                break;
            case "Saint Lucia":
                mYcountrySymbol = "";

                break;
            case "Saint Vincent & The Grenadines":
                mYcountrySymbol = "";

                break;
            case "Samoa":
                mYcountrySymbol = "";

                break;
            case "San Marino":
                mYcountrySymbol = "";

                break;
            case "Sao Tome and Principe":
                mYcountrySymbol = "";

                break;
            case "Saudi Arabia":
                mYcountrySymbol = "";

                break;
            case "Senegal":
                mYcountrySymbol = "";

                break;
            case "Serbia":
                mYcountrySymbol = "";

                break;
            case "Seychelles":
                mYcountrySymbol = "";

                break;
            case "Sierra Leone":
                mYcountrySymbol = "";

                break;
            case "Singapore":
                mYcountrySymbol = "";

                break;
            case "Slovakia":
                mYcountrySymbol = "";

                break;
            case "Slovenia":
                mYcountrySymbol = "";

                break;
            case "Solomon Islands":
                mYcountrySymbol = "";

                break;
            case "Somalia":
                mYcountrySymbol = "";

                break;
            case "South Africa":
                mYcountrySymbol = "";

                break;
            case "South Korea":
                mYcountrySymbol = "";

                break;
            case "South Sudan":
                mYcountrySymbol = "";

                break;
            case "Spain":
                mYcountrySymbol = "";

                break;
            case "Sri Lanka":
                mYcountrySymbol = "";

                break;
            case "Sudan":
                mYcountrySymbol = "";

                break;
            case "Suriname":
                mYcountrySymbol = "";

                break;
            case "Swaziland":
                mYcountrySymbol = "";

                break;
            case "Sweden":
                mYcountrySymbol = "";

                break;
            case "Switzerland":
                mYcountrySymbol = "";

                break;
            case "Syrian Arab Republic":
                mYcountrySymbol = "";

                break;
            case "Tajikistan":
                mYcountrySymbol = "";

                break;
            case "Tanzania, United Republic Of":
                mYcountrySymbol = "";

                break;
            case "Thailand":
                mYcountrySymbol = "";

                break;
            case "Timor-leste":
                mYcountrySymbol = "";

                break;
            case "Togo":
                mYcountrySymbol = "";

                break;
            case "Tonga":
                mYcountrySymbol = "";

                break;
            case "Trinidad & Tobago":
                mYcountrySymbol = "";

                break;
            case "Tunisia":
                mYcountrySymbol = "";

                break;
            case "Turkey":
                mYcountrySymbol = "";

                break;
            case "Turkmenistan":
                mYcountrySymbol = "";

                break;
            case "Tuvalu":
                mYcountrySymbol = "";

                break;
            case "Uganda":
                mYcountrySymbol = "";

                break;
            case "Ukraine":
                mYcountrySymbol = "";

                break;
            case "United Arab Emirates":
                mYcountrySymbol = "";

                break;
            case "United Kingdom":
                mYcountrySymbol = "";

                break;
            case "United States":
                mYcountrySymbol = "";

                break;
            case "Uruguay":
                mYcountrySymbol = "";

                break;
            case "Uzbekistan":
                mYcountrySymbol = "";

                break;
            case "Vanuatu":
                mYcountrySymbol = "";

                break;
            case "Venezuela, Bolivarian Republic Of":
                mYcountrySymbol = "";

                break;
            case "Vietnam":
                mYcountrySymbol = "";

                break;
            case "Yemen":
                mYcountrySymbol = "";

                break;
            case "Zambia":
                mYcountrySymbol = "";

                break;
            case "Zimbabwe":
                mYcountrySymbol = "";

                break;
            case "":
                mYcountrySymbol = "";

                break;
        }






        return mYcountrySymbol;
    }














    public Boolean getmCommaOrPeriod() {

        switch (mYcountryName) {
            case "India":
                mCommaOrPeriod = true;

                break;
            case "Afghanistan":
                mCommaOrPeriod = true;

                break;
            case "Albania":
                mCommaOrPeriod = false;

                break;
            case "Algeria":
                mCommaOrPeriod = false;

                break;
            case "Andorra":
                mCommaOrPeriod = false;

                break;
            case "Angola":
                mCommaOrPeriod = false;

                break;
            case "Antigua and Barbuda":
                mCommaOrPeriod = true;

                break;
            case "Argentina":
                mCommaOrPeriod = false;

                break;
            case "Armenia":
                mCommaOrPeriod = false;

                break;
            case "Australia":
                mCommaOrPeriod = true;

                break;
            case "Austria":
                mCommaOrPeriod = false;

                break;
            case "Azerbaijan":
                mCommaOrPeriod = false;

                break;
            case "Bahamas":
                mCommaOrPeriod = true;

                break;
            case "Bahrain":
                mCommaOrPeriod = true;

                break;
            case "Bangladesh":
                mCommaOrPeriod = true;

                break;
            case "Barbados":
                mCommaOrPeriod = true;

                break;
            case "Belarus":
                mCommaOrPeriod = false;


                break;
            case "Belgium":
                mCommaOrPeriod = false;


                break;
            case "Belize":
                mCommaOrPeriod = true;


                break;
            case "Benin":
                mCommaOrPeriod = false;


                break;
            case "Bhutan":
                mCommaOrPeriod = true;


                break;
            case "Bolivia, Plurinational State Of":
                mCommaOrPeriod = false;


                break;
            case "Bosnia And Herzegovina":
                mCommaOrPeriod = false;


                break;
            case "Botswana":
                mCommaOrPeriod = true;


                break;
            case "Brazil":
                mCommaOrPeriod = false;


                break;
            case "Brunei Darussalam":
                mCommaOrPeriod = false;


                break;
            case "Bulgaria":
                mCommaOrPeriod = false;


                break;
            case "Burkina Faso":
                mCommaOrPeriod = false;


                break;
            case "Burundi":
                mCommaOrPeriod = false;


                break;
            case "Cambodia":
                mCommaOrPeriod = false;

                break;
            case "Cameroon":
                mCommaOrPeriod = false;


                break;
            case "Canada":
                mCommaOrPeriod = true;


                break;
            case "Cape Verde":
                mCommaOrPeriod = false;


                break;
            case "Central African Republic":
                mCommaOrPeriod = false;


                break;
            case "Chad":
                mCommaOrPeriod = false;


                break;
            case "Chile":
                mCommaOrPeriod = false;


                break;
            case "China":
                mCommaOrPeriod = true;


                break;
            case "Colombia":
                mCommaOrPeriod = false;


                break;
            case "Comoros":
                mCommaOrPeriod = false;


                break;
            case "Congo":
                mCommaOrPeriod = false;


                break;
            case "Congo, The Democratic Republic Of The":
                mCommaOrPeriod = false;


                break;
            case "Costa Rica":
                mCommaOrPeriod = false;


                break;
            case "Côte D'ivoire":
                mCommaOrPeriod = false;


                break;
            case "Croatia":
                mCommaOrPeriod = false;


                break;
            case "Cuba":
                mCommaOrPeriod = true;


                break;
            case "Cyprus":
                mCommaOrPeriod = false;


                break;
            case "Czech Republic":
                mCommaOrPeriod = false;


                break;
            case "Denmark":
                mCommaOrPeriod = false;


                break;
            case "Djibouti":
                mCommaOrPeriod = false;


                break;
            case "Dominica":
                mCommaOrPeriod = true;


                break;
            case "Dominican Republic":
                mCommaOrPeriod = true;


                break;
            case "Ecuador":
                mCommaOrPeriod = false;


                break;
            case "Egypt":
                mCommaOrPeriod = true;


                break;
            case "El Salvador":
                mCommaOrPeriod = true;


                break;
            case "Equatorial Guinea":
                mCommaOrPeriod = false;


                break;
            case "Eritrea":
                mCommaOrPeriod = true;


                break;
            case "Estonia":
                mCommaOrPeriod = false;


                break;
            case "Ethiopia":
                mCommaOrPeriod = true;


                break;
            case "Fiji":
                mCommaOrPeriod = true;


                break;
            case "Finland":
                mCommaOrPeriod = false;


                break;
            case "France":
                mCommaOrPeriod = false;


                break;
            case "Gabon":
                mCommaOrPeriod = false;


                break;
            case "Gambia":
                mCommaOrPeriod = true;


                break;
            case "Georgia":
                mCommaOrPeriod = false;


                break;
            case "Germany":
                mCommaOrPeriod = false;


                break;
            case "Ghana":
                mCommaOrPeriod = true;


                break;
            case "Greece":
                mCommaOrPeriod = false;


                break;
            case "Grenada":
                mCommaOrPeriod = true;


                break;
            case "Guatemala":
                mCommaOrPeriod = true;


                break;
            case "Guinea":
                mCommaOrPeriod = false;


                break;
            case "Guinea-bissau":
                mCommaOrPeriod = false;


                break;
            case "Guyana":
                mCommaOrPeriod = true;


                break;
            case "Haiti":
                mCommaOrPeriod = false;


                break;
            case "Holy See (vatican City State)":
                mCommaOrPeriod = false;

                break;
            case "Honduras":
                mCommaOrPeriod = true;


                break;
            case "Hungary":
                mCommaOrPeriod = false;


                break;
            case "Iceland":
                mCommaOrPeriod = false;


                break;
            case "Indonesia":



                break;
            case "Iran, Islamic Republic Of":


                break;
            case "Iraq":


                break;
            case "Ireland":


                break;
            case "Israel":


                break;
            case "Italy":


                break;
            case "Jamaica":


                break;
            case "Japan":


                break;
            case "Jordan":


                break;
            case "Kazakhstan":


                break;
            case "Kenya":


                break;
            case "Kiribati":


                break;
            case "Kuwait":


                break;
            case "Kyrgyzstan":


                break;
            case "Lao People's Democratic Republic":


                break;
            case "Latvia":


                break;
            case "Lebanon":


                break;
            case "Lesotho":


                break;
            case "Liberia":


                break;
            case "Libya":


                break;
            case "Liechtenstein":


                break;
            case "Lithuania":


                break;
            case "Luxembourg":


                break;
            case "Macedonia (FYROM)":


                break;
            case "Madagascar":


                break;
            case "Malawi":


                break;
            case "Malaysia":


                break;
            case "Maldives":


                break;
            case "Mali":


                break;
            case "Malta":


                break;
            case "Marshall Islands":


                break;
            case "Mauritania":


                break;
            case "Mauritius":


                break;
            case "Mexico":


                break;
            case "Micronesia, Federated States Of":


                break;
            case "Moldova, Republic Of":


                break;
            case "Monaco":


                break;
            case "Mongolia":


                break;
            case "Montenegro":


                break;
            case "Morocco":


                break;
            case "Mozambique":


                break;
            case "Myanmar":


                break;
            case "Namibia":


                break;
            case "Nauru":


                break;
            case "Nepal":


                break;
            case "Netherlands":


                break;
            case "New Zealand":


                break;
            case "Nicaragua":


                break;
            case "Niger":


                break;
            case "Nigeria":


                break;
            case "North Korea":


                break;
            case "Norway":


                break;
            case "Oman":


                break;
            case "Pakistan":


                break;
            case "Palau":


                break;
            case "Palestine":


                break;
            case "Panama":


                break;
            case "Papua New Guinea":


                break;
            case "Paraguay":


                break;
            case "Peru":


                break;
            case "Philippines":


                break;
            case "Poland":


                break;
            case "Portugal":


                break;
            case "Qatar":


                break;
            case "Romania":


                break;
            case "Russian Federation":


                break;
            case "Rwanda":


                break;
            case "Saint Kitts and Nevis":


                break;
            case "Saint Lucia":


                break;
            case "Saint Vincent & The Grenadines":


                break;
            case "Samoa":


                break;
            case "San Marino":


                break;
            case "Sao Tome and Principe":


                break;
            case "Saudi Arabia":


                break;
            case "Senegal":


                break;
            case "Serbia":


                break;
            case "Seychelles":


                break;
            case "Sierra Leone":


                break;
            case "Singapore":


                break;
            case "Slovakia":


                break;
            case "Slovenia":


                break;
            case "Solomon Islands":


                break;
            case "Somalia":


                break;
            case "South Africa":


                break;
            case "South Korea":


                break;
            case "South Sudan":


                break;
            case "Spain":


                break;
            case "Sri Lanka":


                break;
            case "Sudan":


                break;
            case "Suriname":


                break;
            case "Swaziland":


                break;
            case "Sweden":


                break;
            case "Switzerland":


                break;
            case "Syrian Arab Republic":


                break;
            case "Tajikistan":


                break;
            case "Tanzania, United Republic Of":


                break;
            case "Thailand":


                break;
            case "Timor-leste":


                break;
            case "Togo":


                break;
            case "Tonga":


                break;
            case "Trinidad & Tobago":


                break;
            case "Tunisia":


                break;
            case "Turkey":


                break;
            case "Turkmenistan":


                break;
            case "Tuvalu":


                break;
            case "Uganda":


                break;
            case "Ukraine":


                break;
            case "United Arab Emirates":


                break;
            case "United Kingdom":


                break;
            case "United States":


                break;
            case "Uruguay":


                break;
            case "Uzbekistan":


                break;
            case "Vanuatu":


                break;
            case "Venezuela, Bolivarian Republic Of":


                break;
            case "Vietnam":


                break;
            case "Yemen":


                break;
            case "Zambia":


                break;
            case "Zimbabwe":


                break;

            // need to remove warning warning warning n
            default:
//                mCommaOrPeriod = false;
                break;
        }



        return mCommaOrPeriod;
    }



    public void setmYcountrySymbol(String countrySymbol) {
        mYcountrySymbol = countrySymbol;
    }

    public String getCountryName() {
        return mYcountryName;
    }

    public void setCountryName(String countryName) {
        mYcountryName = countryName;
    }

    public void setCountryCurrency(String countryCurrency) {
        mYcountryCurrency = countryCurrency;
    }




}
