package com.taskmanager.operations;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.taskmanager.core.TASKSTATUS;
import com.taskmanager.core.TaskManager;

public class TaskOperationsImpl implements TaskOperations {
	private Map<Integer,TaskManager> TaskMap;
//	TaskManager task = new TaskManager();
	public TaskOperationsImpl() {
		TaskMap = new HashMap<>();
	}
	
//	@Override
//	public void acceptTask(String taskName, String taskDesc, String taskDate) {
//		LocalDate date = LocalDate.parse(taskDate);
//		TaskMap.put(task.getTaskId(),new TaskManager(taskName, taskDesc, date, TASKSTATUS.PENDING, true)); 
//		System.out.println("Task Added Successfully");
//	}
	@Override
	public void acceptTask(String taskName, String taskDesc, String taskDate) {
		LocalDate date = LocalDate.parse(taskDate);
		TaskManager ts =new TaskManager(taskName, taskDesc, date, TASKSTATUS.PENDING, true);
		TaskMap.put(ts.getTaskId(),ts); 
		System.out.println("Task Added Successfully");
	}
	
	@Override
	public void display() { 
		TaskMap.values().stream().forEach(i->System.out.println(i));
		
	}
	@Override
	public void updateTaskStatus(int taskid, String status) {
	TASKSTATUS ts = TASKSTATUS.valueOf(status.toUpperCase());
	TaskMap.values().stream().filter(t->t.getTaskId()==taskid).forEach(i->i.setStatus(ts));	
	}
	
	
	@Override
	public void displayAllPendingStatus() {
		TaskMap.values().stream().filter(t->t.getStatus().equals(TASKSTATUS.PENDING)).forEach(System.out::println);
		
	}
	
	@Override
	public void sortedbytaskdate() {
		TaskMap.values().stream().sorted(Comparator.comparing(TaskManager::getTaskDate)).forEach(i->System.out.println(i));;		
	}
	
	
}
