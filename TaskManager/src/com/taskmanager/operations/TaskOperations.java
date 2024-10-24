package com.taskmanager.operations;

import java.time.LocalDate;

import com.taskmanager.core.TASKSTATUS;

public interface TaskOperations {
	
	void acceptTask(String taskName, String taskDesc, String taskDate);
	void display();
	void updateTaskStatus(int taskid, String Status);
	void displayAllPendingStatus();
	void sortedbytaskdate();

}
