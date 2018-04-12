package main;

import javax.swing.JFrame;

public class MainTest {
	public static void main(String[] args) {
		LoginView test = new LoginView();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.add(test);
	}
}
