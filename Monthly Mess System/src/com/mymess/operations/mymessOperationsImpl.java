package com.mymess.operations;

import static com.mymess.validation.validation.validateDate;
import static com.mymess.validation.validation.validateDuplicates;
import static com.mymess.validation.validation.validateMessPlan;
import static com.mymess.validation.validation.validatePhoneNo;
import static com.mymess.validation.validation.validatelogindetails;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.mymess.core.Customer;
import com.mymess.core.MESSPLAN;
import com.mymess.custom_exception.MessException;

public class mymessOperationsImpl implements mymessOperations{

	Map<Integer, Customer> customerMap;

	public mymessOperationsImpl() {
		customerMap = new HashMap<>();
		
		customerMap.put(1, new Customer("Rajesh", "Sharma", "rajesh.sharma@gmail.com", "rajesh", "Mumbai", 
			    LocalDate.of(2024, 10, 25), LocalDate.of(2025, 1, 25), "9876512345", MESSPLAN.QUARTERLY, 11700));

			customerMap.put(2, new Customer("Sneha", "Gupta", "sneha.gupta@gmail.com", "sneha", "Delhi", 
			    LocalDate.of(2024, 11, 10), LocalDate.of(2025, 11, 10), "9876549876", MESSPLAN.YEARLY, 32000));

			customerMap.put(3, new Customer("Priya", "Mehta", "priya.mehta@gmail.com", "priya", "Mumbai", 
			    LocalDate.of(2024, 11, 5), LocalDate.of(2024, 12, 5), "9876524680", MESSPLAN.MONTHLY, 3000));

			customerMap.put(4, new Customer("Amit", "Verma", "amit.verma@gmail.com", "amit", "Kolkata", 
			    LocalDate.of(2024, 7, 1), LocalDate.of(2024, 10, 1), "9876535791", MESSPLAN.QUARTERLY, 11700));

			customerMap.put(5, new Customer("Neha", "Kapoor", "neha.kapoor@gmail.com", "neha", "Mumbai", 
			    LocalDate.of(2024, 12, 20), LocalDate.of(2025, 1, 20), "9876567892", MESSPLAN.MONTHLY, 3000));

			customerMap.put(6, new Customer("Arjun", "Singh", "arjun.singh@gmail.com", "arjun", "Chandigarh", 
			    LocalDate.of(2024, 6, 18), LocalDate.of(2025, 6, 18), "9876578903", MESSPLAN.YEARLY, 32000));		
	}
	
	@Override
	public void signupCustomer(String firstName, String lastName, String email, String password, String address, String phoneNo,
			String plan, String registrationDate, double final_amount)  throws MessException {
		
		 validateDuplicates( email ,customerMap);
		 validateDate(registrationDate);
		 validatelogindetails(email, password);
		 MESSPLAN plans = validateMessPlan(plan, final_amount);
		 validatePhoneNo(phoneNo);
		 LocalDate regdate = LocalDate.parse(registrationDate);
		 LocalDate enddate = regdate.plusMonths(plans.getMonth());
		 
		 Customer c = new  Customer(firstName, lastName, email, password, address,regdate, enddate, phoneNo, plans, final_amount);
		 customerMap.put( c.getCustomer_id(),c);
	}
	
	@Override
	public void display() {
		customerMap.values().forEach(i->System.out.println(i));
	}


	@Override
	public void signin(String email, String password) throws MessException{
		Optional<Customer> optinalCustomer = customerMap.values().stream()
				.filter(p->p.getPassword().equals(password))
				.filter(s->s.getEmail().equals(email))
				.findFirst();
		
		if(optinalCustomer.isPresent()) {
			optinalCustomer.ifPresent(c->System.out.println("Successfully loged in"));
		}
		else
			throw new MessException("Invalid details");
	}
	
	@Override
	public void changepassword(String email, String oldpassword, String newPassword)throws MessException {
		validatelogindetails(email, newPassword);
		customerMap.values().stream().filter(p->p.getEmail().equals(email)).filter(s->s.getPassword().equals(oldpassword)).forEach(i->i.setPassword(newPassword));
	}
	
	@Override
	public void sortbyfname() {
		customerMap.values().stream().sorted(Comparator.comparing(Customer::getFirstName)).forEach(i->System.out.println(i));
	}
	
	@Override
	public void sortbyplan() {
		customerMap.values().stream().sorted(Comparator.comparing(Customer::getPlan)).forEach(i->System.out.println(i));
	}
	@Override
	public void sortbyregdate() {
		customerMap.values().stream().sorted(Comparator.comparing(Customer::getRegistrationDate)).forEach(i->System.out.println(i));
	}
	@Override
	public void unsubscribe(int month) {
		customerMap.values().removeIf(s->s.getPlan().getMonth()==month);
	}
	@Override
	public void modifyFname() {
//		customerMap.values().forEach(i->i.getFirstName().substring(0, 1).toUpperCase()+c.getFirstName().substring(1);));
		for(Customer c : customerMap.values()) {
			String s = c.getFirstName().substring(0, 1).toUpperCase() + c.getFirstName().substring(1);
			c.setFirstName(s);
		}
	}
	@Override
	public void displayEmail() {
		customerMap.values().stream().filter(c->c.getRegistrationDate().getMonth().name().equals("JANUARY"))	.forEach(i->System.out.println(i.getEmail()));
	}
	@Override
	public void displaycount() {
		long count = customerMap.values().stream().filter(c->c.getPlan().equals(MESSPLAN.MONTHLY)).count();
		System.out.println(count);
	}
	@Override
	public void displaySeraching() {
		customerMap.values().stream().filter(c->c.getAddress().equals("Mumbai")).forEach(i->System.out.println(i));		
	}
	
	@Override
	public void setdiscount() {
	customerMap.values().stream().filter(c->c.getPlan().equals(MESSPLAN.YEARLY)).forEach(i->i.setFinal_amount(i.getFinal_amount()*0.80));
	}

}
