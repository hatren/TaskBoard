package main;


import javax.swing.JFrame;

public class MainTest {
	public static void main(String[] args){
		LoginView test = new LoginView();
		JFrame frame = new JFrame();
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(test);
		
		
		
		
	}
}