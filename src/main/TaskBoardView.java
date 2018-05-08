 package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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
	}
	
	public TaskBoardView(TaskBoardModel model) {
		this.model = model;
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
