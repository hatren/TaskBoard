package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ProjectModel implements Serializable{
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
	
	// Swaps
	public void swap(ProgressModel arg0, ProgressModel arg1) {
		int tempIndex = progressList.indexOf(arg1);
		progressList.set(progressList.indexOf(arg0), arg1);
		progressList.set(tempIndex, arg0);
		
		int tempPriority = arg0.getPriority();
		arg0.setPriority(arg1.getPriority());
		arg1.setPriority(tempPriority);
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
		for(int i = progressList.indexOf(progress); i<progressList.size(); i++) {
			progressList.get(i).setPriority(progressList.get(i).getPriority() - 1);
		}
		progressList.remove(progress);
		Collections.sort(progressList);
	}
}
