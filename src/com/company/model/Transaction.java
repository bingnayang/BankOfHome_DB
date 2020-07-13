package com.company.model;

public class Transaction {
    private int transaction_ID;
    private int account_ID;
    private int branch_ID;
    private int transaction_Type_ID;
    private String transaction_Date;
    private String transaction_Time;
    private int employee_ID;
    private double amount;

    public int getTransaction_ID() {
        return transaction_ID;
    }

    public void setTransaction_ID(int transaction_ID) {
        this.transaction_ID = transaction_ID;
    }

    public int getAccount_ID() {
        return account_ID;
    }

    public void setAccount_ID(int account_ID) {
        this.account_ID = account_ID;
    }

    public int getBranch_ID() {
        return branch_ID;
    }

    public void setBranch_ID(int branch_ID) {
        this.branch_ID = branch_ID;
    }

    public int getTransaction_Type_ID() {
        return transaction_Type_ID;
    }

    public void setTransaction_Type_ID(int transaction_Type_ID) {
        this.transaction_Type_ID = transaction_Type_ID;
    }

    public String getTransaction_Date() {
        return transaction_Date;
    }

    public void setTransaction_Date(String transaction_Date) {
        this.transaction_Date = transaction_Date;
    }

    public String getTransaction_Time() {
        return transaction_Time;
    }

    public void setTransaction_Time(String transaction_Time) {
        this.transaction_Time = transaction_Time;
    }

    public int getEmployee_ID() {
        return employee_ID;
    }

    public void setEmployee_ID(int employee_ID) {
        this.employee_ID = employee_ID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
