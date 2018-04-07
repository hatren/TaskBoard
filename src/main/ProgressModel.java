package main;

import java.util.ArrayList;
import java.util.Collections;

public class ProgressModel implements Comparable<ProgressModel>{
	// Variables
	String name;
	int priority;
	ArrayList<TaskModel> taskList;
	
	// Constructor
	public ProgressModel(String name, int priority) {
		this.name = name;
		this.priority = priority;
		taskList = new ArrayList<TaskModel>();
	}
	
	// Getters
	public String getName() {
		return name;
	}
	
	public int getPriority() {
		return priority;
	}
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	// Add new task and sort based on comparable
	public void addTask(TaskModel task) {
		taskList.add(task);
		Collections.sort(taskList);
	}
	
	// Remove old task and sort based on comparable
	public void removeTask(TaskModel task) {
		taskList.remove(task);
		Collections.sort(taskList);
	}

	@Override
	public int compareTo(ProgressModel arg0) {
		if(this.getPriority() > arg0.getPriority()) {
			return 1;
		}
		else if(this.getPriority() < arg0.getPriority()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
