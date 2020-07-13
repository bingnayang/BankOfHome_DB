package com.company.model;

public class Customer {
    private int customer_ID;
    private String first_Name;
    private String last_Name;
    private int address_ID;
    private int contact_ID;

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public int getAddress_ID() {
        return address_ID;
    }

    public void setAddress_ID(int address_ID) {
        this.address_ID = address_ID;
    }

    public int getContact_ID() {
        return contact_ID;
    }

    public void setContact_ID(int contact_ID) {
        this.contact_ID = contact_ID;
    }
}
