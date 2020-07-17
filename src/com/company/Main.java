package com.company;

import com.company.model.Datasource;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if(!datasource.open()){
            System.out.println("Could not open datasource");
            return;
        }

        queryAccountNumber(datasource);


        // Close connection
        datasource.close();
    }
    public static void tellerMenu(){
        System.out.println("----- Teller Mode -----");
        System.out.println("Search Customer Account Number");
        System.out.println("Search Customer Transactions & Balance");
        System.out.println("Deposit To Account");
        System.out.println("Withdraw From Account");
    }
    public static void queryAccountNumber(Datasource datasource){
        String firstName = "Mary";
        String lastName = "Anderson";
        int temp = datasource.setQueryAccountNumberByName(firstName,lastName);
        System.out.println("Name: "+firstName+" "+lastName);
        System.out.println("Account Number:"+temp);
    }
}
