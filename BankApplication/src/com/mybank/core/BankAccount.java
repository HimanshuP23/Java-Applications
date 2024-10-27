package com.mybank.core;

import java.time.LocalDate;

public class BankAccount {
    private int accountNo;
    //Has-a relationship (BankAccount HAS-A BankAccountType)
    private BankAccountType accountType;
    private String customerFirstName;
    private String customerLastName;
    private double balance;
    private LocalDate dob;

    public BankAccount(int accountNo,BankAccountType accountType, String customerFirstName, String customerLastName, double balance, LocalDate dob) {
        this.accountNo = accountNo;
        this.accountType = accountType;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.balance = balance;
        this.dob = dob;
    }

    public BankAccount(int accountNo) {
        this.accountNo = accountNo;
    }


    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNo=" + accountNo +
                ", accountType=" + accountType +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", balance=" + balance +
                ", dob=" + dob +
                '}';
    }

    @Override
    public boolean equals(Object anotherObject) {
        return this.accountNo==((BankAccount)anotherObject).accountNo;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
