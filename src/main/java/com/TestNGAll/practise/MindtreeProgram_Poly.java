package com.TestNGAll.practise;


import java.io.IOException;


class Base{
	int value =0;
	Base(){
		addValue();
	}
	
	void addValue() {
		value +=10;
	}
	
	int getValue() {
		return value;
	}
	
}

class Derived extends Base{
	
	Derived(){
	addValue();
	}
	
	void addValue() {
		value +=20;
	}
}

public class MindtreeProgram_Poly {

	public static void main(String[] args) throws IOException {

		Base b =new Derived();
		System.out.println(b.getValue());
	}

}