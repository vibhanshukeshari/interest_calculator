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
                mYcountrySymbol = "";

                break;
            case "Cameroon":
                mYcountrySymbol = "";

                break;
            case "Canada":
                mYcountrySymbol = "";

                break;
            case "Cape Verde":
                mYcountrySymbol = "";
                break;
            case "Central African Republic":
                mYcountrySymbol = "";

                break;
            case "Chad":
                mYcountrySymbol = "";

                break;
            case "Chile":
                mYcountrySymbol = "";

                break;
            case "China":
                mYcountrySymbol = "";

                break;
            case "Colombia":
                mYcountrySymbol = "";

                break;
            case "Comoros":
                mYcountrySymbol = "";

                break;
            case "Congo":
                mYcountrySymbol = "";

                break;
            case "Congo, The Democratic Republic Of The":
                mYcountrySymbol = "";

                break;
            case "Costa Rica":
                mYcountrySymbol = "";

                break;
            case "Côte D'ivoire":
                mYcountrySymbol = "";

                break;
            case "Croatia":
                mYcountrySymbol = "";

                break;
            case "Cuba":
                mYcountrySymbol = "";

                break;
            case "Cyprus":
                mYcountrySymbol = "";

                break;
            case "Czech Republic":
                mYcountrySymbol = "";

                break;
            case "Denmark":
                mYcountrySymbol = "";

                break;
            case "Djibouti":
                mYcountrySymbol = "";

                break;
            case "Dominica":
                mYcountrySymbol = "";

                break;
            case "Dominican Republic":
                mYcountrySymbol = "";

                break;
            case "Ecuador":
                mYcountrySymbol = "";

                break;
            case "Egypt":
                mYcountrySymbol = "";

                break;
            case "El Salvador":
                mYcountrySymbol = "";

                break;
            case "Equatorial Guinea":
                mYcountrySymbol = "";

                break;
            case "Eritrea":
                mYcountrySymbol = "";

                break;
            case "Estonia":
                mYcountrySymbol = "";

                break;
            case "Ethiopia":
                mYcountrySymbol = "";

                break;
            case "Fiji":
                mYcountrySymbol = "";

                break;
            case "Finland":
                mYcountrySymbol = "";

                break;
            case "France":
                mYcountrySymbol = "";

                break;
            case "Gabon":
                mYcountrySymbol = "";

                break;
            case "Gambia":
                mYcountrySymbol = "";

                break;
            case "Georgia":
                mYcountrySymbol = "";

                break;
            case "Germany":
                mYcountrySymbol = "";

                break;
            case "Ghana":
                mYcountrySymbol = "";

                break;
            case "Greece":
                mYcountrySymbol = "";

                break;
            case "Grenada":
                mYcountrySymbol = "";

                break;
            case "Guatemala":
                mYcountrySymbol = "";

                break;
            case "Guinea":
                mYcountrySymbol = "";

                break;
            case "Guinea-bissau":
                mYcountrySymbol = "";

                break;
            case "Guyana":
                mYcountrySymbol = "";

                break;
            case "Haiti":
                mYcountrySymbol = "";

                break;
            case "Holy See (vatican City State)":
                mYcountrySymbol = "";

                break;
            case "Honduras":
                mYcountrySymbol = "";

                break;
            case "Hungary":
                mYcountrySymbol = "";

                break;
            case "Iceland":
                mYcountrySymbol = "";

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


                break;
            case "Cameroon":


                break;
            case "Canada":


                break;
            case "Cape Verde":


                break;
            case "Central African Republic":


                break;
            case "Chad":


                break;
            case "Chile":


                break;
            case "China":


                break;
            case "Colombia":


                break;
            case "Comoros":


                break;
            case "Congo":


                break;
            case "Congo, The Democratic Republic Of The":


                break;
            case "Costa Rica":


                break;
            case "Côte D'ivoire":


                break;
            case "Croatia":


                break;
            case "Cuba":


                break;
            case "Cyprus":


                break;
            case "Czech Republic":


                break;
            case "Denmark":


                break;
            case "Djibouti":


                break;
            case "Dominica":


                break;
            case "Dominican Republic":


                break;
            case "Ecuador":


                break;
            case "Egypt":


                break;
            case "El Salvador":


                break;
            case "Equatorial Guinea":


                break;
            case "Eritrea":


                break;
            case "Estonia":


                break;
            case "Ethiopia":


                break;
            case "Fiji":


                break;
            case "Finland":


                break;
            case "France":


                break;
            case "Gabon":


                break;
            case "Gambia":


                break;
            case "Georgia":


                break;
            case "Germany":


                break;
            case "Ghana":


                break;
            case "Greece":


                break;
            case "Grenada":


                break;
            case "Guatemala":


                break;
            case "Guinea":


                break;
            case "Guinea-bissau":


                break;
            case "Guyana":


                break;
            case "Haiti":


                break;
            case "Holy See (vatican City State)":


                break;
            case "Honduras":


                break;
            case "Hungary":


                break;
            case "Iceland":


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
                mCommaOrPeriod = false;
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
