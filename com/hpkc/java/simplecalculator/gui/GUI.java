package com.hpkc.java.simplecalculator.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class GUI extends JFrame{
	
	private JPanel mainPanel, displayPanel, inputButtonsPanel, calButtonsPanel;
	private JTextField inputField;
	private JTextArea display;
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, addButton, subButton, multiButton, divButton, goButton;

	public GUI() {
		setTitle("Simple Calculator");
		setSize(400, 600);
		
		
		mainPanel = new JPanel(new MigLayout("wrap 1"));
		displayPanel = new JPanel();
		display = new JTextArea(4, 20);
		display.setText("3.5*4");
		display.setEditable(false);
		display.setFont(new Font("Ny Font", Font.CENTER_BASELINE, 20));
		display.setForeground(Color.GRAY);
		
		b1 = new JButton("1");
		
		displayPanel.add(display);
		mainPanel.add(displayPanel);
		
		getContentPane().add(mainPanel);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
