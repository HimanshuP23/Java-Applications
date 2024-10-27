package com.mybank.operations;

import com.mybank.core.BankAccount;
import com.mybank.core.BankAccountType;
import com.mybank.custom.exception.BankingException;
import static com.mybank.validation.BankingValidation.*;
import java.time.LocalDate;
import java.util.Scanner;

public class BankingOperationsImpl implements BankOperations{
    BankAccount[] accounts;
    int counter =0;
    Scanner sc = new Scanner(System.in);

    public BankingOperationsImpl(int i) {
    }

    // Constructor creation
    public void BankOperationsImpl(int size)
    {
        accounts = new BankAccount[size];
    }

    @Override
    public String openAccount(int accountNo, String accountType, String customerFirstName,
                            String customerLastName, double balance, String dob) throws BankingException{

        // Validate the balance whether it is in minimum limits or not
        BankAccountType type = bankingValidation(accountType,balance);
        // Validate the age of the account opener
        LocalDate date = ageValidation(dob);

        accounts[counter++] = new BankAccount(accountNo,type,customerFirstName,customerLastName,balance,date);


        return " ";
    }

    @Override
    public void displayAllDetails() {
        if(counter<0) {
            for (BankAccount bk : accounts) {
                System.out.println(bk);
            }
        }
    }

    @Override
    public void displaySummary(int accountNo)throws BankingException {
        for(BankAccount bk : accounts) {
            if (counter < 0 && bk.getAccountNo()==accountNo) {
                System.out.println(bk);
                break;
            }
            else
                throw new BankingException("Invalid Account Number");
        }
    }


    @Override
    public void depositAmount(int accountno ,double amount) throws BankingException {
        System.out.println("Depositing Amount");
        BankAccount accountNo = new BankAccount(accountno);
        for(BankAccount bk :accounts){
            if(bk!=null && bk.equals(accountNo)){
                double balance,current_balance;
                balance = bk.getBalance();
                current_balance = balance+amount;
                System.out.println("Amount Deposited Successfully\n Your current balance is: "+ current_balance);
            }
            else
                throw new BankingException("Invalid Account Number");
        }
    }

    @Override
    public void withdrawAmount(int accountno,double amount)throws BankingException {
        System.out.println("Withdrawing Amount");
        BankAccount accountNo = new BankAccount(accountno);
        for(BankAccount bk :accounts){
            if(bk!=null && bk.equals(accountNo)){
                double balance,current_balance;
                balance = bk.getBalance();
                current_balance = balance+amount;
                System.out.println("Amount Deposited Successfully\n Your current balance is: "+ current_balance);
            }
            else
                throw new BankingException("Invalid Account Number");
        }
    }

    @Override
    public void fundTransfer(int accountNo, double amount) {
        System.out.println("Fund transfer in process");
        BankAccount account = new BankAccount(accountNo);
        for(BankAccount bk :accounts){
            // for fund transfer

        
        }
    }
}
