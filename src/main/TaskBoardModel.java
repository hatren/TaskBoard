package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TaskBoardModel implements Serializable{
	// Variables
	private String name;
	private String fileName;
	private ArrayList<ProjectModel> projectList;
	
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
	
	public ArrayList<ProjectModel> getProjectList() {
		return projectList;
	}
	
	public void setProjectList(ArrayList<ProjectModel> pml) {
		projectList = pml;
	}
	
	public void addProject(ProjectModel project) {
		projectList.add(project);
	}
	
	public void removeProject(ProjectModel project) {
		projectList.remove(project);
	}
//-------------------------
	public void saveTasks() throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(
		         new FileOutputStream(fileName));
		      out.writeObject(projectList);
		      out.close();
	}
	
	public ArrayList<ProjectModel> loadTasks() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(
		         new FileInputStream(fileName)); 
		ArrayList<ProjectModel> savedModels =  (ArrayList<ProjectModel>) in.readObject();
		return savedModels;
	}
	
}
