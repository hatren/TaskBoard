package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TaskBoardView extends JPanel{
	private TaskBoardModel model;
	private TaskBoardController tbc = new TaskBoardController(model);
	private JLabel mainTitle;
//	private JFrame buttonFrame;
//	private JFrame mainFrame;
	private JButton addProjectButton;
	private ProjectView currentProject;
	private ArrayList<ProjectView> projectList = new ArrayList<ProjectView>();
	
	private JLabel selectProject;
	private JComboBox<String> projectDropDown;
	private JButton edit;
	private JButton save;
	private JButton delete;
	private JButton load;
	private JButton createNew;
	private JButton logOut;
	private JPanel toolbar;
	
	private JPanel projectBoxes;
	
	public TaskBoardView() {
		TaskBoardModel model = new TaskBoardModel("TestName", "TestFileName.ser");
		this.model = model;
		
		BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(boxlayout);
		
		mainTitle = new JLabel("Task Board View");
		mainTitle.setHorizontalAlignment(JLabel.CENTER);
		mainTitle.setVerticalAlignment(JLabel.CENTER);
		add(mainTitle);
		
		toolbar = new JPanel();
		toolbar.setLayout(new FlowLayout());
		toolbar.setBackground(Color.PINK);
		toolbar.setMaximumSize(new Dimension(900, 50));
		add(toolbar, BorderLayout.CENTER);

		selectProject = new JLabel("Select Project: ");
		selectProject.setHorizontalAlignment(JLabel.CENTER);
		selectProject.setVerticalAlignment(JLabel.CENTER);
		//selectProject.setBounds(50, 50, 200, 50);
		toolbar.add(selectProject); 
		
		// Will need to get this data from controller
		
		String[] choices = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5"};
		projectDropDown = new JComboBox<String>(choices);
		//projectDropDown.setBounds(250,50, 150, 50);
		
		projectDropDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selected = (String) projectDropDown.getSelectedItem();
				
				switch(selected) {
					default:
						
				}
				
			}
		});
		
		
		toolbar.add(projectDropDown); 
		
		// Edit Button
		edit = new JButton("Edit");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				edit();
			}
		});
		//edit.setBounds(400, 50, 50, 50);
		toolbar.add(edit, BorderLayout.SOUTH);
		
		save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					saveTasks();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("serialization failed");
					e.printStackTrace();
				}
				
			}
		});
		//save.setBounds(450, 50, 50, 50);
		toolbar.add(save);
		
		delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		//delete.setBounds(500, 50, 50, 50);
		toolbar.add(delete);
		
		load = new JButton("Load");
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ArrayList<ProjectModel> pjm = loadTasks();
					for(ProjectModel pm: pjm) {
						addProject(pm);
					}
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		//load.setBounds(550, 50, 75, 50);
		toolbar.add(load);
		
		createNew = new JButton("Create New");
		createNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		//createNew.setBounds(625, 50, 75, 50);
		toolbar.add(createNew);
		
		logOut = new JButton("Logout");
		logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		//logOut.setBounds(700, 50, 75, 50);
		toolbar.add(logOut);
		
		JPanel pan = new JPanel();
		BoxLayout boxlayout2 = new BoxLayout(pan, BoxLayout.X_AXIS);
		pan.setLayout(boxlayout2);
		pan.setBackground(Color.GREEN);
		pan.setMaximumSize(new Dimension(800, 800));
		
		add(pan);
		

		/*// addProjectButton
		addProjectButton = new JButton("Add Project");
		addProjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Add Project
				String name = JOptionPane.showInputDialog("Enter a name for the new project");
				addProject(new ProjectModel(name));
			}
		});
		add(addProjectButton, BorderLayout.SOUTH); */
		/*
		projectBoxes = new JPanel();
		projectBoxes.setLayout(null);
		add(toolbar, BorderLayout.SOUTH); */
		
		
		
		//Convert this to MVC stuff
		int numProjects = 4;
		
		
		ProgressModel prog1 = new ProgressModel("hi", 1);
		ProgressModel prog2 = new ProgressModel("hi", 1);
		ProgressModel prog3 = new ProgressModel("hi", 1);
		ProgressModel prog4 = new ProgressModel("hi", 1);
		
		

		Calendar c = new GregorianCalendar();
		Date date = new Date();
		c.setTime(date);
		TaskModel mod = new TaskModel("CS 151 Project", "A GUI Taskboard", c, "Behind");
		TaskModel mod2 = new TaskModel("CS 151 Project", "A GUI Taskboard", c, "Behind");
		TaskModel mod3 = new TaskModel("CS 151 Project", "A GUI Taskboard", c, "Behind");
		TaskModel mod4 = new TaskModel("CS 151 Project", "A GUI Taskboard", c, "Behind");
		
		prog1.addTask(mod);
		prog2.addTask(mod2);
		prog3.addTask(mod3);
		prog4.addTask(mod4);
		
		ProjectModel pmodel = new ProjectModel("CS 151");
		pmodel.addProgress(prog1);
		pmodel.addProgress(prog2);
		pmodel.addProgress(prog3);
		pmodel.addProgress(prog4);
		
		
		for(int i = 0; i < pmodel.progressSize(); i++) {
			ProgressModel prog = pmodel.getProgressList().get(i);
			ProgressView view = new ProgressView(prog);
			
			
			pan.add(view);
			
			
			/* JPanel project = new JPanel();
			project.setLayout(new BoxLayout(project, BoxLayout.Y_AXIS));
			project.setBackground(Color.RED);
			project.setMaximumSize(new Dimension(300, 1000));
			JTextField textfield = new JTextField("Project " + i);
			textfield.setPreferredSize(new Dimension(100, 100));
			textfield.setBackground(Color.BLUE);
			textfield.setMaximumSize(
				     new Dimension(100, 100) );
			project.add(textfield);
			
			
			JPanel task = new JPanel();
			BoxLayout boxlayout4 = new BoxLayout(task, BoxLayout.Y_AXIS);
			task.setBackground(Color.YELLOW);
			task.add(new JTextField("Sample Task..."));
			task.add(new JTextField("Description..."));
			task.add(new JTextField("Due: 5/31/2018"));
			task.setMaximumSize(
				     new Dimension(100, 150) );
			project.add(task);
			
			//project.setBounds(50 + (150 * i), 500, 150, 500);
			pan.add(project);  */
		}   
		
	}
	
	public void addProject(ProjectModel model) {
		this.model.addProject(model);
		ProjectView projectView = new ProjectView(model);
		projectList.add(projectView);
		add(projectView, BorderLayout.CENTER);
	}
	
	public void removeProject(ProjectModel model) {
		this.model.removeProject(model);
		
		// This most likely doesn't work
		projectList.remove(new ProjectView(model));
	}
	
	public void saveTasks() throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(
		         new FileOutputStream(model.getFileName()));
		      out.writeObject(model.getProjectList());
		      out.close();
	}
	
	// edits Object
	public void edit() {
		// Edit button will have to search for an object that is selected
		// then pop up a frame dependent on the instance of that object
		for(ProgressView progress: currentProject.getProgressList()) {
			for(TaskView task: progress.getTaskList()) {
				
			}
		}
	}
	
	public ArrayList<ProjectModel> loadTasks() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(
		         new FileInputStream(model.getFileName())); 
		ArrayList<ProjectModel> savedModels =  (ArrayList<ProjectModel>) in.readObject();
		return savedModels;
	}
	
}
