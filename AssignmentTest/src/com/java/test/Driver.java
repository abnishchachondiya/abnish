package com.java.test;


import java.util.Scanner;

public class Driver {
	static Deck deck=new Deck();
	static InputServiceImpl impl=new InputServiceImpl();
	public static void main(String [] args){
			
		
		
		while(true){
			
			@SuppressWarnings("resource")
			
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter The Choice");
			System.out.println("1:Start the game.");
			System.out.println("2:Print the card each player is holding..");
			System.out.println("3:Find the winner of the game..");
			System.out.println("4:Shuffle the deck.");	
			System.out.println("5:Print all the cards present in the deck.");
			System.out.println("6:Add/Remove player(s) to the game.");
			System.out.println("7:Finish the game by returning all cards back to the deck.");
			System.out.println("8:Exit.");
			
			
			final int choice=scan.nextInt();
		
			switch (choice) {
				case 1:
						impl.startTheGame();
						break;
				case 2:
						impl.printTheHoldingCard();
						break;

				case 3:
						impl.findWinner();
						break;
				
				case 4:
						impl.shuffleTheDeck();
						break;
				case 5:
						impl.printAllPresentCard();
						break;
			
				case 6:
						impl.addRemoveplayer();
						break;
				case 7:
						impl.finishTheGame();
						break;
				case 8:
						System.exit(0);
						break;
		
				default:
						break;
		}//switch
		
	}//loop	
		
}//main
	
	

}//class
