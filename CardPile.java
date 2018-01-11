

/*
 * 		COMP202 section 1
 * 		Assignment 3 question 3
 * 		Anthony Courchesne
 * 		McGill ID: 260688650
 * 		Last Edited: November 16, 2015
 */

public class CardPile {
	private int maxDeck=52;
	private Card[] cards= new Card[maxDeck];
	private int numCards;
	
	//constructor
	public CardPile(){
		this.cards=new Card[maxDeck];
		this.numCards=0;
	}
	
	
	
	public void addToBottom(Card c){
		if(numCards<52){
			this.cards[numCards++]=c;
		}
	}
	
	public boolean isEmpty(){
		if(numCards==0){
			return true;
		}
		return false;
	}
	
	public Card get(int i){		
		if(i>cards.length-1 || i<0){
			System.out.println("Index must be between 0 and 51");
			return null;
		}
		if(i>numCards){
			return null;
		}
			return (this.cards[i]);
	}
	
	public Card remove(int i){
		Card removed = this.cards[i];
		for(int j=i;j<numCards-1;j++){
			this.cards[j]=this.cards[j+1];
		}
		this.cards[numCards-1]=null;
		numCards--;
		return removed;
	}
	
	public int find(Suit s, Value v){
		Card ref=new Card(s,v);
		int index=-1;
		for(int i=0;i<this.numCards;i++){
			if (this.cards[i].toString().equals(ref.toString())){		//Comparing string else it compares addresses
				index=i;
			}
		}
		return index;
	}
	
	public String toString(){
		String output="";
		for(int i=0;i<numCards;i++){
			output=output+i+"."+this.cards[i]+" ";
		}
		return output;
	}
	
	public int cardNb(){
		return this.numCards;
	}
	
	public static CardPile makeFullDeck(){
		CardPile normDeck=new CardPile();
		for (Suit s:Suit.values()){
			for (Value v:Value.values()){
				normDeck.addToBottom(new Card(s, v));
			}
		}
		UtilityCode.shuffle(normDeck.cards, normDeck.numCards);
		return normDeck;
	}
	
	
	
	
	public static void main(String[] args){

		//CardPile cp1=makeFullDeck();
		CardPile cp1=new CardPile();
		System.out.println(cp1);

	}

}
