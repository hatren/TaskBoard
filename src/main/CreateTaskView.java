package main;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class CreateTaskView extends JFrame {
	private ProgressView progressView;
	
	// Used to type in fields when creating a TaskModel
	private JPanel optionPanel;
	private JLabel nameLabel;
	private JTextArea nameInput;
	private JLabel descriptionLabel;
	private JTextArea descriptionInput;
	
	// Used for Date
	private JLabel dueDateLabel;
	private JPanel dueDatePanel;
	private JTextArea dayInput;
	private JTextArea monthInput;
	private JTextArea yearInput;
	
	private JLabel statusLabel;
	private JTextArea statusInput;
	private JButton addButton;
	private JButton exitButton;
	
	public CreateTaskView(ProgressView progressView) {
		this.progressView = progressView;
		
		optionPanel = new JPanel();
		optionPanel.setLayout(new GridLayout(5,2));
		
		Border border = BorderFactory.createEtchedBorder();
		
		nameLabel = new JLabel("Name: ");
		nameLabel.setBorder(border);
		nameLabel.setAlignmentX(LEFT_ALIGNMENT);
		optionPanel.add(nameLabel);
		
		nameInput = new JTextArea();
		nameInput.setBorder(border);
		optionPanel.add(nameInput);
		
		descriptionLabel = new JLabel("Description: ");
		descriptionLabel.setBorder(border);
		optionPanel.add(descriptionLabel);
		
		descriptionInput = new JTextArea();
		descriptionInput.setBorder(border);
		optionPanel.add(descriptionInput);
		
		
		dueDateLabel = new JLabel("Due Date: ");
		dueDateLabel.setBorder(border);
		optionPanel.add(dueDateLabel);
		
		dueDatePanel = new JPanel();
		dueDatePanel.setLayout(new GridLayout(1,3));
		
		dayInput = new JTextArea();
		dayInput.setBorder(border);
		dueDatePanel.add(dayInput);
		
		monthInput = new JTextArea();
		monthInput.setBorder(border);
		dueDatePanel.add(monthInput);
		
		yearInput = new JTextArea();
		yearInput.setBorder(border);
		dueDatePanel.add(yearInput);
		
		optionPanel.add(dueDatePanel);
		
		statusLabel = new JLabel("Status: ");
		statusLabel.setBorder(border);
		optionPanel.add(statusLabel);
		
		statusInput = new JTextArea();
		statusInput.setBorder(border);
		optionPanel.add(statusInput);
		
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Return Model
				addTask();
			}
		});
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Exit
				close();
			}
		});
		
		optionPanel.add(addButton);
		optionPanel.add(exitButton);
		
		add(optionPanel);
		
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	// Gets the date from the inputs
	private Calendar getDate() {
		int day = Integer.parseInt(dayInput.getText());
		int month = Integer.parseInt(monthInput.getText());
		int year = Integer.parseInt(yearInput.getText());
		Calendar date = Calendar.getInstance();
		date.set(year, month, day);
		return date;
	}
	// Creates the TaskModel from the input boxes and adds it
	private void addTask() {
		TaskModel task = new TaskModel(nameInput.getText(), descriptionInput.getText(), getDate(), statusInput.getText());
		progressView.addTask(task);
		dispose();
	}
	
	// Closes the frame
	private void close() {
		this.dispose();
	}
	
//	 Main test
	public static void main(String[] args) {
		ProgressView test = new ProgressView(new ProgressModel("test", 0));
		CreateTaskView test2 = new CreateTaskView(test);
	}
}
