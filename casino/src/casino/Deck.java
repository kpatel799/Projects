
package casino;

import java.util.*;

public class Deck{
	
	public static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
	public static final int CARDS_IN_A_DECK = 52;
	public static final int CARDS_IN_A_SUIT = 13;
	Card[] activePile;
	Card[] discardPile;
	int numberOfActiveCards;
	int numberOfDiscardedCards;
	
	public Deck(){
		activePile = new Card[CARDS_IN_A_DECK];
		populate();
		discardPile = new Card[CARDS_IN_A_DECK];
		numberOfActiveCards = CARDS_IN_A_DECK;
		numberOfDiscardedCards = 0;
		shuffle();
	}
	
	public String toString(){
		String myString = "Number of cards in the deck: " + numberOfActiveCards;
		for(int i = 0; i < activePile.length; i++){
			Card card = activePile[i];
			if(card != null){
				myString = myString + "\n" + card.toString();
			}
		}
		return myString;
	}
	
	
	public void shuffle(){
		Random rand = new Random();
		for(int i = 1; i<CARDS_IN_A_DECK; i++){
			if(activePile[i] != null){
				int j;
				do{
					j = rand.nextInt(i + 1);
				} while(activePile[j]==null);
				swap(i, j);
			}
		}
	}
	
	public Card drawNextCard(){
		int position;
		if(numberOfActiveCards == 0){
			reorganizeDeck();
			position = 0;
		}else{
			position = CARDS_IN_A_DECK - numberOfActiveCards;
		}
		Card myCard = activePile[position];
		activePile[position] = null;
		numberOfActiveCards--;
		return myCard;
	}
	
	public void reorganizeDeck(){
		activePile = discardPile.clone();
		numberOfActiveCards = numberOfDiscardedCards;
		discardPile = new Card[52];
		numberOfDiscardedCards = 0;
		shuffle();
	}	
	
	public void discard(Card c){
		discardPile[numberOfDiscardedCards] = c;
		numberOfDiscardedCards++;
	}
	
	public void swap(int i, int j){
		Card temp = activePile[i];
		activePile[i] = activePile[j];
		activePile[j] = temp;
	}
	
	public void populate(){
		for(int i = 0; i<SUITS.length; i++){
			for(int cardValue = 1; cardValue<=CARDS_IN_A_SUIT; cardValue++){
				Card newCard = new Card(cardValue, SUITS[i]);
				activePile[(cardValue-1)+CARDS_IN_A_SUIT*i] = newCard;
			}
		}
	}
}