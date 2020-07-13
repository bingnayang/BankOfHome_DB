package com.company.model;

public class Employee {
    private int employee_ID;
    private String first_Name;
    private String last_Name;
    private double salary;
    private int supervisor_ID;
    private int branch_ID;
    private int title_ID;
    private int contact_ID;

    public int getEmployee_ID() {
        return employee_ID;
    }

    public void setEmployee_ID(int employee_ID) {
        this.employee_ID = employee_ID;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSupervisor_ID() {
        return supervisor_ID;
    }

    public void setSupervisor_ID(int supervisor_ID) {
        this.supervisor_ID = supervisor_ID;
    }

    public int getBranch_ID() {
        return branch_ID;
    }

    public void setBranch_ID(int branch_ID) {
        this.branch_ID = branch_ID;
    }

    public int getTitle_ID() {
        return title_ID;
    }

    public void setTitle_ID(int title_ID) {
        this.title_ID = title_ID;
    }

    public int getContact_ID() {
        return contact_ID;
    }

    public void setContact_ID(int contact_ID) {
        this.contact_ID = contact_ID;
    }
}
