package main;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class EditProjectView extends JFrame {

	private ProjectView projectView;
	
	private JPanel outerPanel;
	
	private DefaultListModel<ProgressModel> progressListModel;
	private JList<ProgressModel> progressList;
	
	private JPanel topButtonPanel;
	private JButton upButton;
	private JButton downButton;

	private JButton exitButton;

	public EditProjectView(ProjectView projectView) {
		this.projectView = projectView;
		
		// OuterPanel
		outerPanel = new JPanel();
		outerPanel.setLayout(new BorderLayout());
		
		// TopButtonPanel
		topButtonPanel = new JPanel();
		topButtonPanel.setLayout(new GridLayout(1,2));
		upButton = new JButton("Up");
		upButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Raise Priority
				raisePriority();
			}
		});
		topButtonPanel.add(upButton);
		downButton = new JButton("Down");
		downButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Lower Priority
				lowerPriority();
			}
		});
		topButtonPanel.add(downButton);
		
		
		// BottomButtonPanel
		exitButton = new JButton("Confirm");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Exit
				exit();
			}
		});
		
		// DefaultListModel
		progressListModel = new DefaultListModel<ProgressModel>();
		for(ProgressModel model: projectView.getModel().getProgressList()) {
			progressListModel.add(model.getPriority(), model);
		}
		progressList = new JList<>(progressListModel);
		
		outerPanel.add(topButtonPanel, BorderLayout.NORTH);
		outerPanel.add(exitButton, BorderLayout.SOUTH);
		outerPanel.add(progressList, BorderLayout.CENTER);
		
		this.add(outerPanel);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void swap(ProgressModel arg0, ProgressModel arg1) {
		progressListModel.set(progressListModel.indexOf(arg0), arg1);
		progressListModel.set(progressListModel.indexOf(arg1), arg0);
		
//		int temp = arg1.getPriority();
//		arg1.setPriority(arg0.getPriority());
//		arg0.setPriority(temp);
	}
	
	// raisePriority()
	public void raisePriority() {
		if(progressList.getSelectedIndex() != 0) {
			ProgressModel arg0 = progressList.getSelectedValue();
			ProgressModel arg1 = progressListModel.elementAt(progressList.getSelectedIndex() - 1);
			progressList.setSelectedIndex(progressList.getSelectedIndex() - 1);
			
			swap(arg0, arg1);
			projectView.getModel().swap(arg0, arg1);
		}
	}
	
	// lowerPriority()
	public void lowerPriority() {
		if(progressList.getSelectedIndex() != progressListModel.size() - 1) {
			ProgressModel arg0 = progressListModel.elementAt(progressList.getSelectedIndex() + 1);
			ProgressModel arg1 = progressList.getSelectedValue();
			progressList.setSelectedIndex(progressList.getSelectedIndex() + 1);
			
			swap(arg0, arg1);
			projectView.getModel().swap(arg0, arg1);
		}
	}
	
	// exit()
	public void exit() {
		projectView.sort();
		projectView.validate();
		projectView.repaint();
		dispose();
	}
}
