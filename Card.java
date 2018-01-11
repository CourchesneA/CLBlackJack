
/*
 * 		COMP202 section 1
 * 		Assignment 3 question 2
 * 		Anthony Courchesne
 * 		McGill ID: 260688650
 * 		Last Edited: November 16, 2015
 */

public class Card {

	//attributes
	private Suit suit;
	private Value value;
	
	
	//constructor
	public Card(Suit theSuit, Value theValue){
		this.suit=theSuit;
		this.value=theValue;
	}
	
	
	//toString method
	public String toString(){
		if (this.value.ordinal()<12 && this.value.ordinal()>8){
			return this.value.toString().charAt(0)+"-"+this.suit.toString().charAt(0);
		}
		return ((this.value.ordinal()+1)%13+1)+"-"+this.suit.toString().charAt(0);
	}
	
	
	//getter & setter
	public Suit getSuit(){
		return this.suit;
	}
	public Value getValue(){
		return this.value;
	}
}
