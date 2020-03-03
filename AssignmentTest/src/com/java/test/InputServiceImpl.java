package com.java.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class InputServiceImpl implements InputService {
	
	HashSet<String> name=new HashSet<String>();
	HashMap<String,Card> hashMap=new HashMap<>();
	static Deck de=new Deck();
	
	@Override
	public  void startTheGame() {
		
			System.out.println("Enter The Number Of Player You Want to Play:");
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			int numbur=sc.nextInt();
			
			
			for(int i=0;i<numbur;i++){
				System.out.println("Enter Name Of The Players:"+""+(i+1));
				@SuppressWarnings("resource")
				Scanner scr=new Scanner(System.in);
				String player = scr.nextLine(); 
				name.add(player);
				 Random rand = new Random(); 
				 int x=rand.nextInt(de.cardDeck.size());
				 Card d1=de.cardDeck.get(x);
				 hashMap.put(player, d1);
				 de.cardDeck.remove(x);
			  
			}
			
	}

	@Override
	public void printTheHoldingCard() {
		System.out.println("Players Holding Card Is:");
		System.out.println(hashMap);
		
	}

	@Override
	public void findWinner() {
		
		Collection<Card> c=hashMap.values();
		int nO=c.size();
		List<Card> arrayList=new ArrayList<Card>();
		//System.out.println("Size Of nO Object:"+""+nO);
		//System.out.println("THE "+""+c);
		Iterator<Card> itr=c.iterator();
		
		while(itr.hasNext()){
				Card c1=(Card)itr.next();
				if(arrayList.isEmpty()){
					arrayList.add(c1);
				}
				else{
					ListIterator<Card> itrr=arrayList.listIterator();
					int value1=c1.faceValue;
					Suit suit1=c1.suit;
					while (itrr.hasNext()) { 
						Card c2=(Card)itrr.next();
			           int value2=c2.faceValue;
			           Suit suit2=c2.suit;
			           
			           if(value1==value2 && suit2!=suit1){
			        	   itrr.add(c1);
			           }
			           else if(value1>value2){
			        	   arrayList.clear();
			        	   arrayList.add(c1);
			           }
			           

					}
				}
			
		}
		
		
		int flag=0;
		
		Iterator ltr=arrayList.iterator();
		while(ltr.hasNext()){
			Card c3=(Card)ltr.next();
			Suit suit3=c3.suit;
			if(suit3==Suit.SPADE){
				System.out.println("The Winner Is:"+""+c3);
				flag=1;
			}
		}
		
		if(flag!=1){
		Iterator ltr2=arrayList.iterator();
		while(ltr2.hasNext()){
			Card c3=(Card)ltr2.next();
			Suit suit3=c3.suit;
			if(suit3==Suit.HEART){
				System.out.println("The Winner Is:"+""+c3);
				flag=1;
			}
		}
		}
		
		if(flag!=1){
		Iterator ltr3=arrayList.iterator();
		while(ltr3.hasNext()){
			Card c3=(Card)ltr3.next();
			Suit suit3=c3.suit;
			if(suit3==Suit.CLUB){
				System.out.println("The Winner Is:"+""+c3);
				flag=1;
			}
		}
		}
		
		
		if(flag!=1){
		Iterator ltr4=arrayList.iterator();
		while(ltr4.hasNext()){
			Card c3=(Card)ltr4.next();
			Suit suit3=c3.suit;
			if(suit3==Suit.DIAMOND){
				System.out.println("The Winner Is:"+""+c3);
				break;
			}
		}
		}
		
		
		
	}

	@Override
	public void shuffleTheDeck() {
		Collections.shuffle(de.cardDeck);
		System.out.println("Deck Is Shuffled..!");
		
	}

	@Override
	public void addRemoveplayer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printAllPresentCard() {
		System.out.println("All Remaining/Present Card Is Here:");
		System.out.println(de.cardDeck);
		
	}

	@Override
	public void finishTheGame() {
		// TODO Auto-generated method stub
		
	}

}
