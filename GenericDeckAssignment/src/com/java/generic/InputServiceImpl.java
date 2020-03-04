package com.java.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;










public class InputServiceImpl implements InputService {
	HashSet<String> playerName=new HashSet<String>();
	ArrayList<ArrayList<Card>> mainArrayList = new ArrayList<ArrayList<Card>>();//This Is List Where SubList Will Add
	HashMap<String,ArrayList<Card>> hashMap=new HashMap<String,ArrayList<Card>>();//<Name Of Player,list of player card>
	static Deck de=new Deck();
	
	
	
	
	//Start The Game Functionality Where We Will Ask For Number Of Player And add one card to with each player
	//for the second card picking functionality will implement in  getOneMoreCards () Method Here We will start the game with one Happy card!
	@Override
	public void startTheGame() {
		
		System.out.println("Enter The Number Of Player You Want to Play:");//Asking For How Many Player will Player
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);									//Enter The Number
		int number=sc.nextInt();
		ArrayList<Card> subArrayList;					
		
		
		for(int i=0;i<number;i++) { //Creating the list equals to player
			
			subArrayList = new ArrayList<Card>();
			
			System.out.println("Enter Name Of The Players:"+""+(i+1));				//getting players name
			@SuppressWarnings("resource")
			Scanner scanner1=new Scanner(System.in);
			String player = scanner1.nextLine(); 									//reading players name
			
			playerName.add(player);
			
			Random rand = new Random(); 
			 int x=rand.nextInt(de.cardDeck.size());								//getting random number
			
			 Card card=de.cardDeck.get(x);											//get card detail
			 subArrayList.add(card);												//add card detail in sublist
			 mainArrayList.add(subArrayList);										//add sublist in main list
			 hashMap.put(player,subArrayList );										//add the list in hashMap with player name 
			 de.cardDeck.remove(x);													//remove card from deck
		 

		}
		
		

		
	}

	
	
	
	
	//Printing the Holding Card With The Name Of The Player
	@Override
	public void printTheHoldingCard() {
		System.out.println("In The printTheHoldingCard");
		System.out.println(hashMap);
		
	}
	
	
	//here We Are Going to Find the Winner
	@Override
	public void findWinner() {
		
		
		ArrayList<Card> subList = mainArrayList.get(0);
		int subArraySize=subList.size();
		
		
		
		if(subArraySize==1){
			
			Iterator itrerator=mainArrayList.iterator();
			ArrayList<Card> newArrayList=new ArrayList<Card>();
			
			while(itrerator.hasNext()){
				ArrayList<Card> getCard=(ArrayList<Card>)itrerator.next();
				Card cardNew=getCard.get(0);
				
					if(newArrayList.isEmpty()){
								newArrayList.add(cardNew);
					}
					else{
					
					
								ListIterator<Card> listIterator=newArrayList.listIterator();
								int value1=cardNew.faceValue;
								Suit suit1=cardNew.suit;
					
							while (listIterator.hasNext()) { 
								Card card2=(Card)listIterator.next();
								int value2=card2.faceValue;
			           			Suit suit2=card2.suit;
			           
			           				if(value1==value2 && suit2!=suit1){
			           						listIterator.add(cardNew);
			           				}
			           				else if(value1>value2){
			           						newArrayList.clear();
			           						newArrayList.add(cardNew);
			           				}
			           

							}
					}
				}
			
			int flag=0;
			
			for (Suit suitValue : Suit.values()) { 
				
				for(int a=0;a<newArrayList.size();a++){
					Card cardFinal=(Card)newArrayList.get(a);
					
					if (cardFinal.suit==suitValue){
						System.out.println("The Final Winner Is:"+""+cardFinal); 
						flag=1;
						cardFinal=null;
						break;
						
					}
					
				}
				if(flag==1)
					break;
				
			   
			}
			
			System.out.println("The Final List Is:"+""+newArrayList);
			newArrayList.clear();
			newArrayList=null;
			
			}//first If
		else{//if player hold more than one card will find out creative lucky winner
			//we will decide the winner by lucky random number it is called lucky Winner because card totally based on the luck
				
			Random random = new Random(); 
			int number=random.nextInt(mainArrayList.size());								//getting random number
			
			System.out.println("The Lucky Number Is:"+""+number);
				
			ArrayList<Card> luckyList=mainArrayList.get(number);
			
			int luckyNumber=random.nextInt(luckyList.size());
			
			System.out.println("The LUCKY WINNER IS:"+""+luckyList.get(luckyNumber));
					
			
		}//first else
			

		subList=null;
		
		
		
		System.out.println("In The findWinner");
	}//findWinner

	
	//Shuffle The Deck
	@Override
	public void shuffleTheDeck() {
		Collections.shuffle(de.cardDeck);
		System.out.println("Deck Is Shuffled..!");
		
	}//shuffleTheDeck

	
	
	//Add New Player and Remove Previous Player
	@Override
	public void addRemoveplayer() {
		
		System.out.println("Enter Your choice ");
		System.out.println("9:ADD PLAYER ");
		System.out.println("10:REMOVE PLAYER");
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		int choice = scanner.nextInt(); 
		
		
		if(choice==9){
			
				ArrayList<Card>subArrayList = new ArrayList<Card>();
				System.out.println("Enter Name Of The NEW Players:");
				@SuppressWarnings("resource")
				Scanner scannerNew=new Scanner(System.in);
				String playerNew = scannerNew.nextLine(); //reading players name
				playerName.add(playerNew);
				
				
				Random rand = new Random(); 
				 int x=rand.nextInt(de.cardDeck.size());								//getting random number
				
				 Card card=de.cardDeck.get(x);											//get card detail
				 subArrayList.add(card);												//add card detail in sublist
				 mainArrayList.add(subArrayList);										//add sublist in main list
				 hashMap.put(playerNew,subArrayList );									//add the list in hashMap with player name 
				 de.cardDeck.remove(x);				
				
			
				System.out.println("ONE NEW PLAYER IS ADDED ENJOY THE GAME!");
		}
		else if (choice==10){
			
			System.out.println("Enter The Player Name Which You Want To Remove");
			System.out.println(playerName);
			
			Scanner scRmv=new Scanner(System.in);								//get the name of the player
			String removePlayer = scRmv.nextLine(); 
			
			ArrayList<Card> removeList=hashMap.get(removePlayer);				//get the list of that player
			
			for(int i=0;i<removeList.size();i++){
					Card card=removeList.get(i);								//add all the card back to the deck
					de.cardDeck.add(card);
			}
			
			hashMap.remove(removePlayer);										//remove from map
			playerName.remove(removePlayer);									//remove from playerName list
			mainArrayList.remove(removeList);									//remove that player list from main list
			
			System.out.println("ONE PLAYER IS REMOVED ENJOY THE GAME!");
		}
		
		else{
			System.out.println("NO OTHER OPTION IS HERE");
		}
		
		
	}//addRemoveplayer

	
	
	
	//Print All The Present/Remaining Card In Deck
	@Override
	public void printAllPresentCard() {
		System.out.println("In The printAllPresentCard");
		System.out.println(de.cardDeck);
		
	}//printAllPresentCard

	
	
	
	//Finish The Game And Return All Card To The Deck
	//get all element from every list and add first to the deck and remove from the list one by one 
	@Override
	public void finishTheGame() {
		
		for(int i=0;i<mainArrayList.size();i++){						//getting size of main arraylist
			
			ArrayList<Card> subArray=mainArrayList.get(i);
			
			for(int j=0;j<subArray.size();j++){
				
					Card card=subArray.get(j);							//add that card back to DECK
					de.cardDeck.add(card);
					
			}
			
			
		}
		hashMap.clear();												//clear hashMap
		playerName.clear();												//clear playerName List
		mainArrayList.clear();
		
		System.out.println("GAME IS FINISHED DO YOU WANT TO PLAY MORE START THE  GAME AGAIN");
		
	}//finishTheGame

	
	//Get One Or More Card it means game is going to two or three or any number of card so every one will pick the card
	//condition like this because one player wont pick the card every player should pick the card.
	@Override
	public void getOneMoreCards() {
		
		for(int i=0;i<mainArrayList.size();i++){
			
			ArrayList<Card> subArrayList=mainArrayList.get(i);
			
			Random rand = new Random(); 
			 int x=rand.nextInt(de.cardDeck.size());								//getting random number
			
			 Card card=de.cardDeck.get(x);											//get card detail
			 subArrayList.add(card);												//add card detail in sublist				 
			 de.cardDeck.remove(x);		
			
		}// LOOP
	
		System.out.println("ONE MORE CARD IS PICKED BY PLAYERS!THANK YOU");
		
	}//getOneMoreCards

}//MAIN
