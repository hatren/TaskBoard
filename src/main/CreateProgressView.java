package main;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateProgressView extends JFrame {
	private ProjectView projectView;
	
	// Used to type in fields when creating a TaskModel
	private JPanel optionPanel;
	private JLabel nameLabel;
	private JTextArea nameInput;

	private JButton addButton;
	private JButton exitButton;
	
	public CreateProgressView(ProjectView projectView) throws BadLocationException {
		this.projectView = projectView;
		
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
				try {
					addProject();
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
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
	private void addProject() throws BadLocationException {
		ProgressModel model = new ProgressModel(nameInput.getText(), projectView.getModel().getProgressList().size());
		projectView.addProgress(model);
		dispose();
	}
	
	// Closes the frame
	private void close() {
		this.dispose();
	}
	
//	 Main test
//	public static void main(String[] args) {
//		ProjectView test = new ProjectView(new ProjectModel("meme"));
//		
//		CreateProgressView test2 = new CreateProgressView(test);
//	}
}