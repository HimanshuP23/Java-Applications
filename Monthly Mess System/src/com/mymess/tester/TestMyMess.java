package com.mymess.tester;

import java.util.Scanner;

import com.mymess.operations.mymessOperations;
import com.mymess.operations.mymessOperationsImpl;

public class TestMyMess {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			mymessOperations ops = new mymessOperationsImpl();
			boolean exit = false;
			
			while(!exit) {
				System.out.println("Options \n"
						+ "1.Sign UpCustomer \n"
						+ "2.Display Details \n"
						+ "3. Sign In \n"
						+ "4. Change Password \n"
						+ "5.Sorting by first name \n"
						+ "6.Sorting by plan \n"
						+ "7.Sorting by registration date \n"
						+ "8.Unsubscribe \n"
						+ "9.Modify all customers first name (make first Letter capital of customer’s first  name) \n"
						+ "10.Display emails of all customers \n"
						+ "11.Display count for the customer who had registered for the monthly plan \n"
						+ "12. Search the Customer who lived in Mumbai \n"
						+ "13.Seting discount \n"
						+ "0.Exit");
				System.out.println("Enter your choice: ");
				try{switch(sc.nextInt()) {
				case 1:
					System.out.println("Enter the customer details to sign up ( firstName, lastName, email, password, address, regdate, phoneNo, plans, final_amount)");
					ops.signupCustomer(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),sc.next(), sc.next(), sc.next(), sc.nextDouble());
					break;
				case 2:
					System.out.println("Displaying the details");
					ops.display();
					break;
				case 3:
					System.out.println("Enter your email and password to log-in");
					ops.signin(sc.next(), sc.next());
					break;
				case 4:
					System.out.println("Enter email old password andd new password ");
					ops.changepassword(sc.next(),sc.next(), sc.next());
					break;
				case 5:
					System.out.println("Sorting by first name");
					ops.sortbyfname();
					break;
				case 6: 
					System.out.println("Sorting by plan");
					ops.sortbyplan();
					break;
				case 7:
					System.out.println("Sorting by registration date");
					ops.sortbyregdate();
					break;
				case 8:
					System.out.println("Enter months");
					ops.unsubscribe(sc.nextInt());
					break;
				case 9:
					System.out.println("Modifying the first name");
					ops.modifyFname();
					break;
				case 10:
					System.out.println("Displaying Emails of all customer");
					ops.displayEmail();
					break;
				case 11:
					System.out.println("Displaying the count of customers who had registered for monthly plan");
					ops.displaycount();
					break;
				case 12: 
					System.out.println("displaying the customers who stayed in mumbai");
					ops.displaySeraching();
					break;
				case 13:
					System.out.println("Applying Discount");
					ops.setdiscount();
					break;
				}
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		
			
		}

	}

}
