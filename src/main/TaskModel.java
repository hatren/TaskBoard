package main;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TaskModel implements Comparable<TaskModel>, Serializable{
	// Variables
	private String name;
	private String description;
	private Calendar dueDate;
	private String status;
	
	// Constructor
	public TaskModel(String name, String description, Calendar dueDate, String status) {
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
		this.status = status;
	}

	// Getters
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Calendar getDate() {
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
	
	public void setDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}
	
	//TODO This variable should correspond to the ProgressModel it is contained in
	public void setStatus(String status) {
		this.status = status;
	}
	
	// For sort()
	public int compareTo(TaskModel arg0) {
		if(dueDate.before(arg0.dueDate)) {
			return -1;
		}
		else if(dueDate.after(arg0.dueDate)) {
			return 1;
		}
		else return this.name.compareTo(arg0.getName());
	}
	
	public String toString() {
		SimpleDateFormat format1 = new SimpleDateFormat("MM-dd-yyyy");
		String formatted = format1.format(dueDate.getTime());
		return formatted;
	}
	
	public static void main(String[] args) {
		Calendar c = new GregorianCalendar();
		Date date = new Date();
		c.setTime(date);
		TaskModel tm = new TaskModel("title shit","descriptive shit",c,"some shiz");
		System.out.println(tm);
	}
}
