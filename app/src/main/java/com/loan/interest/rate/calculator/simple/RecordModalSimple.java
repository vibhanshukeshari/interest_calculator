package com.loan.interest.rate.calculator.simple;

public class RecordModalSimple {

    // variables,
    // description, tracks and duration, id.
    private String name;
    private String typeSorC;
    private String date;
    private String principalAmount;
    private String interestRate;
    private String interestRateFrequency;
    private String years;
    private String months;
    private String days;
    private String interestAmount;
    private String totalAmount;

    public String getTimeAsUniqueId() {
        return timeAsUniqueId;
    }

    public void setTimeAsUniqueId(String timeAsUniqueId) {
        this.timeAsUniqueId = timeAsUniqueId;
    }

    private String timeAsUniqueId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeSorC() {
        return typeSorC;
    }

    public void setTypeSorC(String typeSorC) {
        this.typeSorC = typeSorC;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(String principalAmount) {
        this.principalAmount = principalAmount;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getInterestRateFrequency() {
        return interestRateFrequency;
    }

    public void setInterestRateFrequency(String interestRateFrequency) {
        this.interestRateFrequency = interestRateFrequency;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }


    public String getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(String interestAmount) {
        this.interestAmount = interestAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public RecordModalSimple(String name, String typeSorC, String date, String principalAmount, String interestRate, String interestRateFrequency, String years, String months
            , String days ,String interestAmount, String totalAmount, String timeAsUniqueId) {

        this.name = name;
        this.typeSorC = typeSorC;
        this.date = date;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.interestRateFrequency = interestRateFrequency;
        this.years = years;
        this.months = months;
        this.days = days;
        this.interestAmount = interestAmount;
        this.totalAmount = totalAmount;
        this.timeAsUniqueId = timeAsUniqueId;




    }
}