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
		
		
		TaskBoardView taskboardView = new TaskBoardView();
		LoginView loginView = new LoginView(frame, taskboardView);
		
		frame.setLayout(new CardLayout());
		frame.setSize(900, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.getContentPane().add(loginView, "Card 1");
		while(loginView.isAuthenticated() == false) {
			
		}
		
		frame.getContentPane().removeAll();
		
		//TaskBoardController controller = new TaskBoardController()
		frame.add(taskboardView, "Card 2");
		
		
		
		
		

		//cardLayout cardLayout = (CardLayout) frame.getLayout();
		//cardLayout.show(frame, "Card 2");
		
		
		
		
	}
	
}
