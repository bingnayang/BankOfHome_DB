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
        System.out.println("1. Search Customer Account Number");
        System.out.println("2. Search Customer Transactions & Balance");
        System.out.println("3. Deposit To Account");
        System.out.println("4. Withdraw From Account");
    }
    public static void queryAccountNumber(Datasource datasource){
        String firstName = "Mary";
        String lastName = "Anderson";
        int temp = datasource.queryAccountNumberByName(firstName,lastName);
        if(temp < 0){
            System.out.println("No such customer in database");
        }else{
            System.out.println("Name: "+firstName+" "+lastName);
            System.out.println("Account Number:"+temp);
        }

    }
}
