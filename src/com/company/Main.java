package com.company;

import com.company.model.Datasource;
import com.company.model.TransactionView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        // Get current date and time
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        String currentDate = localDate.format(dateFormatter);
        String currentTime = localTime.format(timeFormatter);
        // Scanner
        Scanner scanner = new Scanner(System.in);
        int option;
        if(!datasource.open()){
            System.out.println("Could not open datasource");
            return;
        }
        System.out.println("========Welcome to Bank Of Home========");
        System.out.println("Date: "+localDate.format(dateFormatter)+" Time: "+localTime.format(timeFormatter));
//        do{
//            tellerMenu();
//            option = scanner.nextInt();
//            switch (option){
//                case 1:
//                    searchAccountNumber(datasource);
//                    break;
//                case 2:
//                    searchTransactionsAndBalance(datasource);
//                    break;
//                case 3:
//                    depositTransaction(datasource,currentDate,currentTime);
//                    break;
//                case 4:
//                    withdrawTransaction(datasource,currentDate,currentTime);
//                    break;
//                case 5:
//                    System.out.println("Goodbye!! Have a Wealthy Day :)");
//                    break;
//                default:
//                    System.out.println("Not an option");
//                    break;
//            }
//        }while (option != 5);
        do{
            managerMenu();
            option = scanner.nextInt();
            switch (option){
                case 1:
                    listCustomerAccountNumberName(datasource);
                    break;
                case 2:
                    listAllEmployee(datasource);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Goodbye!! Have a Wealthy Day :)");
                    break;
                default:
                    System.out.println("Not an option");
                    break;
            }
        }while(option != 5);

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
    public static void managerMenu(){
        System.out.println("----- Manager Mode -----");
        System.out.println("1. Display All Customer Accounts");
        System.out.println("2. Display All Employees");
        System.out.println("3. Open New Account");
        System.out.println("4. Add New Employee");
        System.out.println("5. Edit Employee Info");
        System.out.println("6: Quit");
        System.out.println("Select One: ");
    }

    // Methods for Teller Mode
    public static void searchAccountNumber(Datasource datasource){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer First Name: ");
        String firstName = scanner.next();
        System.out.println("Enter Customer Last Name: ");
        String lastName = scanner.next();

        int temp = datasource.queryAccountNumberByName(firstName,lastName);
        if(temp < 0){
            System.out.println("No such customer in database");
        }else{
            System.out.println("Name: "+firstName+" "+lastName);
            System.out.println("Account Number:"+temp);
        }
    }
    public static void searchTransactionsAndBalance(Datasource datasource){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Account Number: ");
        int accountNumber = scanner.nextInt();

        List<TransactionView> transactionViewList = datasource.queryTransactionView(accountNumber);
        if(transactionViewList.isEmpty()){
            System.out.println("Couldn't find");
            return;
        }
        System.out.println("Account Number: "+transactionViewList.get(0).getAccount_Number());

        for(int i=0; i<transactionViewList.size();i++){
            System.out.println("Transaction "+(i+1)+
                    "\nDate: "+transactionViewList.get(i).getTrans_Date()+
                    "\nTime: "+transactionViewList.get(i).getTrans_Time()+
                    "\nBranch Name: "+transactionViewList.get(i).getBranch_Name()+
                    "\nEmployee Name: "+transactionViewList.get(i).getEmployee_LastName()+
                    "\nAmount: $"+transactionViewList.get(i).getAmount()+"\n");
        }
        System.out.println("Balance: $"+datasource.queryAccountBalance());
    }
    public static void depositTransaction(Datasource datasource,String currentDate, String currentTime){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        System.out.println("Employee Last Name: ");
        String employeeLastName = scanner.next();
        System.out.println("Deposit Amount: ");
        double transAmount = scanner.nextDouble();
        datasource.insertNewTransaction(accountNumber,"deposit",currentDate,currentTime,employeeLastName,transAmount);
    }
    public static void withdrawTransaction(Datasource datasource,String currentDate, String currentTime){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        System.out.println("Employee Last Name: ");
        String employeeLastName = scanner.next();
        System.out.println("Withdraw Amount: ");
        double transAmount = scanner.nextDouble()*(-1);
        datasource.insertNewTransaction(accountNumber,"withdraw",currentDate,currentTime,employeeLastName,transAmount);
    }
    // Methods for Manager Mode
    public static void listCustomerAccountNumberName(Datasource datasource){
        List<String> customerAccountList = datasource.queryAllCustomerAccountNumberAndName();
        if(customerAccountList.isEmpty()){
            System.out.println("Empty....");
        }
        for(int i=0;i<customerAccountList.size();i++){
            System.out.println((i+1)+": "+customerAccountList.get(i));
        }
    }
    public static void listAllEmployee(Datasource datasource){
        List<String> employeeList = datasource.queryAllEmployees();
        if(employeeList.isEmpty()){
            System.out.println("Empty....");
        }
        for(int i=0;i<employeeList.size();i++){
            System.out.println((i+1)+": "+employeeList.get(i));
        }
    }


}
