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
		this.add(new JTextArea(model.getStatus()));
		
		// Add TaskViews
		for(TaskModel task: model.getTaskList()) {
			TaskView taskView = new TaskView(task);
			taskList.add(taskView);
			this.add(taskView);
		}
	}
	
	// addTask
	
	
	// removeTask
}
