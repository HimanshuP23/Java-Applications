package com.mybank.operations;

import com.mybank.core.BankAccountType;
import com.mybank.custom.exception.BankingException;

import javax.swing.text.BadLocationException;
import java.time.LocalDate;

public interface BankOperations{
    String openAccount(int accountNo, String accountType, String customerFirstName,
                     String customerLastName, double balance, String dob) throws BankingException;
    void displayAllDetails();
    void displaySummary(int accountNo) throws BankingException;
    void depositAmount(int accountNo,double amount)throws BankingException;
    void withdrawAmount(int accoutNo,double amount)throws BankingException;
    void fundTransfer(int accountNo, double amount);
}
