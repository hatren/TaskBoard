package main;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

public class CreateTaskView extends JFrame {
	// Variables
	private ProgressView progressView;
	private JPanel optionPanel;
	private JLabel nameLabel;
	private JTextArea nameInput;
	private JLabel descriptionLabel;
	private JTextArea descriptionInput;
	private JLabel dueDateLabel;
	JDatePickerImpl datePicker;
	private JButton addButton;
	private JButton exitButton;
	
	// Constructor
	public CreateTaskView(ProgressView progressView) {
		this.progressView = progressView;
		
		// Layout
		optionPanel = new JPanel();
		optionPanel.setLayout(new GridLayout(4,2));
		Border border = BorderFactory.createEtchedBorder();
		
		// Name
		nameLabel = new JLabel("Name: ");
		nameLabel.setBorder(border);
		nameLabel.setAlignmentX(LEFT_ALIGNMENT);
		optionPanel.add(nameLabel);
		
		nameInput = new JTextArea();
		nameInput.setBorder(border);
		optionPanel.add(nameInput);
		
		// Description
		descriptionLabel = new JLabel("Description: ");
		descriptionLabel.setBorder(border);
		optionPanel.add(descriptionLabel);
		
		descriptionInput = new JTextArea();
		descriptionInput.setBorder(border);
		optionPanel.add(descriptionInput);
		
		// Date
		dueDateLabel = new JLabel("Due Date: ");
		dueDateLabel.setBorder(border);
		optionPanel.add(dueDateLabel);
		
		UtilDateModel model = new UtilDateModel();
		//model.setDate(20,04,2014);
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		// Don't know about the formatter, but there it is...
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		optionPanel.add(datePicker);
		
		// Add Button
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Return Model
				try {
					addTask();
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}
		});
		
		// Exit Button
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	// Gets the date from the inputs
	private Calendar getDate() {
		/*int day = Integer.parseInt(dayInput.getText());
		int month = Integer.parseInt(monthInput.getText()) -1;
		int year = Integer.parseInt(yearInput.getText()) + 2000;
		Calendar date = new GregorianCalendar(year, month, day);
//		date.set(year, month, day);
		return date; */
		int day =  datePicker.getModel().getDay();
		int month =  datePicker.getModel().getMonth();
		int year =  datePicker.getModel().getYear();
		Calendar date = new GregorianCalendar(year, month, day);
		date.set(year, month, day);
		return date; 
	}
	// Creates the TaskModel from the input boxes and adds it
	private void addTask() throws BadLocationException {
		TaskModel task = new TaskModel(nameInput.getText(), descriptionInput.getText(), getDate(), progressView.getModel().getStatus());
		progressView.addTask(task);
		dispose();
	}
	
	// Closes the frame
	private void close() {
		this.dispose();
	}
}
