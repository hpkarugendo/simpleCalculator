package com.hpkc.java.simplecalculator.logic;

/*
 * Author: Henry Patrick Karugendo
 * Date: 27th April 2018
 * 
 * This is the Logic Class where all the logic for the calculator takes place
 * From simple add/subtract/multiply/divide logic
 * To error checks to make sure entered equations can be operated on
 * To checking for the type of calculations, whether order is important or not
 * By order I mean that '*' and '/' come first before '+' and '-'
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Logic {

	private String inputString, inputString2;
	private char operatingChar1, operatingChar2;
	private float valueA = -999999;
	private float valueB = -999999;
	private float valueC = -999999;
	private float result = -999999;
	private static final char addChar = '+';
	private static final char subtractChar = '-';
	private static final char devideChar = '/';
	private static final char multiplyChar = '*';

	// This is a constructor that takes in the string to operate on
	public Logic(String in) {
		this.inputString = in;
	}

	// This method checks that the question is operable
	public boolean isOperable() {
		boolean ans = true;

		List<Character> only = new ArrayList<>();

		char[] allowed = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', '/', '*', '-', '+' };

		for (int i = 0; i < allowed.length; i++) {
			only.add(allowed[i]);
		}

		char firstC = inputString.charAt(0);
		char lastC = inputString.charAt(inputString.length() - 1);

		if (firstC == multiplyChar || firstC == devideChar) {
			if(ans) {
				System.out.println("!!!!!!! Bad Equation Entered !!!!!!");
			}
			ans = false;
			System.out.println("Can't Begin with '*' and '/' Operators!");
		}

		if (lastC == '/' || lastC == '*' || lastC == '+' || lastC == '-') {
			if(ans) {
				System.out.println("!!!!!!! Bad Equation Entered !!!!!!");
			}
			ans = false;
			System.out.println("Can't End with Operators!");
		}

		for (int i = 0; i < inputString.length(); i++) {
			if (!only.contains(inputString.charAt(i))) {
				if(ans) {
					System.out.println("!!!!!!! Bad Equation Entered !!!!!!");
				}
				ans = false;
				System.out.println("Contains Bad Characters!");
			}
			
			if(inputString.charAt(i) == '0' && i != 0) {
				if(inputString.charAt(i - 1) == '/') {
					if(ans) {
						System.out.println("!!!!!!! Bad Equation Entered !!!!!!");
					}
					ans = false;
					System.out.println("Can't Devide By Zero!");
				}
			}
		}

		return ans;
	}

	/*
	 * This is a method to check if a character is an operator It returns TRUE of
	 * FALSE depending on the answer
	 */
	public boolean isOperator(char c) {
		boolean itIs = false;

		switch (c) {
		case addChar:
			itIs = true;
			break;
		case subtractChar:
			itIs = true;
			break;
		case devideChar:
			itIs = true;
			break;
		case multiplyChar:
			itIs = true;
			break;
		default:
			itIs = false;
			break;
		}

		return itIs;
	}

	/*
	 * This is a method to check if the question is complex This means that the
	 * question has level 1 and level 2 calculations / and * are level 1 and + and -
	 * are level 2
	 */
	public boolean hasComplexOps() {
		// This means if calculation contains ADDITION and SUBTRACTION
		boolean hasAlpha = false;
		// This means if calculation contains MULTIPLICATION and DIVISION
		boolean hasBeta = false;
		boolean ans = false;

		String s = this.inputString;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '-' || s.charAt(i) == '+') {
				hasAlpha = true;
			} else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
				hasBeta = true;
			}
		}

		if (hasAlpha && hasBeta) {
			ans = true;
		}

		return ans;
	}

	public boolean hasComplexOps(String s) {
		// This means if calculation contains ADDITION and SUBTRACTION
		boolean hasAlpha = false;
		// This means if calculation contains MULTIPLICATION and DIVISION
		boolean hasBeta = false;
		boolean ans = false;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '-' || s.charAt(i) == '+') {
				hasAlpha = true;
			} else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
				hasBeta = true;
			}
		}

		if (hasAlpha && hasBeta) {
			ans = true;
		}

		return ans;
	}

	// Method to add numbers;
	public float add(float a, float b) {
		float ans = 0;

		ans = a + b;

		return ans;
	}

	// Method to divide numbers;
	public float divide(float a, float b) {
		float ans = 0;

		ans = a / b;

		return ans;
	}

	// Method to subtract numbers;
	public float subtract(float a, float b) {
		float ans = 0;

		ans = a - b;

		return ans;
	}

	// Method to multiply numbers;
	public float multiply(float a, float b) {
		float ans = 0;

		ans = a * b;

		return ans;
	}

	// This is the actual calculation logic method
	public void calculate() {

		switch (operatingChar1) {
		case addChar:
			setResult(add(valueA, valueB));
			break;
		case subtractChar:
			setResult(subtract(valueA, valueB));
			break;
		case multiplyChar:
			setResult(multiply(valueA, valueB));
			break;
		case devideChar:
			setResult(divide(valueA, valueB));
			break;
		}

	}

	// Method to do simple calculation
	public void simpleOp() {
		System.out.println("======= This is a Simple Calculation ==========");

		Queue<Character> q = new LinkedList<Character>();
		String value1 = "";
		String value2 = "";
		String tempString = "";
		String tempAns = "";
		char op = ' ';

		for (int i = 0; i < inputString.length(); i++) {
			q.add(inputString.charAt(i));
		}
		
		if(isOperator(q.element())) {
			value1 = "" + q.remove();
		}

		while (!q.isEmpty()) {

				if(tempAns.isEmpty()) {
					while (!isOperator(q.element())) {
						value1 = value1 + q.remove();
					}
					valueA = Float.parseFloat(value1);
					op = q.remove();
					while (!q.isEmpty() && !isOperator(q.element())) {
						value2 = value2 + q.remove();
					}
					valueB = Float.parseFloat(value2);
					
					if(op == '/') {
						operatingChar1 = devideChar;
					}else if(op == '*') {
						operatingChar1 = multiplyChar;
					}else if(op == '-') {
						operatingChar1 = subtractChar;
					}else if(op == '+') {
						operatingChar1 = addChar;
					}

					calculate();
					
					tempAns = String.valueOf(result);
				} else {
					valueA = Float.valueOf(tempAns);
					value2 = "";
					if(!q.isEmpty()) {
						if(isOperator(q.element())) {
							op = q.remove();
						}
						
						while (!q.isEmpty() && !isOperator(q.element())) {
							value2 = value2 + q.remove();
						}
						valueB = Float.valueOf(value2);
						
						if(op == '/') {
							operatingChar1 = devideChar;
						}else if(op == '*') {
							operatingChar1 = multiplyChar;
						}else if(op == '-') {
							operatingChar1 = subtractChar;
						}else if(op == '+') {
							operatingChar1 = addChar;
						}
						
						calculate();
						
						tempAns = String.valueOf(result);
					}
				}
				
				System.out.println("Next Op is: " + valueA + " " + operatingChar1 + " " + valueB + " with Ans: " + result);
		}
		result = Float.valueOf(tempAns);
		System.out.println("======= The Final Answer is: " + getResult() + " ==========");
	}

	// Method to tackle complex calculation
	public void complexOp() {
		System.out.println("======= This is a Complex Calculation:" + inputString + " ==========");

		Queue<Character> queue1 = new LinkedList<Character>();

		String value1 = "";
		String value2 = "";
		String value3 = "";
		String tempResult = "";
		String tempString = "";
		char op = ' ';

		for (int i = 0; i < inputString.length(); i++) {
			queue1.add(inputString.charAt(i));
		}

		if (!isOperator(queue1.element())) {
			value1 = value1 + queue1.remove();
		}
		
		while(!queue1.isEmpty()) {
			while(!isOperator(queue1.element())) {
				value1 = value1 + queue1.remove();
			}
			
			if(isOperator(queue1.element())){
				op = queue1.remove();
				
				while(!isOperator(queue1.element())) {
					value2 = value2 + queue1.remove();
				}
			}
			
			if(op != ' ') {
				if(op == '/' || op == '*') {
					valueA = Float.parseFloat(value1);
					valueB = Float.parseFloat(value2);
					
					if(op == '/') {
						operatingChar1 = devideChar;
					} else if(op == '*') {
						operatingChar1 = multiplyChar;
					}
					
					calculate();
					
					tempResult = String.valueOf(result);
					tempString = tempString + tempResult;
					
					if(!queue1.isEmpty()) {
						while(!queue1.isEmpty()) {
							tempString = tempString + queue1.remove();
						}
					}
				} else {
					tempString = tempString + value1 + op;
					
					
				}
			}
			
			System.out.println("The Final String is: " + tempString);
			inputString = tempString;
			tempString = "";
			value1 = "";
			value2 = "";
			op = ' ';
			
			if(!hasComplexOps(inputString)) {
				simpleOp();
			}
		}

		System.out.println("The Final Answer is: " + result);
	}

	public float getResult() {
		return result;
	}

	public void setResult(float result) {
		this.result = result;
	}
	
	public boolean isNumeric(String s) {
		boolean ans;
		
		try {
			float a = Float.parseFloat(s);
			ans = true;
		} catch (Exception e) {
			ans = false;
		}
		
		return ans;
	}

}
