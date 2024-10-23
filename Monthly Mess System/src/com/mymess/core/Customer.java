package com.mymess.core;

import java.time.LocalDate;

public class Customer {
/*
 * Customer id(int) , first name(String), last name (String), email(String),
password(String), Address String, RegisterDate(LocalDate),
planEndDate(LocalDate), Address(String), Phone No(String),plan Enum, 
final_amount double
Messplan(Plan : enum) Plans Are as follows:-
Monthly (3000), Quarterly (11700), Half Year (17500), Yearly (32000
 */
	private int customer_id;
	private static int id = 1;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String address;
	private LocalDate registrationDate;
	private LocalDate planEndDate;
	private String phoneNo;
	private MESSPLAN plan;
	private double final_amount;
	
	
	public Customer(String firstName, String lastName, String email, String password,String address,
			LocalDate registrationDate, LocalDate planEndDate, String phoneNo, MESSPLAN plan, double final_amount) {
		super();
		this.customer_id = id++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.registrationDate = registrationDate;
		this.planEndDate = planEndDate;
		this.phoneNo = phoneNo;
		this.plan = plan;
		this.final_amount = final_amount;
	}





	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", address=" + address + ", registrationDate="
				+ registrationDate + ", planEndDate=" + planEndDate + ", phoneNo=" + phoneNo + ", plan=" + plan
				+ ", final_amount=" + final_amount + "]";
	}


	public int getCustomer_id() {
		return customer_id;
	}


	

	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LocalDate getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}


	public LocalDate getPlanEndDate() {
		return planEndDate;
	}


	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public MESSPLAN getPlan() {
		return plan;
	}


	public void setPlan(MESSPLAN plan) {
		this.plan = plan;
	}


	public double getFinal_amount() {
		return final_amount;
	}


	public void setFinal_amount(double final_amount) {
		this.final_amount = final_amount;
	}
	
	
	
	
	
	
	
	
	
}
