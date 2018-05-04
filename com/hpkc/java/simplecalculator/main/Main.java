package com.hpkc.java.simplecalculator.main;

import java.util.StringTokenizer;

import javax.swing.text.StringContent;

import com.hpkc.java.simplecalculator.gui.GUI;
import com.hpkc.java.simplecalculator.logic.Logic;
import com.hpkc.java.simplecalculator.logic.Master;
import com.hpkc.java.simplecalculator.logic.MyTokenizer;

public class Main {

	public static void main(String[] args) {
		
		while(Master.token.hasMoreTokens()) {
			Master.list.add(Master.token.nextToken().toString());
		}
		
		if(Master.isOperator(Master.list.get(0))) {
			Master.initialOp = Master.list.remove(0);
		}
		
		while(Master.list.size() > 2) {
			
			if(Master.isSimpleOp(Master.inputString)) {
				Master.simpleOp();
			} else {
				Master.complexOp();
			}
		}
		
		System.out.println("Final Answer is: " + Master.resultString);

	}

}
