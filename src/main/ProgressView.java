package main;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ProgressView extends JPanel{
	// Variables
	private ProgressModel model;
	private ArrayList<TaskView> taskList;
	private JTextArea status;
	
	// Constructor
	public ProgressView(ProgressModel model) {
		// Initialize
		this.model = model;
		
		// Add Status Text
		status = new JTextArea(model.getStatus());
		this.add(status);
		
		// Add TaskViews
		for(TaskModel task: this.model.getTaskList()) {
			TaskView taskView = new TaskView(task);
			taskList.add(taskView);
			this.add(taskView);
		}
	}
	
	// addTask
	public void addTask(TaskView view) {
		this.add(view);
	}
	
	// removeTask
	public void removeTask(TaskView view) {
		this.remove(view);
	}
}
