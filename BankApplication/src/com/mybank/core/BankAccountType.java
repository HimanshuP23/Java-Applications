package com.mybank.core;

public enum BankAccountType {
    SAVING(10000),CURRENT(5000),FD(50000),LOAN(25000);
    // CAN WRITE ; OR NOT IT IS OPTIONAL
    private double MIN_BALANCE;

    private BankAccountType(double minBalance){
        this.MIN_BALANCE=minBalance;
    }

    public double getMIN_BALANCE() {
        return MIN_BALANCE;
    }
}
