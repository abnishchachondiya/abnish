package com.java.test;

public class Card {
	 int faceValue;
	Suit suit;
	
	public Card(int faceValue,Suit suit){
		this.faceValue=faceValue;
		this.suit=suit;
	}
	
	public String toString(){
		return  faceValue+"-"+suit;
	}
}

