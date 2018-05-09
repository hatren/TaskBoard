package main;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TaskView extends JPanel {
	// Variables
	private TaskModel model;
	private String status;
	private JTextField name_and_date;
	private JTextField description;
	private JTextField date;
	
	// Constructor
	public TaskView(TaskModel model) {
		// Initialize
		this.model = model;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.YELLOW);
		
		
		Border border = BorderFactory.createEtchedBorder();
		
		name_and_date = new JTextField();
		name_and_date.setBorder(border);
		
		description = new JTextField();
		description.setBorder(border);
		
		date = new JTextField();
		date.setBorder(border);
		
		setData();
		
		/*JPanel task = new JPanel();
			BoxLayout boxlayout4 = new BoxLayout(task, BoxLayout.Y_AXIS);
			task.setBackground(Color.YELLOW);
			task.add(new JTextField("Sample Task..."));
			task.add(new JTextField("Description..."));
			task.add(new JTextField("Due: 5/31/2018"));
			task.setMaximumSize(
				     new Dimension(100, 150) );
			project.add(task);*/
		
		// Add to Panel
		//setLayout(new GridLayout(2,1));
		this.add(name_and_date);
		this.add(description);
		//this.add(date);
		
		// Add Border
		//this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	// Return all TextAreas
	/*public ArrayList<JTextArea> getText(){
		ArrayList<JTextArea> textArray = new ArrayList<JTextArea>();
		textArray.add(name_and_date);
		textArray.add(description);
		textArray.add(date);
		return textArray;
	} */
	
	public TaskModel getModel() {
		return this.model;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	// Set data for TextAreas
	public void setData(){
		this.status = model.getStatus();
		name_and_date.setText(model.getName()+ " - " + model.getDate().DAY_OF_MONTH + "/" + model.getDate().MONTH + "/" + model.getDate().YEAR);
		description.setText(model.getDescription());
		date.setText(model.getDate().DAY_OF_MONTH + "/" + model.getDate().MONTH + "/" + model.getDate().YEAR);
	}
}
