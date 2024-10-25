package com.stylewithpen.tester;

import java.util.Scanner;

import com.stylewithpen.operations.PenOperationsImpl;

public class TestPen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean exit = false;
		try(Scanner sc = new Scanner(System.in)){
			PenOperationsImpl ops = new PenOperationsImpl();
			while(!exit) {
				System.out.println("1. Add Pen\n2. Update stock of a Pen\n"
						+ "3. Set discount of 20% for all the pens which are not at all sold in last 3 months"
						+ "\n4. Remove Pens which arenever sold once listed in 9 months\nEnter Choice\n");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter brand,color,ink,material,stock,price");
						ops.addPen(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
						break;
					case 2:
						System.out.println("Enter id, quantity");
						ops.updateStock(sc.nextInt(), sc.nextInt());
						break;
					case 3:
						System.out.println("Enter discount");
						ops.setDiscount(sc.nextDouble());
						break;
					case 4:
						System.out.println("Removing products not sold till 9 months");
						ops.removePens();
						break;
					case 5:
						System.out.println("All stock");
						ops.display();
						break;
					default:
						break;
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
				
			}
		}
	}

}
