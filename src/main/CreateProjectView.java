package main;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateProjectView extends JFrame {
	private TaskBoardView taskBoardView;
	
	// Used to type in fields when creating a TaskModel
	private JPanel optionPanel;
	private JLabel nameLabel;
	private JTextArea nameInput;

	private JButton addButton;
	private JButton exitButton;
	
	public CreateProjectView(TaskBoardView taskBoardView) {
		this.taskBoardView = taskBoardView;
		
		optionPanel = new JPanel();
		optionPanel.setLayout(new GridLayout(2,2));
		
		Border border = BorderFactory.createEtchedBorder();
		
		nameLabel = new JLabel("Name: ");
		nameLabel.setBorder(border);
		nameLabel.setAlignmentX(LEFT_ALIGNMENT);
		optionPanel.add(nameLabel);
		
		nameInput = new JTextArea();
		nameInput.setBorder(border);
		optionPanel.add(nameInput);
		
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Return Model
				addProject();
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
		
		setSize(300, 120);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	
//	 Main test
	public static void main(String[] args) {
		TaskBoardView test = new TaskBoardView();
		
		CreateProjectView test2 = new CreateProjectView(test);
	}
}
