package main;

import java.util.ArrayList;
import java.util.Collections;

public class ProjectModel {
	String name;
	ArrayList<ProgressModel> progressList;
	
	public ProjectModel(String name) {
		this.name = name;
		progressList = new ArrayList<ProgressModel>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addProgress(ProgressModel progress) {
		progressList.add(progress);
		Collections.sort(progressList);
	}
	
	public void removeProgress(ProgressModel progress) {
		progressList.remove(progress);
		Collections.sort(progressList);
	}
}
