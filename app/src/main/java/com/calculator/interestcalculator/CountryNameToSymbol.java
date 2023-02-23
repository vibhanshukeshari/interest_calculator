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
                mYcountrySymbol = "DZD";

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
                mYcountrySymbol = "BD";

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
                mYcountrySymbol = "Rp";

                break;
            case "Iran, Islamic Republic Of":
                mYcountrySymbol = "IRR";

                break;
            case "Iraq":
                mYcountrySymbol = "IQD";

                break;
            case "Ireland":
                mYcountrySymbol = "€";

                break;
            case "Israel":
                mYcountrySymbol = "₪";

                break;
            case "Italy":
                mYcountrySymbol = "€";

                break;
            case "Jamaica":
                mYcountrySymbol = "$";

                break;
            case "Japan":
                mYcountrySymbol = "￥";

                break;
            case "Jordan":
                mYcountrySymbol = "JOD";

                break;
            case "Kazakhstan":
                mYcountrySymbol = "₸";

                break;
            case "Kenya":
                mYcountrySymbol = "Ksh";

                break;
            case "Kiribati":
                mYcountrySymbol = "$";

                break;
            case "Kuwait":
                mYcountrySymbol = "KD";

                break;
            case "Kyrgyzstan":
                mYcountrySymbol = "сом";

                break;
            case "Lao People's Democratic Republic":
                mYcountrySymbol = "₭";

                break;
            case "Latvia":
                mYcountrySymbol = "€";

                break;
            case "Lebanon":
                mYcountrySymbol = "LBP";

                break;
            case "Lesotho":
                mYcountrySymbol = "R";

                break;
            case "Liberia":
                mYcountrySymbol = "$";

                break;
            case "Libya":
                mYcountrySymbol = "LD";

                break;
            case "Liechtenstein":
                mYcountrySymbol = "CHF";

                break;
            case "Lithuania":
                mYcountrySymbol = "€";

                break;
            case "Luxembourg":
                mYcountrySymbol = "€";

                break;
            case "Macedonia (FYROM)":
                mYcountrySymbol = "Ден";

                break;
            case "Madagascar":
                mYcountrySymbol = "Ar";

                break;
            case "Malawi":
                mYcountrySymbol = "MK";

                break;
            case "Malaysia":
                mYcountrySymbol = "RM";

                break;
            case "Maldives":
                mYcountrySymbol = "MVR";

                break;
            case "Mali":
                mYcountrySymbol = "CFA";

                break;
            case "Malta":
                mYcountrySymbol = "€";

                break;
            case "Marshall Islands":
                mYcountrySymbol = "$";

                break;
            case "Mauritania":
                mYcountrySymbol = "UM";

                break;
            case "Mauritius":
                mYcountrySymbol = "Rs";

                break;
            case "Mexico":
                mYcountrySymbol = "$";

                break;
            case "Micronesia, Federated States Of":
                mYcountrySymbol = "US$";

                break;
            case "Moldova, Republic Of":
                mYcountrySymbol = "L";

                break;
            case "Monaco":
                mYcountrySymbol = "€";

                break;
            case "Mongolia":
                mYcountrySymbol = "₮";

                break;
            case "Montenegro":
                mYcountrySymbol = "€";

                break;
            case "Morocco":
                mYcountrySymbol = "MAD";

                break;
            case "Mozambique":
                mYcountrySymbol = "MTn";

                break;
            case "Myanmar":
                mYcountrySymbol = "K";

                break;
            case "Namibia":
                mYcountrySymbol = "$";

                break;
            case "Nauru":
                mYcountrySymbol = "$";

                break;
            case "Nepal":
                mYcountrySymbol = "रु॰";

                break;
            case "Netherlands":
                mYcountrySymbol = "€";

                break;
            case "New Zealand":
                mYcountrySymbol = "$";

                break;
            case "Nicaragua":
                mYcountrySymbol = "C$";

                break;
            case "Niger":
                mYcountrySymbol = "CFA";

                break;
            case "Nigeria":
                mYcountrySymbol = "₦";

                break;
            case "North Korea":
                mYcountrySymbol = "₩";

                break;
            case "Norway":
                mYcountrySymbol = "kr";

                break;
            case "Oman":
                mYcountrySymbol = "OMR";

                break;
            case "Pakistan":
                mYcountrySymbol = "Rs";

                break;
            case "Palau":
                mYcountrySymbol = "US$";

                break;
            case "Palestine":
                mYcountrySymbol = "₪";

                break;
            case "Panama":
                mYcountrySymbol = "B/.";

                break;
            case "Papua New Guinea":
                mYcountrySymbol = "K";

                break;
            case "Paraguay":
                mYcountrySymbol = "₲";

                break;
            case "Peru":
                mYcountrySymbol = "S/";

                break;
            case "Philippines":
                mYcountrySymbol = "₱";

                break;
            case "Poland":
                mYcountrySymbol = "zł";

                break;
            case "Portugal":
                mYcountrySymbol = "€";

                break;
            case "Qatar":
                mYcountrySymbol = "QR";

                break;
            case "Romania":
                mYcountrySymbol = "RON";

                break;
            case "Russian Federation":
                mYcountrySymbol = "₽";

                break;
            case "Rwanda":
                mYcountrySymbol = "RF";

                break;
            case "Saint Kitts and Nevis":
                mYcountrySymbol = "$";

                break;
            case "Saint Lucia":
                mYcountrySymbol = "$";

                break;
            case "Saint Vincent & The Grenadines":
                mYcountrySymbol = "$";

                break;
            case "Samoa":
                mYcountrySymbol = "WS$";

                break;
            case "San Marino":
                mYcountrySymbol = "€";

                break;
            case "Sao Tome And Principe":
                mYcountrySymbol = "Db";

                break;
            case "Saudi Arabia":
                mYcountrySymbol = "SR ";

                break;
            case "Senegal":
                mYcountrySymbol = "CFA";

                break;
            case "Serbia":
                mYcountrySymbol = "RSD";

                break;
            case "Seychelles":
                mYcountrySymbol = "SR";

                break;
            case "Sierra Leone":
                mYcountrySymbol = "Le";

                break;
            case "Singapore":
                mYcountrySymbol = "$";

                break;
            case "Slovakia":
                mYcountrySymbol = "€";

                break;
            case "Slovenia":
                mYcountrySymbol = "€";

                break;
            case "Solomon Islands":
                mYcountrySymbol = "$";

                break;
            case "Somalia":
                mYcountrySymbol = "S";

                break;
            case "South Africa":
                mYcountrySymbol = "R";

                break;
            case "South Korea":
                mYcountrySymbol = "₩";

                break;
            case "South Sudan":
                mYcountrySymbol = "£";

                break;
            case "Spain":
                mYcountrySymbol = "€";

                break;
            case "Sri Lanka":
                mYcountrySymbol = "Rs.";

                break;
            case "Sudan":
                mYcountrySymbol = "SDG";

                break;
            case "Suriname":
                mYcountrySymbol = "$";

                break;
            case "Swaziland":
                mYcountrySymbol = "E";

                break;
            case "Sweden":
                mYcountrySymbol = "kr";

                break;
            case "Switzerland":
                mYcountrySymbol = "CHF";

                break;
            case "Syrian Arab Republic":
                mYcountrySymbol = "£S";

                break;
            case "Tajikistan":
                mYcountrySymbol = "сом.";

                break;
            case "Tanzania, United Republic Of":
                mYcountrySymbol = "TSh";

                break;
            case "Thailand":
                mYcountrySymbol = "฿";

                break;
            case "Timor-leste":
                mYcountrySymbol = "US$";

                break;
            case "Togo":
                mYcountrySymbol = "CFA";

                break;
            case "Tonga":
                mYcountrySymbol = "T$";

                break;
            case "Trinidad & Tobago":
                mYcountrySymbol = "$";

                break;
            case "Tunisia":
                mYcountrySymbol = "DT";

                break;
            case "Turkey":
                mYcountrySymbol = "₺";

                break;
            case "Turkmenistan":
                mYcountrySymbol = "TMT";

                break;
            case "Tuvalu":
                mYcountrySymbol = "$";

                break;
            case "Uganda":
                mYcountrySymbol = "USh";

                break;
            case "Ukraine":
                mYcountrySymbol = "₴";

                break;
            case "United Arab Emirates (UAE)":
                mYcountrySymbol = "AED";

                break;
            case "United Kingdom":
                mYcountrySymbol = "£";

                break;
            case "United States":
                mYcountrySymbol = "$";

                break;
            case "Uruguay":
                mYcountrySymbol = "$";

                break;
            case "Uzbekistan":
                mYcountrySymbol = "so'm";

                break;
            case "Vanuatu":
                mYcountrySymbol = "VT";

                break;
            case "Venezuela, Bolivarian Republic Of":
                mYcountrySymbol = "Bs.";

                break;
            case "Vietnam":
                mYcountrySymbol = "₫";

                break;
            case "Yemen":
                mYcountrySymbol = "YER";

                break;
            case "Zambia":
                mYcountrySymbol = "K";

                break;
            case "Zimbabwe":
                mYcountrySymbol = "US$";

                break;

            default:
                mYcountrySymbol = "$";



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
                mCommaOrPeriod = false;



                break;
            case "Iran, Islamic Republic Of":
                mCommaOrPeriod = true;


                break;
            case "Iraq":
                mCommaOrPeriod = true;


                break;
            case "Ireland":
                mCommaOrPeriod = true;


                break;
            case "Israel":
                mCommaOrPeriod = true;


                break;
            case "Italy":
                mCommaOrPeriod = false;


                break;
            case "Jamaica":
                mCommaOrPeriod = true;


                break;
            case "Japan":
                mCommaOrPeriod = true;


                break;
            case "Jordan":
                mCommaOrPeriod = true;


                break;
            case "Kazakhstan":
                mCommaOrPeriod = false;


                break;
            case "Kenya":
                mCommaOrPeriod = true;


                break;
            case "Kiribati":
                mCommaOrPeriod = true;


                break;
            case "Kuwait":
                mCommaOrPeriod = true;


                break;
            case "Kyrgyzstan":
                mCommaOrPeriod = false;


                break;
            case "Lao People's Democratic Republic":
                mCommaOrPeriod = false;


                break;
            case "Latvia":
                mCommaOrPeriod = false;

                break;
            case "Lebanon":
                mCommaOrPeriod = true;


                break;
            case "Lesotho":
                mCommaOrPeriod = true;


                break;
            case "Liberia":
                mCommaOrPeriod = true;


                break;
            case "Libya":
                mCommaOrPeriod = false;


                break;
            case "Liechtenstein":
                mCommaOrPeriod = true;


                break;
            case "Lithuania":
                mCommaOrPeriod = false;


                break;
            case "Luxembourg":
                mCommaOrPeriod = false;


                break;
            case "Macedonia (FYROM)":
                mCommaOrPeriod = false;



                break;
            case "Madagascar":
                mCommaOrPeriod = true;


                break;
            case "Malawi":
                mCommaOrPeriod = true;


                break;
            case "Malaysia":
                mCommaOrPeriod = true;


                break;
            case "Maldives":
                mCommaOrPeriod = true;


                break;
            case "Mali":
                mCommaOrPeriod = false;


                break;
            case "Malta":
                mCommaOrPeriod = true;


                break;
            case "Marshall Islands":
                mCommaOrPeriod = true;


                break;
            case "Mauritania":
                mCommaOrPeriod = true;


                break;
            case "Mauritius":
                mCommaOrPeriod = true;


                break;
            case "Mexico":
                mCommaOrPeriod = true;


                break;
            case "Micronesia, Federated States Of":
                mCommaOrPeriod = true;


                break;
            case "Moldova, Republic Of":
                mCommaOrPeriod = false;


                break;
            case "Monaco":
                mCommaOrPeriod = false;



                break;
            case "Mongolia":
                mCommaOrPeriod = true;


                break;
            case "Montenegro":
                mCommaOrPeriod = false;


                break;
            case "Morocco":
                mCommaOrPeriod = false;


                break;
            case "Mozambique":
                mCommaOrPeriod = false;


                break;
            case "Myanmar":
                mCommaOrPeriod = true;


                break;
            case "Namibia":
                mCommaOrPeriod = true;


                break;
            case "Nauru":
                mCommaOrPeriod = true;


                break;
            case "Nepal":
                mCommaOrPeriod = true;


                break;
            case "Netherlands":
                mCommaOrPeriod = false;


                break;
            case "New Zealand":
                mCommaOrPeriod = true;


                break;
            case "Nicaragua":
                mCommaOrPeriod = true;


                break;
            case "Niger":
                mCommaOrPeriod = false;


                break;
            case "Nigeria":
                mCommaOrPeriod = true;


                break;
            case "North Korea":
                mCommaOrPeriod = true;


                break;
            case "Norway":
                mCommaOrPeriod = false;


                break;
            case "Oman":
                mCommaOrPeriod = true;


                break;
            case "Pakistan":
                mCommaOrPeriod = true;


                break;
            case "Palau":
                mCommaOrPeriod = true;


                break;
            case "Palestine":
                mCommaOrPeriod = true;


                break;
            case "Panama":
                mCommaOrPeriod = true;


                break;
            case "Papua New Guinea":
                mCommaOrPeriod = true;


                break;
            case "Paraguay":
                mCommaOrPeriod = false;


                break;
            case "Peru":
                // it is not confirmed whether this is comma or period;
                // wikipediea says that in peru , is used as decimal separator and . is also usesd as decimal separator but only in currency numbers
                mCommaOrPeriod = true;
