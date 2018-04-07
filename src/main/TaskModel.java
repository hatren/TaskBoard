package main;

import java.util.Date;

public class TaskModel implements Model, Comparable<TaskModel>{
	String name;
	String description;
	Date dueDate;
	
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
}
