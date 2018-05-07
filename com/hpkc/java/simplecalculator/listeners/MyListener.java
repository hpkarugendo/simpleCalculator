package com.hpkc.java.simplecalculator.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.hpkc.java.simplecalculator.logic.Master;

public class MyListener implements ActionListener{

	public MyListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = Master.inputField.getText().toString().trim();
		switch(e.getActionCommand()) {
		case "off":
			System.exit(0);
			break;
		case "clear":
			Master.inputField.setText("");
			Master.outputField.setText("");
			Master.inputString = "";
			Master.resultString = "";
			break;
		case "back":
			s = Master.inputField.getText().toString().trim();
			Master.inputField.setText(s.substring(0, s.length()-1));
			break;
		case "multiply":
			s = Master.inputField.getText().toString().trim();
			Master.inputField.setText(s + "*");
			break;
		case "1":
			s = Master.inputField.getText().toString().trim();
			Master.inputField.setText(s + "1");
			break;
		case "2":
			s = Master.inputField.getText().toString().trim();
			Master.inputField.setText(s + "2");
			break;
		case "3":
			s = Master.inputField.getText().toString().trim();
			Master.inputField.setText(s + "3");
			break;
		case "divide":
			s = Master.inputField.getText().toString().trim();
			Master.inputField.setText(s + "/");
			break;
		case "4":
			s = Master.inputField.getText().toString().trim();
			Master.inputField.setText(s + "4");
			break;
		case "5":
			s = Master.inputField.getText().toString().trim();
			Master.inputField.setText(s + "5");
			break;
		case "6":
			s = Master.inputField.getText().toString().trim();
			Master.inputField.setText(s + "6");
			break;
		case "add":
			s = Master.inputField.getText().toString().trim();
			Master.inputField.setText(s + "+");
			break;
		case "7":
			s = Master.inputField.getText().toString().trim();
			Master.inputField.setText(s + "7");
			break;
		case "8":
			s = Master.inputField.getText().toString().trim();
			Master.inputField.setText(s + "8");
			break;
		case "9":
			s = Master.inputField.getText().toString().trim();
			Master.inputField.setText(s + "9");
			break;
		case "subtract":
			s = Master.inputField.getText().toString().trim();
			Master.inputField.setText(s + "-");
			break;
		case "0":
			s = Master.inputField.getText().toString().trim();
			Master.inputField.setText(s + "0");
			break;
		case "dot":
			s = Master.inputField.getText().toString().trim();
			Master.inputField.setText(s + ".");
			break;
		case "equal":
			s = Master.inputField.getText().toString().trim();
			Master.inputString = s;
			
			boolean first = false;
			
			if(!s.isEmpty()) {
				if(Master.isOperator(String.valueOf(s.charAt(0)))) {
					s = s.substring(1);
				}
					
					for(int a = 0; a < s.length(); a++) {
						if(Master.isOperator(String.valueOf(s.charAt(a)))) {
							first = true;
						}
					}
			}
			
			if(!first) {
				Master.finalResultString = Master.inputString;
				Master.outputField.setText(Master.finalResultString);
				Master.inputField.setText("");
			} else {
				
				if(Master.isValid()) {
					Master.inputString = Master.inputField.getText().toString().trim();
					Master.calculate();
					Master.outputField.setText(Master.finalResultString);
					Master.inputField.setText("");
				} else {
					JOptionPane.showMessageDialog(Master.mainFrame, "Check Your Inputs", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			Master.inputString = "";
			Master.finalResultString = "";
			
			break;
		}
	}

}
