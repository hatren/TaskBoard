package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ProgressView extends JPanel{
	// Variables
	private ProgressModel model;
	private ArrayList<TaskView> taskList;
	private JTextField status;
	private JButton addTaskButton;
	
	// Constructor
	public ProgressView(ProgressModel model) {
		// Initialize
		this.model = model;
		
		/*project.setLayout(new BoxLayout(project, BoxLayout.Y_AXIS));
		project.setBackground(Color.RED);
		project.setMaximumSize(new Dimension(300, 1000));
		JTextField textfield = new JTextField("Project " + i);
		textfield.setPreferredSize(new Dimension(100, 100));
		textfield.setBackground(Color.BLUE);
		textfield.setMaximumSize(
			     new Dimension(100, 100) );
		project.add(textfield); */
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.RED);
		this.setMaximumSize(new Dimension(300, 1000));
		
		// Add Status Text
		status = new JTextField(model.getStatus());
		add(status);
		
		/*  Add TaskViews
		taskList = new ArrayList<TaskView>();
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
