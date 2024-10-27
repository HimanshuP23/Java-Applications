package com.mybank.tester;

import java.time.LocalDate;
import java.util.Scanner;
import com.mybank.core.*;
import com.mybank.operations.*;


public class testbank {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter max no of accounts");
            BankOperations ops = new BankingOperationsImpl(sc.nextInt());
            boolean exit = false;
            while (!exit) {
                System.out.println("Options 1. Open A/C \n"
                        + "2. Display all \n"
                        + "3. Fetch A/c Summary \n"
                        + "4. Deposit Money \n"
                        + "5. Withdraw Money \n"
                        + "6. Fund Transfer \n"
                        + "0. Exit");
                System.out.println("Choose option");
                try {
                    switch (sc.nextInt()) {
                        case 1:
                            //(int accountNo, String accountType, String customerFirstName,
                            //                     String customerLastName, double balance, String dob)
                            System.out.println(
                                    "Enter a/c details -  " + "acctNo, acType,  balance,  firstName ,lastName,	dob");
                            System.out.println(ops.openAccount(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next()));
                            break;
                        case 2: // display all
                            ops.displayAllDetails();
                            break;
                        case 3: //fetch particular a/c summary
                            System.out.println("Enter a/c no ");
                            ops.displaySummary(sc.nextInt());
                            break;
                        case 4:
                            System.out.print("Enter the account number and amount to be deposited: ");
                            ops.depositAmount(sc.nextInt(),sc.nextDouble());
                            break;
                        case 5:
                            System.out.println("Enter the account Number and amount to be withdrawn");
                            ops.withdrawAmount(sc.nextInt(),sc.nextDouble());
                            break;
                        case 0:
                            exit = true;
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    sc.nextLine();//to read off pending input tokens from the scanner
                }
            }

        }

    }
}
