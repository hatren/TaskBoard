package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class EditTaskView extends JFrame {
	// Variables
	private TaskView taskView;
	private JPanel optionPanel;
	private JLabel nameLabel;
	private JTextArea nameInput;
	private JLabel descriptionLabel;
	private JTextArea descriptionInput;

	private JLabel dueDateLabel;
	
	JDatePickerImpl datePicker;
	
	private JLabel statusLabel;
	private JComboBox<String> statusInput;
	private JButton editButton;
	private JButton exitButton;
	
	private ProjectView projectView;
	
	// Constructor
	public EditTaskView(TaskView taskView) {
		this.taskView = taskView;
		this.projectView = (ProjectView) taskView.getParent().getParent().getParent();
		
		// Layout
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
		String hi = datePicker.getJFormattedTextField().getText();

		Calendar selectedValue = (Calendar) datePicker.getModel().getValue();
		
		// ComboBox
		statusLabel = new JLabel("Progress: ");
		statusLabel.setBorder(border);
		optionPanel.add(statusLabel);

		statusInput = new JComboBox<String>();
		statusInput.setModel(new DefaultComboBoxModel<String>());
		for(ProgressView progressView: projectView.getProgressList()) {
			statusInput.addItem(progressView.getModel().getStatus());
		}
		statusInput.validate();
		statusInput.setBorder(border);
		optionPanel.add(statusInput);
		
		// Edit Button
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
		
		// Exit Button
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
		int day =  datePicker.getModel().getDay();
		int month =  datePicker.getModel().getMonth();
		int year =  datePicker.getModel().getYear();
		Calendar date = new GregorianCalendar(year, month, day);
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
		projectView.findProgress((String) statusInput.getSelectedItem()).addTask(taskView.getModel());
		((ProgressView) taskView.getParent().getParent()).removeTask(taskView);
		
		// Edit View
		taskView.setData();
		dispose();
	}
	
	// Closes the frame
	private void close() {
		this.dispose();
	}
}