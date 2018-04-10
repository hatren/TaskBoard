package main;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ProgressView extends JPanel{
	ProgressModel model;
	ArrayList<TaskView> taskList;
	JTextArea status;
	
	public ProgressView(ProgressModel model) {
		this.model = model;
	}
}
