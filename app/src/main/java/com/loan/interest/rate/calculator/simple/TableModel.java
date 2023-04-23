package com.loan.interest.rate.calculator.simple;

public class TableModel {

    String year;
    String interest;
    String AccruedInterest;
    String Balance;

    public String getYear() {
        return year;
    }

    public TableModel(String year, String interest, String accruedInterest, String balance) {
        this.year = year;
        this.interest = interest;
        this.AccruedInterest = accruedInterest;
        this.Balance = balance;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getAccruedInterest() {
        return AccruedInterest;
    }

    public void setAccruedInterest(String accruedInterest) {
        AccruedInterest = accruedInterest;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }
}
