package main;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

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
		
		Border border = BorderFactory.createEtchedBorder();
		
		name = new JTextArea();
		name.setBorder(border);
		
		description = new JTextArea();
		description.setBorder(border);
		
		date = new JTextArea();
		date.setBorder(border);
		
		setData();
		
		// Add to Panel
		setLayout(new GridLayout(3,1));
		this.add(name);
		this.add(description);
		this.add(date);
		
		// Add Border
		this.setBorder(BorderFactory.createLineBorder(Color.black));
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
	
	public String getStatus() {
		return this.status;
	}
	
	// Set data for TextAreas
	public void setData(){
		this.status = model.getStatus();
		name.setText(model.getName());
		description.setText(model.getDescription());
		date.setText(model.getDate().DAY_OF_MONTH + "/" + model.getDate().MONTH + "/" + model.getDate().YEAR);
	}
}