//                we have set some special condition to make chage . to comma

                break;
            case "Philippines":
                mCommaOrPeriod = true;


                break;
            case "Poland":
                mCommaOrPeriod = false;


                break;
            case "Portugal":
                mCommaOrPeriod = false;


                break;
            case "Qatar":
                mCommaOrPeriod = true;


                break;
            case "Romania":
                mCommaOrPeriod = false;


                break;
            case "Russian Federation":
                mCommaOrPeriod = false;


                break;
            case "Rwanda":
                // it uses three types of separators(in future we may look);
                mCommaOrPeriod = false;


                break;
            case "Saint Kitts and Nevis":
                mCommaOrPeriod = true;


                break;
            case "Saint Lucia":
                mCommaOrPeriod = true;


                break;
            case "Saint Vincent & The Grenadines":
                mCommaOrPeriod = true;


                break;
            case "Samoa":
                mCommaOrPeriod = true;


                break;
            case "San Marino":
                mCommaOrPeriod = false;


                break;
            case "Sao Tome And Principe":
                mCommaOrPeriod = false;


                break;
            case "Saudi Arabia":
                mCommaOrPeriod = true;


                break;
            case "Senegal":
                mCommaOrPeriod = false;


                break;
            case "Serbia":
                mCommaOrPeriod = false;


                break;
            case "Seychelles":
                mCommaOrPeriod = false;


                break;
            case "Sierra Leone":
                mCommaOrPeriod = true;


                break;
            case "Singapore":
                mCommaOrPeriod = true;


                break;
            case "Slovakia":
                mCommaOrPeriod = false;


                break;
            case "Slovenia":
                mCommaOrPeriod = false;


                break;
            case "Solomon Islands":
                mCommaOrPeriod = true;


                break;
            case "Somalia":
                mCommaOrPeriod = true;


                break;
            case "South Africa":
                mCommaOrPeriod = false;


                break;
            case "South Korea":
                mCommaOrPeriod = true;


                break;
            case "South Sudan":
                mCommaOrPeriod = true;


                break;
            case "Spain":
                mCommaOrPeriod = false;


                break;
            case "Sri Lanka":
                mCommaOrPeriod = true;


                break;
            case "Sudan":
                mCommaOrPeriod = true;


                break;
            case "Suriname":
                mCommaOrPeriod = false;


                break;
            case "Swaziland":
                mCommaOrPeriod = true;


                break;
            case "Sweden":
                mCommaOrPeriod = false;


                break;
            case "Switzerland":
                mCommaOrPeriod = true;


                break;
            case "Syrian Arab Republic":
                mCommaOrPeriod = true;


                break;
            case "Tajikistan":
                mCommaOrPeriod = false;


                break;
            case "Tanzania, United Republic Of":
                mCommaOrPeriod = true;


                break;
            case "Thailand":
                mCommaOrPeriod = true;


                break;
            case "Timor-leste":
                mCommaOrPeriod = false;


                break;
            case "Togo":
                mCommaOrPeriod = false;


                break;
            case "Tonga":
                mCommaOrPeriod = true;


                break;
            case "Trinidad & Tobago":
                mCommaOrPeriod = true;


                break;
            case "Tunisia":
                mCommaOrPeriod = true;


                break;
            case "Turkey":
                mCommaOrPeriod = false;


                break;
            case "Turkmenistan":
                mCommaOrPeriod = false;


                break;
            case "Tuvalu":
                mCommaOrPeriod = true;


                break;
            case "Uganda":
                mCommaOrPeriod = true;


                break;
            case "Ukraine":
                mCommaOrPeriod = false;


                break;
            case "United Arab Emirates (UAE)":
                mCommaOrPeriod = true;


                break;
            case "United Kingdom":
                mCommaOrPeriod = true;


                break;

            case "Uruguay":
                mCommaOrPeriod = false;




                break;
            case "Uzbekistan":
                mCommaOrPeriod = false;


                break;
            case "Vanuatu":
                mCommaOrPeriod = true;


                break;
            case "Venezuela, Bolivarian Republic Of":
                mCommaOrPeriod = false;


                break;
            case "Vietnam":
                mCommaOrPeriod = false;


                break;
            case "Yemen":
                mCommaOrPeriod = true;


                break;
            case "Zambia":
                mCommaOrPeriod = true;


                break;
            case "Zimbabwe":
                mCommaOrPeriod = true;


                break;

            // it is used only for USA because "United Stated" string was not comparing properly by CCP.
            default:
                mCommaOrPeriod = true;
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
