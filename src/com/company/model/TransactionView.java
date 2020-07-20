package com.company.model;

public class TransactionView {
    private int transaction_ID;
    private int account_Number;
    private String branch_Name;
    private String trans_Date;
    private String trans_Time;
    private String employee_LastName;
    private double amount;

    public int getTransaction_ID() {
        return transaction_ID;
    }

    public void setTransaction_ID(int transaction_ID) {
        this.transaction_ID = transaction_ID;
    }

    public int getAccount_Number() {
        return account_Number;
    }

    public void setAccount_Number(int account_Number) {
        this.account_Number = account_Number;
    }

    public String getBranch_Name() {
        return branch_Name;
    }

    public void setBranch_Name(String branch_Name) {
        this.branch_Name = branch_Name;
    }

    public String getTrans_Date() {
        return trans_Date;
    }

    public void setTrans_Date(String trans_Date) {
        this.trans_Date = trans_Date;
    }

    public String getTrans_Time() {
        return trans_Time;
    }

    public void setTrans_Time(String trans_Time) {
        this.trans_Time = trans_Time;
    }

    public String getEmployee_LastName() {
        return employee_LastName;
    }

    public void setEmployee_LastName(String employee_LastName) {
        this.employee_LastName = employee_LastName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
