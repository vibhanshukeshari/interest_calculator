package com.loan.interest.rate.calculator.simple;

import static com.loan.interest.rate.calculator.simple.CalculatorFragment.commaOrPeriods;
import static com.loan.interest.rate.calculator.simple.CalculatorFragment.countryName;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.DecimalFormat;

public class PercentFormatter extends ValueFormatter {

    public DecimalFormat mFormat;
    private PieChart pieChart;

    public PercentFormatter() {
        mFormat = new DecimalFormat("###,###.##");
    }
    public PercentFormatter(PieChart pieChart) {
        this();
        this.pieChart = pieChart;
    }

    @Override
    public String getFormattedValue(float value) {



        // this is used to change comma to period or period to comma as per country number system
        if(commaOrPeriods){

            // special case for peru
            if(!countryName.equals("Peru")){
                return mFormat.format(value).replace(",",".") + " %";
            } else {
                return mFormat.format(value).replace(".",",") + " %";
            }

        } else {
            return mFormat.format(value).replace(".",",") + " %";
        }


    }

    @Override
    public String getPieLabel(float value, PieEntry pieEntry) {
        if (pieChart != null && pieChart.isUsePercentValuesEnabled()) {
            // Converted to percent
            return getFormattedValue(value);
        } else {
            // raw value, skip percent sign
            return mFormat.format(value);
        }
    }

}