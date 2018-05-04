package com.hpkc.java.simplecalculator.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public abstract class Master {
	public static String inputString = "+2/4*2+9/3-1";
	public static String valueAstring = "";
	public static String valueBstring = "";
	public static String resultString = "";
	public static String op = "";
	public static String initialOp = "";
	public static String replacer = "zed";
	public static String tokenString = "";
	public static String finalResultString = "";
	
	public static int valueAindex = 0;
	public static int valueBindex = 0;
	public static int opIndex = 0;
	
	public static float valueA = 0;
	public static float valueB = 0;
	public static float result = 0;
	
	public static StringTokenizer token = new StringTokenizer(inputString, "+-*/", true);
	
	public static List<String> list = new ArrayList<>();
	
	
	
	public static boolean isOperator(String c) {
		boolean ans = false;
		
		switch(c) {
		case "*":
			ans = true;
			break;
		case "/":
			ans = true;
			break;
		case "+":
			ans = true;
			break;
		case "-":
			ans = true;
			break;
		}
		
		return ans;
	}
	
	public static boolean isSimpleOp(String s) {
		boolean lvl1 = false;
		boolean lvl2 = false;
		boolean ans;
		
		for(int a = 0; a < Master.inputString.length(); a++) {
			if(Master.inputString.charAt(a) == '*' || Master.inputString.charAt(a) == '/') {
				lvl2 = true;
			} else if(Master.inputString.charAt(a) == '+' || Master.inputString.charAt(a) == '-'){
				lvl1 = true;
			}
		}
		
		if(lvl1 == true && lvl2 == true) {
			ans = false;
		} else {
			ans = true;
		}
		
		return ans;
	}
	
	public static void simpleOp() {
		Master.opIndex = 1;
		Master.valueAindex = Master.opIndex - 1;
		Master.valueBindex = Master.opIndex + 1;
		if(!initialOp.isEmpty()) {
			Master.valueAstring = initialOp + Master.list.get(Master.valueAindex);
			initialOp = "";
		} else {
			Master.valueAstring = Master.list.get(Master.valueAindex);
		}
		Master.valueBstring = Master.list.get(Master.valueBindex);
		Master.op = Master.list.get(Master.opIndex);
		Master.valueA = Float.parseFloat(Master.valueAstring);
		Master.valueB = Float.parseFloat(Master.valueBstring);
		
		switch (Master.op) {
		case "*":
			Master.result = (Master.valueA * Master.valueB);
			Master.resultString = String.valueOf(Master.result);
			Master.list.set(Master.valueAindex, Master.resultString);
			Master.list.remove(1);
			Master.list.remove(1);
			System.out.println("Working on :" + Master.valueAstring + " * " + Master.valueBstring + " With Ans: " + Master.list.get(0));
			break;
		case "/":
			Master.result = (Master.valueA / Master.valueB);
			Master.resultString = String.valueOf(Master.result);
			Master.list.set(Master.valueAindex, Master.resultString);
			Master.list.remove(1);
			Master.list.remove(1);
			System.out.println("Working on :" + Master.valueAstring + " / " + Master.valueBstring + " With Ans: " + Master.list.get(0));
			break;
		case "+":
			Master.result = (Master.valueA + Master.valueB);
			Master.resultString = String.valueOf(Master.result);
			Master.list.set(Master.valueAindex, Master.resultString);
			Master.list.remove(1);
			Master.list.remove(1);
			System.out.println("Working on :" + Master.valueAstring + " + " + Master.valueBstring + " With Ans: " + Master.list.get(0));
			break;
		case "-":
			Master.result = (Master.valueA - Master.valueB);
			Master.resultString = String.valueOf(Master.result);
			Master.list.set(Master.valueAindex, Master.resultString);
			Master.list.remove(1);
			Master.list.remove(1);
			System.out.println("Working on :" + Master.valueAstring + " - " + Master.valueBstring + " With Ans: " + Master.list.get(0));
			break;
		}
		
		for(int z = 0; z < Master.list.size(); z++) {
			inputString = inputString + Master.list.get(z);
		}
		token = new StringTokenizer(inputString, "+-*/", true);
		if(Master.isOperator(Master.list.get(0))) {
			Master.initialOp = Master.list.remove(0);
		}
	}
	
	public static void complexOp() {
		for(int a = 0; a < Master.list.size(); a++) {
			String defOp = Master.list.get(a);
			if(Master.isOperator(defOp)) {
				if(defOp.equalsIgnoreCase("*") || defOp.equalsIgnoreCase("/")) {
					Master.opIndex = a;
					Master.valueAindex = Master.opIndex - 1;
					Master.valueBindex = Master.opIndex + 1;
					if(!initialOp.isEmpty()) {
						Master.valueAstring = initialOp + Master.list.get(Master.valueAindex);
						initialOp = "";
					} else {
						Master.valueAstring = Master.list.get(Master.valueAindex);
					}
					Master.valueBstring = Master.list.get(Master.valueBindex);
					Master.op = Master.list.get(Master.opIndex);
					Master.valueA = Float.valueOf(Master.valueAstring);
					Master.valueB = Float.valueOf(Master.valueBstring);
					
					switch (Master.op) {
					case "*":
						Master.result = Master.valueA * Master.valueB;
						Master.resultString = String.valueOf(Master.result);
						Master.list.set(a-1, Master.resultString);
						Master.list.remove(a);
						Master.list.remove(a);
						System.out.println("Working on :" + Master.valueAstring + " * " + Master.valueBstring + " With Ans: " + Master.list.get(Master.valueAindex));
						break;
					case "/":
						Master.result = Master.valueA / Master.valueB;
						Master.resultString = String.valueOf(Master.result);
						Master.list.set(a-1, Master.resultString);
						Master.list.remove(a);
						Master.list.remove(a);
						System.out.println("Working on :" + Master.valueAstring + " / " + Master.valueBstring + " With Ans: " + Master.list.get(Master.valueAindex));
						break;
					}
					
					inputString = "";
					
					for(int z = 0; z < Master.list.size(); z++) {
						inputString = inputString + Master.list.get(z);
					}
					token = new StringTokenizer(inputString, "+-*/", true);
					if(Master.isOperator(Master.list.get(0))) {
						Master.initialOp = Master.list.remove(0);
					}
				}
			}
		}
	}
}
