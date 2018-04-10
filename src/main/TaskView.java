package main;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TaskView extends JPanel {
	// Variables
	private TaskModel model;
	private String status;
	private JTextArea name;
	private JTextArea description;
	private JTextArea date;
	
	// Constructor
	public TaskView(TaskModel model) {
		// Initialize
		this.model = model;
		name = new JTextArea();
		description = new JTextArea();
		date = new JTextArea();
		setData();
		
		// Add to Frame
		this.add(name);
		this.add(description);
		this.add(date);
	}
	
	// Return all TextAreas
	public ArrayList<JTextArea> getText(){
		ArrayList<JTextArea> textArray = new ArrayList<JTextArea>();
		textArray.add(name);
		textArray.add(description);
		textArray.add(date);
		return textArray;
	}
	
	public TaskModel getModel() {
		return this.model;
	}
	
	// Set data for TextAreas
	public void setData(){
		this.status = model.getStatus();
		name.setText(model.getName());
		description.setText(model.getDescription());
		date.setText(model.getDate().toString());
	}
}
