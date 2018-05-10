package main;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProgressView extends JFrame {
	private ProgressView progressView;
	
	// Used to type in fields when creating a TaskModel
	private JPanel optionPanel;
	private JLabel nameLabel;
	private JTextArea nameInput;

	private JButton addButton;
	private JButton exitButton;
	
	public EditProgressView(ProgressView progressView) {
		this.progressView = progressView;
		
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
		
		addButton = new JButton("Edit");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Return Model
				editProgress();
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