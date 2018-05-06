package main;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TaskBoardView extends JPanel{
	private TaskBoardModel model;
	private JLabel mainTitle;
	
	public TaskBoardView() {
		setLayout(new BorderLayout());
		
		mainTitle = new JLabel("Task Board View");
		mainTitle.setHorizontalAlignment(JLabel.CENTER);
		mainTitle.setVerticalAlignment(JLabel.CENTER);
		mainTitle.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		add(mainTitle, BorderLayout.NORTH);
	}
	
	public TaskBoardView(TaskBoardModel model) {
		this.model = model;
	}
}
