package com.company.model;

import java.sql.*;

public class Datasource {
    // Database name
    // SQLite connection strings
    public static final String DB_Name = "bankofhome.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/Bing/Documents/GitHub/BingNaYang.github.io/BankOfHome_DB/" + DB_Name;

    // TABLE: Account
    private static final String TABLE_ACCOUNT = "account";
    private static final String COLUMN_ACCOUNT_ID = "account_ID";
    private static final String COLUMN_ACCOUNT_CUSTOMER_ID = "customer_ID";
    private static final String COLUMN_ACCOUNT_NUMBER = "account_Number";
    private static final String COLUMN_ACCOUNT_TYPE_ID = "account_Type_ID";
    private static final String COLUMN_ACCOUNT_BALANCE = "balance";
    // TABLE: Account_Type
    private static final String TABLE_ACCOUNT_TYPE = "account_type";
    private static final String COLUMN_ACC_TYPE_ID = "type_ID";
    private static final String COLUMN_ACC_TYPE_NAME = "type_Name";
    // TABLE: Address
    private static final String TABLE_ADDRESS = "address";
    private static final String COLUMN_ADDRESS_LINE = "line";
    private static final String COLUMN_ADDRESS_CITY = "city";
    private static final String COLUMN_ADDRESS_STATE = "state";
    private static final String COLUMN_ADDRESS_ZIP_CODE = "zip_Code";
    // TABLE: Bank
    private static final String TABLE_BANK = "bank";
    private static final String COLUMN_BANK_ID = "bank_ID";
    private static final String COLUMN_BANK_NAME = "bank_Name";
    private static final String COLUMN_BANK_ADDRESS_ID = "address_ID";
    private static final String COLUMN_BANK_CONTACT_ID = "contact_ID";
    // TABLE: Branch
    private static final String TABLE_BRANCH = "branch";
    private static final String COLUMN_BRANCH_ID = "branch_ID";
    private static final String COLUMN_BRANCH_ADDRESS_ID = "address_ID";
    private static final String COLUMN_BRANCH_CONTACT_ID = "contact_ID";
    private static final String COLUMN_BRANCH_MANAGER_ID = "manager_ID";
    private static final String COLUMN_BRANCH_NAME = "branch_Name";
    // TABLE: Contact
    private static final String TABLE_CONTACT = "contact";
    private static final String COLUMN_CONTACT_ID = "contact_ID";
    private static final String COLUMN_CONTACT_PHONE = "phone";
    private static final String COLUMN_CONTACT_EMAIL = "email";
    // TABLE: Customer
    private static final String TABLE_CUSTOMER = "customer";
    private static final String COLUMN_CUSTOMER_ID = "customer_ID";
    private static final String COLUMN_CUSTOMER_FIRST_NAME = "first_Name";
    private static final String COLUMN_CUSTOMER_LAST_NAME = "last_Name";
    private static final String COLUMN_CUSTOMER_ADDRESS_ID = "address_ID";
    private static final String COLUMN_CUSTOMER_CONTACT_ID = "contact_ID";
    // TABLE: Employee
    private static final String TABLE_EMPLOYEE = "employee";
    private static final String COLUMN_EMPLOYEE_ID = "employee_ID";
    private static final String COLUMN_EMPLOYEE_FIRST_NAME = "first_Name";
    private static final String COLUMN_EMPLOYEE_LAST_NAME = "last_Name";
    private static final String COLUMN_EMPLOYEE_SALARY = "salary";
    private static final String COLUMN_EMPLOYEE_SUPERVISOR_ID = "supervisor_ID";
    private static final String COLUMN_EMPLOYEE_BRANCH_ID = "branch_ID";
    private static final String COLUMN_EMPLOYEE_TITLE_ID = "title_ID";
    private static final String COLUMN_EMPLOYEE_CONTACT_ID = "contact_ID";
    // TABLE: Title
    private static final String TABLE_TITLE = "title";
    private static final String COLUMN_TITLE_ID = "title_ID";
    private static final String COLUMN_TITLE_NAME = "title_Name";
    // TABLE: Transaction
    private static final String TABLE_TRANSACTION = "transactions";
    private static final String COLUMN_TRANSACTION_ID = "transaction_ID";
    private static final String COLUMN_TRANSACTION_ACCOUNT_ID = "account_ID";
    private static final String COLUMN_TRANSACTION_BRANCH_ID = "branch_ID";
    private static final String COLUMN_TRANSACTION_TYPE_ID = "transaction_Type_ID";
    private static final String COLUMN_TRANSACTION_DATE = "date";
    private static final String COLUMN_TRANSACTION_TIME = "time";
    private static final String COLUMN_TRANSACTION_EMPLOYEE_ID = "employee_ID";
    private static final String COLUMN_TRANSACTION_AMOUNT = "amount";
    // TABLE: Transaction_Type
    private static final String TABLE_TRANSACTION_TYPE = "transaction_type";
    private static final String COLUMN_TRANS_TYPE_ID = "transaction_Type_ID";
    private static final String COLUMN_TRANS_TYPE_NAME = "transaction_Name";

    /**
     * DB Query
     */
//    SELECT account.account_Number
//    FROM account
//    INNER JOIN customer
//    WHERE customer.first_Name = "Mary" AND customer.last_Name = "Anderson"
//    AND customer.customer_ID = account.customer_ID
    private static final String QUERY_ACCOUNT_NUMBER_BY_NAME =
        "SELECT "+TABLE_ACCOUNT+"."+COLUMN_ACCOUNT_NUMBER+
        " FROM "+TABLE_ACCOUNT+
        " INNER JOIN "+TABLE_CUSTOMER+
        " WHERE "+TABLE_CUSTOMER+"."+COLUMN_CUSTOMER_FIRST_NAME+"=?"+
        " AND "+TABLE_CUSTOMER+"."+COLUMN_CUSTOMER_LAST_NAME+"=?"+
        " AND "+TABLE_CUSTOMER+"."+COLUMN_CUSTOMER_ID+" = "+TABLE_ACCOUNT+"."+COLUMN_ACCOUNT_CUSTOMER_ID;




    private Connection connection;

    private PreparedStatement queryAccountNumberByName;

    // Open Connection
    public boolean open(){
        try{
            connection = DriverManager.getConnection(CONNECTION_STRING);

            queryAccountNumberByName = connection.prepareStatement(QUERY_ACCOUNT_NUMBER_BY_NAME);

            return true;
        }catch (SQLException e){
            System.out.println("Couldn't connect to database: " + e.getMessage());
            e.getMessage();
            return false;
        }
    }

    // Close Connection
    public void close(){
        try{
            if(queryAccountNumberByName != null){
                queryAccountNumberByName.close();
            }

            // Close Connection
            if (connection != null) {
                connection.close();
            }
        }catch (SQLException e){
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public int setQueryAccountNumberByName(String firstName, String lastName){
        try{
            queryAccountNumberByName.setString(1,firstName);
            queryAccountNumberByName.setString(2,lastName);
            ResultSet resultSet = queryAccountNumberByName.executeQuery();

            int accountNumber = resultSet.getInt(1);
            return accountNumber;

        }catch (SQLException e){
            System.out.println("Query failed: " + e.getMessage());
            return -1;
        }
    }
}
