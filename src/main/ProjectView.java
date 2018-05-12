package main;

import java.awt.GridLayout;
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
import javax.swing.text.BadLocationException;

public class ProjectView extends JPanel {
	// View Project Information
	private ProjectModel projectModel;
	private ArrayList<ProgressView> progressList = new ArrayList<ProgressView>();
//	private JTextArea name;
	
	// Constructor
	public ProjectView(ProjectModel projectModel) {
		// Initialize
		this.projectModel = projectModel;
		
		// Add Name Text
//		name = new JTextArea(projectModel.getName());
		
		setBorder(BorderFactory.createTitledBorder(projectModel.getName()));
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
		
//		JPanel project = new JPanel();
//		project.setLayout(new BoxLayout(project, BoxLayout.Y_AXIS));
	}
	
	public ProjectModel getModel() {
		return projectModel;
	}
	
	public ArrayList<ProgressView> getProgressList(){
		return progressList;
	}
	
	// addTask
	public void addProgress(ProgressModel model) throws BadLocationException{
		// Remove All
		for(ProgressView progress: progressList) {
			this.remove(progress);
		}
	
		// Add
		this.projectModel.addProgress(model);
		ProgressView progressView = new ProgressView(model);
		progressList.add(progressView);
		Collections.sort(progressList);
		
		// Show All
		this.setLayout(new GridLayout(1, progressList.size()));
		for(ProgressView progress: progressList) {
			this.add(progress);
		}
		
		validate();
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
		
		//TODO Fix removeProgress to work with only 1 progressView
		// If there is only 1 progressView, it removes the last progressView, but still shows up. 
		// If you add another progressView, it will replace the last one.
		if(progressList.size() == 0) {
			this.setLayout(new GridLayout(1,1));
		}else {
			this.setLayout(new GridLayout(1, progressList.size()));
			for(ProgressView progress: progressList) {
				this.add(progress);
			}
		}
		
		validate();
	}
	
	public void sort() {
		for(ProgressView progress: progressList) {
			this.remove(progress);
		}
		
		Collections.sort(progressList);
		
		for(ProgressView progress: progressList) {
			this.add(progress);
		}
	}
}
