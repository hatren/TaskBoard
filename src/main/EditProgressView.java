package main;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProgressView extends JFrame {
	// Variables
	private ProgressView progressView;
	private JPanel optionPanel;
	private JLabel nameLabel;
	private JTextArea nameInput;
	private JButton addButton;
	private JButton exitButton;
	
	// Constructor
	public EditProgressView(ProgressView progressView) {
		this.progressView = progressView;
		
		// Layout
		optionPanel = new JPanel();
		optionPanel.setLayout(new GridLayout(2,2));
		Border border = BorderFactory.createEtchedBorder();
		
		// Name
		nameLabel = new JLabel("Name: ");
		nameLabel.setBorder(border);
		nameLabel.setAlignmentX(LEFT_ALIGNMENT);
		optionPanel.add(nameLabel);
		
		nameInput = new JTextArea(progressView.getModel().getStatus());
		nameInput.setBorder(border);
		optionPanel.add(nameInput);
		
		// Add Button
		addButton = new JButton("Edit");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Return Model
				editProgress();
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
	private void editProgress() {
		progressView.getModel().setStatus(nameInput.getText());
		progressView.setStatus(nameInput.getText());
		dispose();
	}
	
	// Closes the frame
	private void close() {
		this.dispose();
	}
}