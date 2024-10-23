package com.mymess.operations;

import java.time.LocalDate;

import com.mymess.core.MESSPLAN;
import com.mymess.custom_exception.MessException;

public interface mymessOperations {
	void signupCustomer( String firstName, String lastName, String email, String password, String address, String phone,
			String plan, String registerDate, double finalAmount) throws MessException;
	
	void display();
	
	void signin(String email, String password) throws MessException;
	
	void changepassword(String email, String oldpassword, String newPassword)throws MessException;
	
	void sortbyfname();
	void sortbyplan();
	void sortbyregdate();
	void unsubscribe(int month);
	void modifyFname();
	void displayEmail();
	void displaycount();
	void displaySeraching();
	void setdiscount();
}
