package main;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainScreen extends JPanel {
	//private LoginView login;
	//private TaskBoardView view;
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setLayout(new CardLayout());
		frame.setSize(900, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		TaskBoardView taskboardView = new TaskBoardView();
		frame.add(taskboardView);
		
		
		/*
		LoginView loginView = new LoginView(frame, taskboardView);
		
		
		frame.getContentPane().add(loginView, "Card 1");
		while(loginView.isAuthenticated() == false) {
			
		}
		
		frame.getContentPane().removeAll();
		
		//TaskBoardController controller = new TaskBoardController()
		frame.add(taskboardView, "Card 2"); */
		
		
		
		
		

		//cardLayout cardLayout = (CardLayout) frame.getLayout();
		//cardLayout.show(frame, "Card 2");
		
		//TODO Implement Saving
		//TODO Implement Loading w/ ComboBox

		//TODO Differentiate between CreateProject, CreateProgress, CreateTask
		//TODO Differentiate between DeleteProject, DeleteProgress, DeleteTask
		//TODO Implement boolean selected w/ all views to help differentiate??????????????
		//TODO Maybe we just have a fuck ton of buttons with + signs on them
		//TODO Maybe we just use a dropdown box
		//TODO Maybe CreateNew can ask what you want to do with your life
		
		
	}
	
}
