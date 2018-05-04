package com.hpkc.java.simplecalculator.logic;

import java.util.StringTokenizer;

public class MyTokenizer {
	
	private String inputString;
	private StringTokenizer tokenizer;

	public MyTokenizer(String input) {
		this.inputString = input;
		this.tokenizer = new StringTokenizer(inputString, "*/+-", true);
	}

	public StringTokenizer getTokenizer() {
		return tokenizer;
	}

}
