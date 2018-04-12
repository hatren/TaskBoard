package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LoginView extends JPanel{	
	// Variables
	private JLabel mainTitle;
	private JButton loginButton;
	
	private JPanel login;
	private JLabel usernameTitle;
	private JTextArea usernameEdit;
	private JLabel passwordTitle;
	private JTextArea passwordEdit;

	// Constructor
	public LoginView() {
		// ***Needs Formatting***
		setLayout(new BorderLayout());
		
		mainTitle = new JLabel("Task Board Login");
		mainTitle.setHorizontalAlignment(JLabel.CENTER);
		mainTitle.setVerticalAlignment(JLabel.CENTER);
		add(mainTitle, BorderLayout.NORTH);
		
		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginCheck();
			}
		});
		add(loginButton, BorderLayout.SOUTH);
		
		login = new JPanel();
		login.setLayout(new GridLayout(2,2));
		add(login, BorderLayout.CENTER);
		
		usernameTitle = new JLabel("Username: ");
		usernameTitle.setHorizontalAlignment(JLabel.CENTER);
		usernameTitle.setVerticalAlignment(JLabel.CENTER);
		login.add(usernameTitle, 0);
		
		usernameEdit = new JTextArea("");
		usernameEdit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		usernameEdit.setEditable(true);
		login.add(usernameEdit, 1);
		
		passwordTitle = new JLabel("Password: ");
		passwordTitle.setHorizontalAlignment(JLabel.CENTER);
		passwordTitle.setVerticalAlignment(JLabel.CENTER);
		login.add(passwordTitle, 2);
		
		passwordEdit = new JTextArea("");
		passwordEdit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		passwordEdit.setEditable(true);
		login.add(passwordEdit, 3);
	}
	
	// Check Login information from text boxes
	private void loginCheck() {
		if("admin".equals(usernameEdit.getText()) && "admin".equals(passwordEdit.getText())) {
			// Do something
			// Maybe send a boolean to a controller or something
			
			// test
			mainTitle.setText("Success");
		}
		else {
			mainTitle.setText("Fail");
		}
	}
	
}
