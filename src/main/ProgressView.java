package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ProgressView extends JPanel{
	// Variables
	private ProgressModel model;
	private ArrayList<TaskView> taskList;
	private JTextArea status;
	private JButton addTaskButton;
	
	// Constructor
	public ProgressView(ProgressModel model) {
		// Initialize
		this.model = model;
		
		// Add Status Text
		status = new JTextArea(model.getStatus());
		add(status);
		
		// Add TaskViews
		taskList = new ArrayList<TaskView>();
		for(TaskModel task: this.model.getTaskList()) {
			addTask(task);
		}
		
		addTaskButton = new JButton();
		addTaskButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateTaskView createTaskView = new CreateTaskView((ProgressView) addTaskButton.getParent());
			}
		});
		add(addTaskButton);
		
		
		// Test Border
		this.setBorder(BorderFactory.createEtchedBorder());
	}
	
	// addTask
	public void addTask(TaskModel model) {
		this.model.addTask(model);
		TaskView taskView = new TaskView(model);
		taskList.add(taskView);
		add(taskView);
	}
	
	// removeTask
	public void removeTask(TaskView view) {
//		taskList.remove(view);
//		remove(view);
	}
}
