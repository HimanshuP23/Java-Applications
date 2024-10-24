package com.taskmanager.tester;
import com.taskmanager.operations.*;
import java.util.Scanner;

import com.taskmanager.operations.TaskOperations;


public class TestTask {

	public static void main(String[] args) {

		try(Scanner sc = new Scanner(System.in)){
			TaskOperationsImpl ops = new TaskOperationsImpl();
			boolean exit = false;
			
			while(!exit) {
				System.out.println("Options \n"
						+ "1.Add Task \n"
						+ "2.Display \n"
						+ "3.Update Task Status \n"
						+ "4.Display all pending status \n"
						+ "5.Display all pending task for today \n"
						+ "6.Display all task sorted by taskdate \n"
						+ "0.Exit");
				System.out.print("Enter Your choice: ");
				
				try {
					switch(sc.nextInt()) {
					case 1:
						System.out.println("Enter details to add task (taskName, taskDesc, taskDate,)");
						ops.acceptTask(sc.next(), sc.next(), sc.next());
						break;
					case 2:
						System.out.println("Displaying details");
						ops.display();
						break;
					case 3:
						System.out.println("Enter taskid and new status to update the status: ");
						ops.updateTaskStatus(sc.nextInt(), sc.next());
						break;
					case 4:
						System.out.println("Displaying the tasks which are pending");
						ops.displayAllPendingStatus();
						break;
					case 5:
						System.out.println();
					case 6:
						System.out.println("sorted by taskdate");
						ops.sortedbytaskdate();
						break;
				}
				}catch (Exception e) {
					System.out.println(e);
				}
			}
		}catch (Exception e) {
			System.out.println(e);
		}

	}

}
