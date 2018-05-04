package main;

import java.io.*;
import java.util.ArrayList;

public class TaskBoardController {
	TaskBoardModel model;
	TaskBoardView view;
	ObjectInputStream in;
	ObjectOutputStream out;
	public TaskBoardController(TaskBoardModel taskBoard){
		model = taskBoard;
	}
	
	//Since TaskBoardModel holds the other models in their own lists, this should save all
	public void save() throws FileNotFoundException, IOException, ClassNotFoundException {
		out = new ObjectOutputStream(
		         new FileOutputStream(model.getFileName()));
		      out.writeObject(model.getProjectList());
		      out.close();
	}
	
	public ArrayList<ProjectModel> readSaved() throws ClassNotFoundException, IOException{
		in = new ObjectInputStream(
		         new FileInputStream(model.getFileName())); 
		ArrayList<ProjectModel> savedModels =  (ArrayList<ProjectModel>) in.readObject();
		return savedModels;
	}
	
	// This controller will be used to connect and control the Project files with the project view and controller
}
