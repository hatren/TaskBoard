package main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class TaskView extends JPanel implements Comparable<TaskView>{
	// Variables
	private TaskModel model;
	private String status;
	private String name_and_date;
	private String description;
	private String date;
	private JTextPane tasks;
	
	private JPanel buttonPanel;
	private JButton editButton;
	private JButton deleteButton;
	
	JPanel pan = this;
	
	// Constructor
	public TaskView(TaskModel model) throws BadLocationException {
		// Initialize
		this.model = model;
		
		
//		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new BorderLayout());
		this.setMaximumSize(new Dimension(250, 250));
	
		
		this.status = model.getStatus();
		name_and_date = model.getName()+ " - " + model;
		description = " - " + model.getDescription();
		date = ""+model;
		StyleContext context = new StyleContext();
	    StyledDocument document = new DefaultStyledDocument(context);
	    Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
	    StyleConstants.setFontSize(style, 15);
	    document.insertString(document.getLength(), (name_and_date+"\n"+description), style);
		tasks = new JTextPane(document);
		tasks.setEditable(false);
		
		
		
//		setData();
		
	    add(tasks, BorderLayout.CENTER);
	    
	    buttonPanel = new JPanel();
	    buttonPanel.setLayout(new GridLayout(1,2));
	    editButton = new JButton("Edit");
	    editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				edit();
			}
	    });
	    buttonPanel.add(editButton);
	    
	    deleteButton = new JButton("Delete");
	    deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int input = JOptionPane.showConfirmDialog(null, "Are you sure you would like to delete this task?", "Deletion Prompt", JOptionPane.OK_CANCEL_OPTION);
				if(input == 0) {
					//getProgressView().removeTask(getThis());
					pan.setVisible(false);
				}
			}
	    	
	    });
	    buttonPanel.add(deleteButton);
	    
	    add(buttonPanel,BorderLayout.SOUTH);
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
		this.setBorder(BorderFactory.createEtchedBorder());
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
	
	public TaskView getThis() {
		return this;
	}
	
	public ProgressView getProgressView() {
		return (ProgressView) this.getParent().getParent();
	}
	
	//TODO Status should be changed to something that corresponds to ProgressView/ProgressModel
	public String getStatus() {
		return this.status;
	}
	
	private void edit() {
		EditTaskView editTaskView = new EditTaskView(this);
	}
	
	// Set data for TextAreas
	public void setData() throws BadLocationException{
		this.status = model.getStatus();
		name_and_date = model.getName()+ " - " + model;
		description = model.getDescription();
		date = ""+model;
		
		StyleContext context = new StyleContext();
	    StyledDocument document = new DefaultStyledDocument(context);
	    Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
	    StyleConstants.setFontSize(style, 15);
	    document.insertString(document.getLength(), (name_and_date+"\n"+description), style);
	    
	    tasks.setDocument(document);
	}

	@Override
	public int compareTo(TaskView arg0) {
		return this.getModel().compareTo(arg0.getModel());
	}
	
//	public static void main(String[] args) throws BadLocationException {
//		JFrame jf = new JFrame();
//		Calendar c = new GregorianCalendar();
//		Date date = new Date();
//		c.setTime(date);
//		TaskModel tbm = new TaskModel("test", "does something", c, "completed I guess");
//		TaskView tv = new TaskView(tbm);
//		jf.setSize(250, 250);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jf.setVisible(true);
//		jf.add(tv);
//	}
}
