package com.hpkc.java.simplecalculator.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hpkc.java.simplecalculator.listeners.MyListener;
import com.hpkc.java.simplecalculator.logic.Master;

import net.miginfocom.swing.MigLayout;

public class GUI{
	
	public GUI() {
		Master.mainFrame = new JFrame("Simple Calculator");
		
		Master.container = Master.mainFrame.getContentPane();
		
		Master.mainPanel = new JPanel(new MigLayout("wrap 1"));
		Master.displaysPanel = new JPanel(new MigLayout("wrap 1"));
		Master.buttonsPanel = new JPanel(new MigLayout("wrap 4"));
		
		Master.inputLabel = new JLabel("Problem:");
		Master.outputLabel = new JLabel("Solutiion:");
		
		Font f = new Font("Arial", Font.PLAIN, 20);
		
		Master.inputField = new JTextField(14);
		Master.inputField.setText(Master.displayString);
		Master.inputField.setFont(f);
		Master.inputField.setSelectedTextColor(Color.WHITE);
		Master.outputField = new JTextField(14);
		Master.outputField.setText(Master.finalResultString);
		Master.outputField.setFont(f);
		Master.outputField.setEditable(false);
		
		Master.offB = new JButton("OFF");
		Master.offB.setActionCommand("off");
		Master.offB.addActionListener(new MyListener());
		Master.clearB = new JButton("CLR");
		Master.clearB.setActionCommand("clear");
		Master.clearB.addActionListener(new MyListener());
		Master.backB = new JButton("BCK");
		Master.backB.setActionCommand("back");
		Master.backB.addActionListener(new MyListener());
		Master.multiplyB = new JButton("x");
		Master.multiplyB.setActionCommand("multiply");
		Master.multiplyB.addActionListener(new MyListener());
		Master.divideB = new JButton("÷");
		Master.divideB.setActionCommand("divide");
		Master.divideB.addActionListener(new MyListener());
		Master.addB = new JButton("+");
		Master.addB.setActionCommand("add");
		Master.addB.addActionListener(new MyListener());
		Master.subtractB = new JButton("-");
		Master.subtractB.setActionCommand("subtract");
		Master.subtractB.addActionListener(new MyListener());
		Master.equalB = new JButton("=");
		Master.equalB.setActionCommand("equal");
		Master.equalB.addActionListener(new MyListener());
		Master.dotB = new JButton("·");
		Master.dotB.setActionCommand("dot");
		Master.dotB.addActionListener(new MyListener());
		Master.num0B = new JButton("0");
		Master.num0B.setActionCommand("0");
		Master.num0B.addActionListener(new MyListener());
		Master.num1B = new JButton("1");
		Master.num1B.setActionCommand("1");
		Master.num1B.addActionListener(new MyListener());
		Master.num2B = new JButton("2");
		Master.num2B.setActionCommand("2");
		Master.num2B.addActionListener(new MyListener());
		Master.num3B = new JButton("3");
		Master.num3B.setActionCommand("3");
		Master.num3B.addActionListener(new MyListener());
		Master.num4B = new JButton("4");
		Master.num4B.setActionCommand("4");
		Master.num4B.addActionListener(new MyListener());
		Master.num5B = new JButton("5");
		Master.num5B.setActionCommand("5");
		Master.num5B.addActionListener(new MyListener());
		Master.num6B = new JButton("6");
		Master.num6B.setActionCommand("6");
		Master.num6B.addActionListener(new MyListener());
		Master.num7B = new JButton("7");
		Master.num7B.setActionCommand("7");
		Master.num7B.addActionListener(new MyListener());
		Master.num8B = new JButton("8");
		Master.num8B.setActionCommand("8");
		Master.num8B.addActionListener(new MyListener());
		Master.num9B = new JButton("9");
		Master.num9B.setActionCommand("9");
		Master.num9B.addActionListener(new MyListener());
		
		Master.displaysPanel.add(Master.inputLabel);
		Master.displaysPanel.add(Master.inputField);
		Master.displaysPanel.add(Master.outputLabel);
		Master.displaysPanel.add(Master.outputField);
		
		Master.buttonsPanel.add(Master.offB);
		Master.buttonsPanel.add(Master.clearB);
		Master.buttonsPanel.add(Master.backB);
		Master.buttonsPanel.add(Master.multiplyB);
		Master.buttonsPanel.add(Master.num1B);
		Master.buttonsPanel.add(Master.num2B);
		Master.buttonsPanel.add(Master.num3B);
		Master.buttonsPanel.add(Master.divideB, "grow");
		Master.buttonsPanel.add(Master.num4B);
		Master.buttonsPanel.add(Master.num5B);
		Master.buttonsPanel.add(Master.num6B);
		Master.buttonsPanel.add(Master.addB, "grow");
		Master.buttonsPanel.add(Master.num7B);
		Master.buttonsPanel.add(Master.num8B);
		Master.buttonsPanel.add(Master.num9B);
		Master.buttonsPanel.add(Master.subtractB, "grow");
		Master.buttonsPanel.add(Master.num0B);
		Master.buttonsPanel.add(Master.dotB);
		Master.buttonsPanel.add(Master.equalB, "span2, grow");
		
		Master.mainPanel.add(Master.displaysPanel);
		Master.mainPanel.add(Master.buttonsPanel);
		
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
