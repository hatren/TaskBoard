package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;

public class ProgressView extends JPanel implements Comparable<ProgressView>{
	// Variables
	private ProgressModel model;
	private ArrayList<TaskView> taskList;
	private JLabel status;
	
	private JPanel buttonPanel;
	private JButton addTaskButton;
	private JButton editProgressButton;
	private JButton deleteProgressButton;
	private JPanel taskPanel;
	private boolean on = false;
	int counter = 0;
	
	JPanel pan = this;
	ProgressView pan2 = this;
	
	// Constructor
	public ProgressView(ProgressModel model) throws BadLocationException {
		// Initialize
		this.model = model;
		
		
		
		this.setLayout(new BorderLayout());
		
		// Add Status Text
		status = new JLabel(model.getStatus());
		status.setHorizontalAlignment(JLabel.CENTER);
		status.setVerticalAlignment(JLabel.CENTER);
		//status.setBorder(BorderFactory.createLineBorder(Color.RED, 5)); 
		status.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/*counter++;
				if(counter % 2 == 1) {
					status.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
					getModel().setSelected(true);

				} else {
					status.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
					getModel().setSelected(false);
				}
				System.out.println("Mouseclick" + counter); */
				
			}
		});
		add(status, BorderLayout.NORTH);
		
		// Add TaskViews
		taskList = new ArrayList<TaskView>();
//		for(TaskModel task: this.model.getTaskList()) {
//			addTask(task);
//		}
		/*
		for(TaskModel task: this.model.getTaskList()) {
			addTask(task);
		}*/
		taskPanel = new JPanel();
		taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
		//taskPanel.setLayout(new FlowLayout());
		this.add(taskPanel, BorderLayout.CENTER);
		
		taskList = new ArrayList<TaskView>();
		for(int i = 0; i < this.model.getTaskList().size(); i++) {
			TaskView taskView = new TaskView(this.model.getTaskList().get(i));
			taskList.add(taskView);
			taskPanel.add(taskView);
		}
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,3));
		buttonPanel.setBorder(BorderFactory.createEtchedBorder());
		addTaskButton = new JButton("+");
		addTaskButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateTaskView createTaskView = new CreateTaskView(pan2);
			}
		});
		buttonPanel.add(addTaskButton);
		editProgressButton = new JButton("Edit");
		editProgressButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EditProgressView editProgressView = new EditProgressView(getThis());
			}
		});
		buttonPanel.add(editProgressButton);
		deleteProgressButton = new JButton("DELTE MEALKFDS");
		deleteProgressButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Figure out how to delete this. Prompt user to confirm the deletion or cancel.
				((ProjectView) getThis().getParent()).removeProgress(getThis());
//				pan.setVisible(false);
			}
		});
		buttonPanel.add(deleteProgressButton);
		
		
		
		add(buttonPanel, BorderLayout.SOUTH);
		
		// Test Border
		this.setBorder(BorderFactory.createEtchedBorder());
	}
	
	public ProgressView getThis() {
		return this;
	}
	
	public ArrayList<TaskView> getTaskList(){
		return taskList;
	}
	
	// addTask
	public void addTask(TaskModel model) throws BadLocationException {
		// Remove all from Panel
		for(TaskView view: taskList) {
			taskPanel.remove(view);
		}
		
		// Add and sort ArrayList
		this.model.addTask(model);
		TaskView taskView = new TaskView(model);
		taskList.add(taskView);
		Collections.sort(taskList);
		
		// Add all to Panel
		for(TaskView view: taskList) {
			taskPanel.add(view);
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
		this.model.removeTask(task.getModel());
		taskList.remove(task);
		Collections.sort(taskList);
		
		// Add all
		for(TaskView view: taskList) {
			this.add(view);
		}
	}
	
	// Setters
	public void setStatus(String status) {
		this.status.setText(status);
	}

	@Override
	public int compareTo(ProgressView arg0) {	
		return this.getModel().compareTo(arg0.getModel());
	}
}
