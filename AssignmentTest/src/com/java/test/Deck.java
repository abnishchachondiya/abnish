package com.java.test;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	public  List <Card> cardDeck;
	
		public Deck(){
			this.cardDeck=new ArrayList<Card>();
		
			for(int value=1;value<=13;value++){
				for(Suit suit:Suit.values()){
					cardDeck.add(new Card(value,suit));
				}//firstLoop
			}//Second Loop
		}//Constructor	
		
}//class



