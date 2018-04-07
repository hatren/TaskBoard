package main;

import java.util.ArrayList;

public class TaskBoardModel {
	// Variables
	String name;
	String fileName;
	ArrayList<ProjectModel> projectList;
	
	// Constructor
	public TaskBoardModel(String name, String fileName) {
		this.name = name;
		this.fileName = fileName;
		projectList = new ArrayList<ProjectModel>();
	}
	
	// Getters
	public String getName() {
		return name;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void addProject(ProjectModel project) {
		projectList.add(project);
	}
	
	public void removeProject(ProjectModel project) {
		projectList.remove(project);
	}
}
