package com.hpkc.java.simplecalculator.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hpkc.java.simplecalculator.logic.Master;

public class GUI{
	
	public GUI() {
		Master.mainFrame = new JFrame("Simple Calculator");
		
		Master.container = Master.mainFrame.getContentPane();
		
		Master.mainPanel = new JPanel(new GridLayout(2, 1));
		Master.displaysPanel = new JPanel(new GridLayout(4, 1));
		Master.buttonsPanel = new JPanel();
		Master.buttonsPanel.setLayout(new GridLayout(5, 4));
		
		Master.inputLabel = new JLabel("Problem:");
		Master.outputLabel = new JLabel("Solutiion:");
		
		Master.inputField = new JTextField(30);
		Master.inputField.setSelectedTextColor(Color.WHITE);
		Master.outputField = new JTextField(30);
		Master.outputField.setEditable(false);
		
		Master.displaysPanel.add(Master.inputLabel);
		Master.displaysPanel.add(Master.inputField);
		Master.displaysPanel.add(Master.outputLabel);
		Master.displaysPanel.add(Master.outputField);
		
		Master.mainPanel.add(Master.displaysPanel);
		
		Master.container.add(Master.mainPanel);
		
		Master.mainFrame.setSize(400, 600);
		Master.mainFrame.pack();
		Master.mainFrame.setLocationRelativeTo(null);
		Master.mainFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		Master.mainFrame.setVisible(true);
	}

}
