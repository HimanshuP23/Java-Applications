package com.mymess.validation;
import java.time.LocalDate;
import java.util.Map;

import com.mymess.core.Customer;
import com.mymess.core.MESSPLAN;
import com.mymess.custom_exception.MessException;

public class validation {

	
	public static void validateDuplicates(String email,Map<Integer, Customer> cust) throws MessException {
		if(cust.containsKey(email)) {
			throw new MessException("Customer Id already Exists");
		}
	}
	 public static void validatelogindetails(String emailid, String Password)throws MessException {
		 if(!emailid.matches("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")) {
			 throw new MessException("Email does not matches the given format");
		 }
		 
		 if(Password.isEmpty())
			 throw new MessException("Password section is blank");
	 }
	 
	 public static MESSPLAN validateMessPlan(String plan, double final_amount) throws MessException {
		 MESSPLAN mplan;
		    	mplan = MESSPLAN.valueOf(plan.toUpperCase());
		         // Convert plan string to enum, e.g., "monthly" -> MESSPLAN.MONTHLY
		    
		    
		    if(final_amount != mplan.getMessfees())
		    	throw new MessException("Invalid registration amount");
		return mplan;		    
		}

	 

	 	
//	 c) ParseValidatePlan , registration amount must be match with plan
//	 public static MESSPLAN validateMessPlan(String plan, double regsamt)throws MessException {
//		 MESSPLAN plans = MESSPLAN.valueOf(plan.toUpperCase());
//		 if(plans.getMessfees()!=regsamt)
//			 throw new MessException(" Invalid plan and fees");
//		return plans;
//	 }
	 /*
	  * Parse local Date
		registration date can be only todays date or after todays date and end 
		date must be depend on plan selected
		e.g if user reg date is 11/10/2023 and selected plan is of 1 year then end date 
		set automatically as 11/12/2024
	  */
	 
	 public static void validateDate(String regdate) throws MessException {
		 LocalDate date = LocalDate.parse(regdate);
		 if(date.isBefore(LocalDate.now()))
			 throw new MessException("Invalid date");
	 }
	 
//	 e) Phone number must be only 10 character and the number could be between 
//	 0 to 9.
	 public static void validatePhoneNo(String phoneno) throws MessException {
		 if(!phoneno.matches("^\\d{10}$"))
			 throw new MessException("Invalid Phone number");
	 }

}
