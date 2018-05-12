package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoginView extends JPanel{	
	// Variables
	private JLabel mainTitle;
	private JButton loginButton;
	
	private boolean isAuthenticated = false;
	
	private JPanel login;
	private JLabel usernameTitle;
	private JTextField usernameEdit;
	private JLabel passwordTitle;
	private JPasswordField passwordEdit;
	
	private JFrame frame;
	private TaskBoardView view;
	
	// Constructor
	public LoginView(JFrame frame, TaskBoardView view) {

		this.frame = frame;
		this.view = view;
		
		setLayout(new BorderLayout());
		
		mainTitle = new JLabel("Task Board Login");
		mainTitle.setHorizontalAlignment(JLabel.CENTER);
		mainTitle.setVerticalAlignment(JLabel.CENTER);
		mainTitle.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		add(mainTitle, BorderLayout.NORTH);
		
//		loginButton = new JButton("Login");
//		loginButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				loginCheck();
//				
//			}
//		});
//		add(loginButton, BorderLayout.SOUTH);
		
		login = new JPanel();
		login.setLayout(null);
		add(login, BorderLayout.CENTER);
		
		usernameTitle = new JLabel("Username: ");
		usernameTitle.setHorizontalAlignment(JLabel.CENTER);
		usernameTitle.setVerticalAlignment(JLabel.CENTER);
		usernameTitle.setBounds(50, 50, 200, 50);
		login.add(usernameTitle);
		
		usernameEdit = new JTextField(20);
		usernameEdit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		usernameEdit.setEditable(true);
		usernameEdit.setBounds(250, 50, 200, 50);
		login.add(usernameEdit);
		
		passwordTitle = new JLabel("Password: ");
		passwordTitle.setHorizontalAlignment(JLabel.CENTER);
		passwordTitle.setVerticalAlignment(JLabel.CENTER);
		passwordTitle.setBounds(50, 100, 200, 50);
		login.add(passwordTitle);
		
		passwordEdit = new JPasswordField(20);
		passwordEdit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		passwordEdit.setEditable(true);
		passwordEdit.setBounds(250, 100, 200, 50);
		login.add(passwordEdit);
		
		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginCheck();
			}
		});
		loginButton.setBounds(350, 200, 100, 50);
		login.add(loginButton);
		
	}
	
	// Check Login information from text boxes
	private void loginCheck() {
		System.out.println(usernameEdit.getText() + ", " + passwordEdit.getPassword().toString());
		if("admin".equals(usernameEdit.getText()) && "admin".equals(passwordEdit.getText())) {
			// Do something
			// Maybe send a boolean to a controller or something
			// test
			
			isAuthenticated = true;
			mainTitle.setText("Success");
			frame.getContentPane().removeAll();
			frame.getContentPane().add(view, "Card 2");
			
		}
		else {
			mainTitle.setText("Fail");
		}
	}
	
	public boolean isAuthenticated() {
		return isAuthenticated;
	}
	
	
}
