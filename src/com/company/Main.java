package com.company;

import com.company.model.Datasource;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        Scanner scanner = new Scanner(System.in);
        int option;
        if(!datasource.open()){
            System.out.println("Could not open datasource");
            return;
        }
        do{
            tellerMenu();
            option = scanner.nextInt();
            switch (option){
                case 1:
                    searchAccountNumber(datasource);
                    break;
                case 2:
                    searchTransactionsBalance(datasource);
                    break;
                case 3:
                    depositTransaction(datasource);
                    break;
                case 4:
                    withdrawTransaction(datasource);
                    break;
                case 5:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Not an option");
                    break;
            }

        }while (option != 5);

        // Close connection
        datasource.close();
    }
    public static void tellerMenu(){
        System.out.println("----- Teller Mode -----");
        System.out.println("1. Search Customer Account Number");
        System.out.println("2. Search Customer Transactions & Balance");
        System.out.println("3. Deposit To Account");
        System.out.println("4. Withdraw From Account");
        System.out.println("5: Quit");
        System.out.println("Select One: ");
    }
    public static void searchAccountNumber(Datasource datasource){
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
    public static void searchTransactionsBalance(Datasource datasource){

    }
    public static void depositTransaction(Datasource datasource){
        int accountNumber = 12300001;
        String branchName = "Home Branch";
        String transactionType = "deposit";
        String transDate = "2020/07/12";
        String transTime = "03:10 PM";
        String employeeLastName = "Adam";
        double transAmount = 350.00;
        datasource.insertNewTransaction(accountNumber,branchName,transactionType,transDate,transTime,employeeLastName,transAmount);
    }
    public static void withdrawTransaction(Datasource datasource){
        int accountNumber = 12300001;
        String branchName = "Home Branch";
        String transactionType = "withdraw";
        String transDate = "2020/07/05";
        String transTime = "02:15 PM";
        String employeeLastName = "Adam";
        double transAmount = -100.00;
        datasource.insertNewTransaction(accountNumber,branchName,transactionType,transDate,transTime,employeeLastName,transAmount);
    }
}
