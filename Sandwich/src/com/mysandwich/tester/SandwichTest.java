package com.mysandwich.tester;

import java.util.Scanner;

import com.mysandwich.operations.mysandwichOperations;
import com.mysandwich.operations.mysandwichOperationsImpl;

public class SandwichTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean exit = false;
		
		try(Scanner sc = new Scanner(System.in)){
			mysandwichOperations ops = new mysandwichOperationsImpl();
			
			while(!exit) {
				System.out.println("options \n"
						+ "1.Add Sandwich \n"
						+ "2.Display all details \n"
						+ "3.Searching the sandwich by its type \n"
						+ "4.Sorting by price \n"
						+ "5.filter sandwich by minprice \n"
						+ "6.Remove sandwich by name \n"
						+ "0.Exit");
				System.out.println("Enter your choice: ");
				
				try {
					switch(sc.nextInt()) {
					case 1:
						System.out.println("Add Sandwich details (sandwichId, name, type, price, description)");
						ops.addSandwich(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(), sc.next());
						break;
					case 2:
						System.out.println("Displaying all details");
						ops.display();
						break;
					case 3:
						System.out.println("Enter the type of the sandwich for searching: ");
						ops.SearchsandwichByType(sc.next());
						break;
					case 4:
						System.out.println("Sorting is done by the price");
						ops.sortingByPrice();
						break;
					case 5:
						ops.filterMethod();
						break;
					case 6:
						System.out.println("Enter the name of customer");
						ops.Remove(sc.next());
						break;
					}
					
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			}
		}
	}

}
