package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ProjectView extends JPanel {
	// View Project Information
	private ProjectModel model;
	private ArrayList<ProgressView> progressList = new ArrayList<ProgressView>();
	private JTextArea name;
	private JButton addProgressButton;
	
	// Constructor
	public ProjectView(ProjectModel model) {
		// Initialize
		this.model = model;
		
		// Add Name Text
		name = new JTextArea(model.getName());
		/* add(name);
		
		// Add ProgressViews
		for(ProgressModel progress: this.model.getProgressList()) {
			addProgress(progress);
		}
		
		addProgressButton = new JButton("Add Progression");
		addProgressButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = JOptionPane.showInputDialog("Enter a Progression Name");
				addProgress(new ProgressModel(name, progressList.size()));
			}
		});
		add(addProgressButton);
		
		// Test Border
		this.setBorder(BorderFactory.createRaisedBevelBorder()); */ 
		
		JPanel project = new JPanel();
		project.setLayout(new BoxLayout(project, BoxLayout.Y_AXIS));
	}
	
	// addTask
	public void addProgress(ProgressModel model) {
		// Remove All
		for(ProgressView progress: progressList) {
			this.remove(progress);
		}
	
		// Add
		this.model.addProgress(model);
		ProgressView progressView = new ProgressView(model);
		progressList.add(progressView);
		Collections.sort(progressList);
		
		// Show All
		for(ProgressView progress: progressList) {
			this.add(progress);
		}
	}
	
	// removeTask
	public void removeProgress(ProgressView removed) {
		// Remove All From JPanel
		for(ProgressView progress: progressList) {
			this.remove(progress);
		}
			
		// Remove and Sort ArrayList
		progressList.remove(removed);
		Collections.sort(progressList);
				
		// Add All to JPanel
		for(ProgressView progress: progressList) {
			this.add(progress);
		}
	}
}
