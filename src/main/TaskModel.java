package main;

import java.util.Date;

public class TaskModel implements Comparable<TaskModel>{
	// Variables
	String name;
	String description;
	Date dueDate;
	String status;
	
	// Constructor
	public TaskModel(String name, String description, Date dueDate, String status) {
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
		this.status = status;
	}
	
	// compareTo for Comparable
	@Override
	public int compareTo(TaskModel arg0) {
		if(dueDate.before(arg0.dueDate)) {
			return -1;
		}
		else if(dueDate.after(arg0.dueDate)) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	// Getters
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Date getDate() {
		return dueDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
