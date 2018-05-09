package main;

import java.util.ArrayList;
import java.util.Collections;

public class ProjectModel {
	// Variables
	private String name;
	private ArrayList<ProgressModel> progressList;
	
	// Constructor
	public ProjectModel(String name) {
		this.name = name;
		progressList = new ArrayList<ProgressModel>();
	}
	
	// Getters
	public String getName() {
		return name;
	}
	
	public ArrayList<ProgressModel> getProgressList(){
		return progressList;
	}
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}

	// Add new Progress type
	public void addProgress(ProgressModel progress) {
		progressList.add(progress);
		Collections.sort(progressList);
	}
	
	public int progressSize() {
		return progressList.size();
	}
	
	// Remove old Progress type
	public void removeProgress(ProgressModel progress) {
		progressList.remove(progress);
		Collections.sort(progressList);
	}
}
