package com.mybank.validation;
import com.mybank.core.BankAccountType;
import com.mybank.custom.exception.BankingException;
import java.time.LocalDate;
import java.time.Period;

public class BankingValidation {

    private static int MIN_AGE;
    static {
        MIN_AGE = 18;
    }

    // Method for validating the bank balance
    public static BankAccountType bankingValidation(String name, double balance) throws BankingException{
        // string is parsed to enum
        BankAccountType type = BankAccountType.valueOf(name.toUpperCase());
        if(balance< type.getMIN_BALANCE()){
            throw new BankingException("Low Balance");
        }
        return type;
    }

    // Method for validating the age for opening account
    public static LocalDate ageValidation(String dob) throws BankingException{
        // Parse the dob String->Date
        LocalDate date  = LocalDate.parse(dob);
        // Date to age
        int age = Period.between(date,LocalDate.now()).getYears();
        if(age<MIN_AGE){
            throw new BankingException("Age not valid for opening the account");
        }
        return date;
    }
}
