package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TaskBoardView extends JPanel{
	private TaskBoardModel model;
	private JLabel mainTitle;
//	private JFrame buttonFrame;
//	private JFrame mainFrame;
	private JButton addProjectButton;
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
	
	public TaskBoardView() {
		TaskBoardModel model = new TaskBoardModel("TestName", "TestFileName");
		this.model = model;
		
		setLayout(new BorderLayout());
		
		mainTitle = new JLabel("Task Board View");
		mainTitle.setHorizontalAlignment(JLabel.CENTER);
		mainTitle.setVerticalAlignment(JLabel.CENTER);
		mainTitle.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		add(mainTitle, BorderLayout.NORTH);
		
		// addProjectButton
		addProjectButton = new JButton("Add Project");
		addProjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Add Project
				String name = JOptionPane.showInputDialog("Enter a name for the new project");
				addProject(new ProjectModel(name));
			}
		});
		add(addProjectButton, BorderLayout.SOUTH);
		

		toolbar = new JPanel();
		toolbar.setLayout(null);
		add(toolbar, BorderLayout.CENTER);
		

		selectProject = new JLabel("Select Project: ");
		selectProject.setHorizontalAlignment(JLabel.CENTER);
		selectProject.setVerticalAlignment(JLabel.CENTER);
		selectProject.setBounds(50, 50, 200, 50);
		toolbar.add(selectProject); 
		
		// Will need to get this data from controller
		
		String[] choices = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
		projectDropDown = new JComboBox<String>(choices);
		projectDropDown.setBounds(250,50, 150, 50);
		
		projectDropDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selected = (String) projectDropDown.getSelectedItem();
				
				switch(selected) {
					default:
						
				}
				
			}
		});
		
		
		toolbar.add(projectDropDown); 
		
		edit = new JButton("Edit");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		edit.setBounds(400, 50, 50, 50);
		toolbar.add(edit, BorderLayout.SOUTH);
		
		save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		save.setBounds(450, 50, 50, 50);
		toolbar.add(save);
		
		delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		delete.setBounds(500, 50, 50, 50);
		toolbar.add(delete);
		
		load = new JButton("Load");
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		load.setBounds(550, 50, 75, 50);
		toolbar.add(load);
		
		createNew = new JButton("Create New");
		createNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		createNew.setBounds(625, 50, 75, 50);
		toolbar.add(createNew);
		
		logOut = new JButton("Logout");
		logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		logOut.setBounds(700, 50, 75, 50);
		toolbar.add(logOut);
		
		

		// addProjectButton
		addProjectButton = new JButton("Add Project");
		addProjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Add Project
				String name = JOptionPane.showInputDialog("Enter a name for the new project");
				addProject(new ProjectModel(name));
			}
		});
		add(addProjectButton, BorderLayout.SOUTH);
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
}
