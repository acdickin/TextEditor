package com.adickinson.program;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class swing extends JFrame {
	fileReader f;
	JButton add;
	JButton load;
	JButton save;
	JFrame frame;
	JPanel panel;
	JLabel lbl;	
	JTextField txt;
	JTextArea txa;
	JLabel warn;
	public swing()
	{
		f=new fileReader();
		createFrame();
		
	}
	
	public void createFrame(){
		frame = new JFrame();
		  frame.add(createPanel());
		  frame.setTitle("Read from a File");
		  frame.setLocationRelativeTo(null);
		  frame.setBounds(600,500,300,300);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setVisible(true);
		
	}
	
	public JPanel createPanel(){
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		lbl= new JLabel("File Name");
		txt= new JTextField(5);
		txa= new JTextArea(50,50);
		warn= new JLabel("");

		add=new JButton("New");
		add.addActionListener(new AddListener());
		load= new JButton("Load");
		load.addActionListener(new LoadListener());
		save= new JButton("Save");
		save.addActionListener(new SaveListener());
		
		panel.add(lbl);
		panel.add(txt);
		panel.add(add);
		panel.add(load);
		panel.add(save);
		//,BorderLayout.NORTH
		panel.add(warn);
		panel.add(txa );
		
		//,BorderLayout.CENTER
		return panel;
	}
	private class AddListener implements ActionListener{
		
		 public void actionPerformed(ActionEvent arg0) {
			
			 txa.setText("");
			 txt.setText("");
			 txt.requestFocus();
			 warn.setText("");
		 }
	}
	
	private class LoadListener implements ActionListener{
		
		 public void actionPerformed(ActionEvent arg0) {
			 String name =txt.getText();
			 warn.setText(f. LoadFile(name));
			 txa.setText(f.getContents());
		
		 }
	}
	
	private class SaveListener implements ActionListener{
		
		 public void actionPerformed(ActionEvent arg0) {
			
			String name =txt.getText();
			String contents=txa.getText();
			 warn.setText( f.SaveFile(name, contents));
			 
			
		 }
	}
	
	
}