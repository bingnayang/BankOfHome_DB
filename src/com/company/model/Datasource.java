package com.company.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    // TABLE: Transaction_View
    private static final String TABLE_TRANSACTION_VIEW = "transactionView";
    private static final String COLUMN_TRANS_VIEW_TRANSACTION_ID = "transaction_ID";
    private static final String COLUMN_TRANS_VIEW_ACCOUNT_NUMBER = "account_Number";
    private static final String COLUMN_TRANS_VIEW_BRANCH_NAME = "branch_Name";
    private static final String COLUMN_TRANS_VIEW_DATE = "date";
    private static final String COLUMN_TRANS_VIEW_TIME = "time";
    private static final String COLUMN_TRANS_VIEW_EMPLOYEE_LAST_NAME = "last_Name";
    private static final String COLUMN_TRANS_VIEW_AMOUNT = "amount";

    /**
     * DB Query
     */
    private static final String QUERY_TRANSACTION_TYPE_ID =
            "SELECT " + TABLE_TRANSACTION_TYPE + "." + COLUMN_TRANS_TYPE_ID +
                    " FROM " + TABLE_TRANSACTION_TYPE +
                    " WHERE " + TABLE_TRANSACTION_TYPE + "." + COLUMN_TRANS_TYPE_NAME + "=?";

    private static final String QUERY_ACCOUNT_ID =
            "SELECT " + TABLE_ACCOUNT + "." + COLUMN_ACCOUNT_ID +
                    " FROM " + TABLE_ACCOUNT +
                    " WHERE " + TABLE_ACCOUNT + "." + COLUMN_ACCOUNT_NUMBER + "=?";

    private static final String QUERY_BRANCH_ID =
            "SELECT " + TABLE_BRANCH + "." + COLUMN_BRANCH_ID +
                    " FROM " + TABLE_BRANCH +
                    " WHERE " + TABLE_BRANCH + "." + COLUMN_BRANCH_NAME + "=?";

    private static final String QUERY_EMPLOYEE_ID =
            "SELECT " + TABLE_EMPLOYEE + "." + COLUMN_EMPLOYEE_ID +
                    " FROM " + TABLE_EMPLOYEE +
                    " WHERE " + TABLE_EMPLOYEE + "." + COLUMN_EMPLOYEE_LAST_NAME + "=?";
    // Query transaction amount sum
    private static final String QUERY_TRANSACTIONS_AMOUNT_SUM =
            "SELECT SUM("+COLUMN_TRANS_VIEW_AMOUNT+")"+
                    " FROM "+TABLE_TRANSACTION_VIEW+
                    " WHERE "+TABLE_TRANSACTION_VIEW+"."+COLUMN_TRANS_VIEW_ACCOUNT_NUMBER+"=?";

    // Query account number by customer name
    private static final String QUERY_ACCOUNT_NUMBER_BY_NAME =
            "SELECT " + TABLE_ACCOUNT + "." + COLUMN_ACCOUNT_NUMBER +
                    " FROM " + TABLE_ACCOUNT +
                    " INNER JOIN " + TABLE_CUSTOMER +
                    " WHERE " + TABLE_CUSTOMER + "." + COLUMN_CUSTOMER_FIRST_NAME + "=?" +
                    " AND " + TABLE_CUSTOMER + "." + COLUMN_CUSTOMER_LAST_NAME + "=?" +
                    " AND " + TABLE_CUSTOMER + "." + COLUMN_CUSTOMER_ID + " = " + TABLE_ACCOUNT + "." + COLUMN_ACCOUNT_CUSTOMER_ID;
    // Query all transactions by account number
    private static final String QUERY_TRANSACTION_VIEW =
            "SELECT *"+
                    " FROM "+TABLE_TRANSACTION_VIEW+
                    " WHERE "+TABLE_TRANSACTION_VIEW+"."+COLUMN_TRANS_VIEW_ACCOUNT_NUMBER+"=?";
    // Insert new transaction
    private static final String INSERT_NEW_TRANSACTION =
            "INSERT INTO " + TABLE_TRANSACTION + " (" +
                    COLUMN_TRANSACTION_ACCOUNT_ID + "," +
                    COLUMN_TRANSACTION_BRANCH_ID + "," +
                    COLUMN_TRANSACTION_TYPE_ID + "," +
                    COLUMN_TRANSACTION_DATE + "," +
                    COLUMN_TRANSACTION_TIME + "," +
                    COLUMN_TRANSACTION_EMPLOYEE_ID + "," +
                    COLUMN_TRANSACTION_AMOUNT +
                    ") VALUES(?,?,?,?,?,?,?)";

    private Connection connection;

    private PreparedStatement queryTransactionTypeID;
    private PreparedStatement queryAccountID;
    private PreparedStatement queryBranchID;
    private PreparedStatement queryEmployeeID;
    private PreparedStatement queryTransactionsAmountSum;
    private PreparedStatement queryTransactionView;
    private PreparedStatement queryAccountNumberByName;
    private PreparedStatement insertTransaction;

    // Open Connection
    public boolean open() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);

            queryTransactionTypeID = connection.prepareStatement(QUERY_TRANSACTION_TYPE_ID);
            queryAccountID = connection.prepareStatement(QUERY_ACCOUNT_ID);
            queryBranchID = connection.prepareStatement(QUERY_BRANCH_ID);
            queryEmployeeID = connection.prepareStatement(QUERY_EMPLOYEE_ID);
            queryTransactionsAmountSum = connection.prepareStatement(QUERY_TRANSACTIONS_AMOUNT_SUM);
            queryTransactionView = connection.prepareStatement(QUERY_TRANSACTION_VIEW);
            queryAccountNumberByName = connection.prepareStatement(QUERY_ACCOUNT_NUMBER_BY_NAME);
            insertTransaction = connection.prepareStatement(INSERT_NEW_TRANSACTION, Statement.RETURN_GENERATED_KEYS);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            e.getMessage();
            return false;
        }
    }

    // Close Connection
    public void close() {
        try {
            if (queryTransactionTypeID != null) {
                queryTransactionTypeID.close();
            }
            if (queryAccountID != null) {
                queryAccountID.close();
            }
            if (queryBranchID != null) {
                queryBranchID.close();
            }
            if (queryEmployeeID != null) {
                queryEmployeeID.close();
            }
            if (queryTransactionsAmountSum != null){
                queryTransactionsAmountSum.close();
            }
            if (queryTransactionView != null) {
                queryTransactionView.close();
            }
            if (queryAccountNumberByName != null) {
                queryAccountNumberByName.close();
            }
            if (insertTransaction != null) {
                insertTransaction.close();
            }

            // Close Connection
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public int queryTransactionTypeID(String type) throws Exception {
        queryTransactionTypeID.setString(1, type);
        ResultSet resultSet = queryTransactionTypeID.executeQuery();

        int typeID = resultSet.getInt(1);
        return typeID;
    }

    public int queryAccountID(int accountNumber) throws Exception {

        queryAccountID.setInt(1, accountNumber);
        ResultSet resultSet = queryAccountID.executeQuery();

        int accountID = resultSet.getInt(1);
        return accountID;

    }

    public int queryBranchID(String branchName) throws Exception {

        queryBranchID.setString(1, branchName);
        ResultSet resultSet = queryBranchID.executeQuery();

        int branchID = resultSet.getInt(1);
        return branchID;

    }

    public int queryEmployeeID(String lastName) throws Exception {

        queryEmployeeID.setString(1, lastName);
        ResultSet resultSet = queryEmployeeID.executeQuery();

        int employeeID = resultSet.getInt(1);
        return employeeID;

    }
    public double queryAccountBalance(){
        try{
            queryTransactionsAmountSum.setInt(1,12300001);
            ResultSet resultSet = queryTransactionsAmountSum.executeQuery();
            double balance = resultSet.getDouble(1);
            return balance;
        }catch (SQLException e){
            System.out.println("Query failed: " + e.getMessage());
            return -1;
        }
    }
    public List<TransactionView> queryTransactionView(int accountNumber){
        try{
            queryTransactionView.setInt(1,accountNumber);

            ResultSet resultSet = queryTransactionView.executeQuery();
            List<TransactionView> transactionViewList = new ArrayList<>();
            while(resultSet.next()){
                TransactionView transactionView = new TransactionView();
                transactionView.setTransaction_ID(resultSet.getInt(1));
                transactionView.setAccount_Number(resultSet.getInt(2));
                transactionView.setBranch_Name(resultSet.getString(3));
                transactionView.setTrans_Date(resultSet.getString(4));
                transactionView.setTrans_Time(resultSet.getString(5));
                transactionView.setEmployee_LastName(resultSet.getString(6));
                transactionView.setAmount(resultSet.getDouble(7));
                transactionViewList.add(transactionView);
            }
            return transactionViewList;

        }catch (SQLException e){
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
    public int queryAccountNumberByName(String firstName, String lastName) {
        try {
            queryAccountNumberByName.setString(1, firstName);
            queryAccountNumberByName.setString(2, lastName);
            ResultSet resultSet = queryAccountNumberByName.executeQuery();

            int accountNumber = resultSet.getInt(1);
            return accountNumber;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return -1;
        }
    }

    public void insertNewTransaction(int accountNumber, String branchName, String transactionType, String transDate, String transTime, String employeeLastName, double amount) {
        try {
            int accountId = queryAccountID(accountNumber);
            int branchId = queryBranchID(branchName);
            int transTypeId = queryTransactionTypeID(transactionType);
            int employeeId = queryEmployeeID(employeeLastName);

            connection.setAutoCommit(false);
            insertTransaction.setInt(1, accountId);
            insertTransaction.setInt(2, branchId);
            insertTransaction.setInt(3, transTypeId);
            insertTransaction.setString(4, transDate);
            insertTransaction.setString(5, transTime);
            insertTransaction.setInt(6, employeeId);
            insertTransaction.setDouble(7, amount);

            int affectedRows = insertTransaction.executeUpdate();
            if (affectedRows == 1) {
                System.out.println("Transaction Insert Succeed");
                connection.commit();
            } else {
                throw new SQLException("The transaction insert failed");
            }

        } catch (Exception e) {
            System.out.println("Insert Transaction exception: " + e.getMessage());
            try {
                System.out.println("Performing rollback");
                connection.rollback();
            } catch (SQLException e2) {
                System.out.println("Oh boy! Things are really bad! " + e2.getMessage());
            } finally {
                try {
                    System.out.println("Resetting default commit behavior");
                    connection.setAutoCommit(true);
                } catch (SQLException e1) {
                    System.out.println("Couldn't reset auto-commit! " + e1.getMessage());
                }
            }
        }
    }
}
