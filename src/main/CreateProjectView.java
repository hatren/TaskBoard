package main;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateProjectView extends JFrame {
	// Variables
	private TaskBoardView taskBoardView;
	private JPanel optionPanel;
	private JLabel nameLabel;
	private JTextArea nameInput;
	private JButton addButton;
	private JButton exitButton;
	
	// Constructor
	public CreateProjectView(TaskBoardView taskBoardView) {
		this.taskBoardView = taskBoardView;
		
		// Layout
		optionPanel = new JPanel();
		optionPanel.setLayout(new GridLayout(2,2));
		Border border = BorderFactory.createEtchedBorder();
		
		// Name
		nameLabel = new JLabel("Name: ");
		nameLabel.setBorder(border);
		nameLabel.setAlignmentX(LEFT_ALIGNMENT);
		optionPanel.add(nameLabel);
		
		nameInput = new JTextArea();
		nameInput.setBorder(border);
		optionPanel.add(nameInput);
		
		// Add Button
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Return Model
				addProject();
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
		
		setSize(300, 120);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	// Creates the TaskModel from the input boxes and adds it
	private void addProject() {
		ProjectModel model = new ProjectModel(nameInput.getText());
		taskBoardView.addProject(model);
		dispose();
	}
	
	// Closes the frame
	private void close() {
		this.dispose();
	}
}
