package com.company.model;

public class Account {
    private int account_ID;
    private int customer_ID;
    private int account_Number;
    private int account_Type_ID;
    private double account_Balance;

    public int getAccount_ID() {
        return account_ID;
    }

    public void setAccount_ID(int account_ID) {
        this.account_ID = account_ID;
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public int getAccount_Number() {
        return account_Number;
    }

    public void setAccount_Number(int account_Number) {
        this.account_Number = account_Number;
    }

    public int getAccount_Type_ID() {
        return account_Type_ID;
    }

    public void setAccount_Type_ID(int account_Type_ID) {
        this.account_Type_ID = account_Type_ID;
    }

    public double getAccount_Balance() {
        return account_Balance;
    }

    public void setAccount_Balance(double account_Balance) {
        this.account_Balance = account_Balance;
    }
}
