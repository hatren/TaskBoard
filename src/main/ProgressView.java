package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ProgressView extends JPanel implements Comparable<ProgressView>{
	// Variables
	private ProgressModel model;
	private ArrayList<TaskView> taskList;
	private JTextField status;
	private JButton addTaskButton;
	
	// Constructor
	public ProgressView(ProgressModel model) {
		// Initialize
		this.model = model;
		
		// Add Status Text
		status = new JTextField(model.getStatus());
		add(status);
		
		// Add TaskViews
		taskList = new ArrayList<TaskView>();
//		for(TaskModel task: this.model.getTaskList()) {
//			addTask(task);
//		}
		/*
		for(TaskModel task: this.model.getTaskList()) {
			addTask(task);
		}*/
		taskList = new ArrayList<TaskView>();
		for(int i = 0; i < this.model.getTaskList().size(); i++) {
			TaskView taskView = new TaskView(this.model.getTaskList().get(i));
			taskList.add(taskView);
			add(taskView);
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
		// Remove all
		for(TaskView view: taskList) {
			this.remove(view);
		}
		
		// Add
		this.model.addTask(model);
		TaskView taskView = new TaskView(model);
		taskList.add(taskView);
		
		// Sort ArrayList
		Collections.sort(taskList);
		
		// Add all
		for(TaskView view: taskList) {
			this.add(view);
		}
	}
	
	public ProgressModel getModel() {
		return model;
	}
	
	// removeTask
	public void removeTask(TaskView task) {
		// Remove Views From JPanel
		for(TaskView view: taskList) {
			this.remove(view);
		}
		
		// Remove and Sort ArrayList
		taskList.remove(task);
		Collections.sort(taskList);
		
		// Add all
		for(TaskView view: taskList) {
			this.add(view);
		}
	}

	@Override
	public int compareTo(ProgressView arg0) {	
		return this.getModel().compareTo(arg0.getModel());
	}
}
