
/*
 * 		COMP202 section 1
 * 		Assignment 3 question 4
 * 		Anthony Courchesne
 * 		McGill ID: 260688650
 * 		Last Edited: November 16, 2015
 */

public class CardGame {
	
	public static void main(String[] args){
		CardPile gameDeck=CardPile.makeFullDeck();
		int nbPlayers=Integer.parseInt(args[0]);
		CardPile[] playersHands=new CardPile[nbPlayers];
		for (int i=0;i<nbPlayers;i++){
			playersHands[i]=new CardPile();
		}
		
		//hand out cards
		for(int i=0;!gameDeck.isEmpty();i++){
			playersHands[i%(nbPlayers)].addToBottom(gameDeck.get(0));
			gameDeck.remove(0);
		}
		//find the Ace of Spades
		for(int i=0;i<nbPlayers;i++){
			if(playersHands[i].find(Suit.SPADES, Value.ACE)!=-1){
				System.out.println("The winner is Player"+(i+1));
				return;			//Just to stop the program for running uselessly
			}
			
		}
		System.out.println("player1 hands: "+playersHands[0]);
		System.out.println("player2 hands: "+playersHands[1]);



	}

}
