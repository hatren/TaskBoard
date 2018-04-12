package main;

import java.util.ArrayList;

import javax.swing.JPanel;

public class TaskBoardView extends JPanel{
	private TaskBoardModel model;
	
	public TaskBoardView(TaskBoardModel model) {
		this.model = model;
	}
}
