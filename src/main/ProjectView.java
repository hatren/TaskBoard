package main;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ProjectView extends JPanel {
	// View Project Information
	private ProjectModel model;
	private ArrayList<ProgressView> progressList;
	private JTextArea name;
	
	// Constructor
	public ProjectView(ProjectModel model) {
		// Initialize
		this.model = model;
		
		// Add Name Text
		name = new JTextArea(model.getName());
		add(name);
		
		// Add ProgressViews
		for(ProgressModel progress: this.model.getProgressList()) {
			addProgress(new ProgressView(progress));
		}
	}
	
	// addTask
	public void addProgress(ProgressView view) {
		progressList.add(view);
		add(view);
	}
	
	// removeTask
	public void removeProgress(ProgressView view) {
		progressList.remove(view);
		remove(view);
	}
}
