package com.mybank.custom.exception;

public class BankingException extends Exception{
    public BankingException(String mesg){
        super(mesg);
    }
}
