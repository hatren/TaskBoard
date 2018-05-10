package main;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.*;
public class TaskView extends JPanel implements Comparable<TaskView>{
	// Variables
	private TaskModel model;
	private String status;
	private String name_and_date;
	private String description;
	private String date;
	private JTextPane tasks;
	
	// Constructor
	public TaskView(TaskModel model) throws BadLocationException {
		// Initialize
		this.model = model;
		setData();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		StyleContext context = new StyleContext();
	    StyledDocument document = new DefaultStyledDocument(context);
	    Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
	    StyleConstants.setFontSize(style, 10);
	    document.insertString(document.getLength(), (name_and_date+"\n"+description), style);
		tasks = new JTextPane(document);
		tasks.setEditable(false);
		
	    add(tasks);
		/*
		name_and_date = new JLabel();
		name_and_date.setBorder(border);
		
		description = new JLabel();
		description.setBorder(border);
		
		date = new JLabel();
		date.setBorder(border);
		*/
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
		//this.add(name_and_date);
		//this.add(description);
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
	
	//TODO Status should be changed to something that corresponds to ProgressView/ProgressModel
	public String getStatus() {
		return this.status;
	}
	
	// Set data for TextAreas
	public void setData(){
		this.status = model.getStatus();
		name_and_date = model.getName()+ " - " + model.getDate().DAY_OF_MONTH + "/" + model.getDate().MONTH + "/" + model.getDate().YEAR;
		description = model.getDescription();
		date = model.getDate().DAY_OF_MONTH + "/" + model.getDate().MONTH + "/" + model.getDate().YEAR;
	}

	@Override
	public int compareTo(TaskView arg0) {
		return this.getModel().compareTo(arg0.getModel());
	}
	
	public static void main(String[] args) throws BadLocationException {
		JFrame jf = new JFrame();
		Calendar c = new GregorianCalendar();
		Date date = new Date();
		c.setTime(date);
		TaskModel tbm = new TaskModel("test", "does something", c, "completed I guess");
		TaskView tv = new TaskView(tbm);
		jf.setSize(250, 250);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.add(tv);
	}
	
	
	
}
