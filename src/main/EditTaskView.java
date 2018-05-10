package main;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class EditTaskView extends JFrame {
	private TaskView taskView;
	
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
	private JButton editButton;
	private JButton exitButton;
	
	public EditTaskView(TaskView taskView) {
		this.taskView = taskView;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		optionPanel = new JPanel();
		optionPanel.setLayout(new GridLayout(5,2));
		
		Border border = BorderFactory.createEtchedBorder();
		
		// nameLabel
		nameLabel = new JLabel("Name: ");
		nameLabel.setBorder(border);
		nameLabel.setAlignmentX(LEFT_ALIGNMENT);
		optionPanel.add(nameLabel);
		
		// nameInput
		nameInput = new JTextArea(taskView.getModel().getName());
		nameInput.setBorder(border);
		optionPanel.add(nameInput);
		
		// descriptionLabel
		descriptionLabel = new JLabel("Description: ");
		descriptionLabel.setBorder(border);
		optionPanel.add(descriptionLabel);
		
		// descriptionInput
		descriptionInput = new JTextArea(taskView.getModel().getDescription());
		descriptionInput.setBorder(border);
		optionPanel.add(descriptionInput);
		
		// dueDateLabel
		dueDateLabel = new JLabel("Due Date: ");
		dueDateLabel.setBorder(border);
		optionPanel.add(dueDateLabel);
		
		// dueDateInput
		dueDatePanel = new JPanel();
		dueDatePanel.setLayout(new GridLayout(1,3));
		
		dayInput = new JTextArea(Integer.toString(taskView.getModel().getDate().DAY_OF_MONTH));
		dayInput.setBorder(border);
		dueDatePanel.add(dayInput);
		
		monthInput = new JTextArea(Integer.toString(taskView.getModel().getDate().MONTH));
		monthInput.setBorder(border);
		dueDatePanel.add(monthInput);
		
		yearInput = new JTextArea(Integer.toString(taskView.getModel().getDate().YEAR));
		yearInput.setBorder(border);
		dueDatePanel.add(yearInput);
		
		optionPanel.add(dueDatePanel);
		
		statusLabel = new JLabel("Status: ");
		statusLabel.setBorder(border);
		optionPanel.add(statusLabel);
		
		statusInput = new JTextArea(taskView.getModel().getStatus());
		statusInput.setBorder(border);
		optionPanel.add(statusInput);
		
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					editTask();
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
				close();
			}
		});
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		
		optionPanel.add(editButton);
		optionPanel.add(exitButton);
		
		add(optionPanel);
		
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	private void editTask() throws BadLocationException {
		// Edit Model
		// Name
		taskView.getModel().setName(nameInput.getText());
		// Description
		taskView.getModel().setDescription(descriptionInput.getText());
		// Date
		taskView.getModel().setDate(getDate());
		// Status
		taskView.getModel().setStatus(statusInput.getText());
		
		// Edit View
		taskView.setData();
		dispose();
	}
	
	// Closes the frame
	private void close() {
		this.dispose();
	}
	
//	 Main test
	public static void main(String[] args) throws BadLocationException {
		TaskModel testModel = new TaskModel("Name test", "Description test", Calendar.getInstance(), "Status test");
		TaskView testView = new TaskView(testModel);
		EditTaskView editView = new EditTaskView(testView);
	}
}