
package casino;

import java.util.*;

public class Card{
	
	String suit;
	int value;
	String color;
	String specialName;
	
	public Card(int value, String suit){
		this.value = value;
		this.suit = suit;
		
		color = createColor();
		
		specialName = createSpecialName();
	}
	
	public int getValue(){
		return value;
	}
	
	public int getBlackjackValue(){
		int value = 0;
		if(getValue()>10){
			value = 10;
		}else{
			value = getValue();
		}
		return value;
	}
	
	public String getColor(){
		return color;
	}
	public String getSuit(){
		return suit;
	}
	
	public String toString(){
		if(this.hasSpecialName()){
			return specialName + " of " + suit;
		}else{
			return value + " of " + suit;
		}
	}
	
	
	public boolean hasSpecialName(){
		if(specialName == null){
			return false;
		}else{
			return true;
		}
	}
	
	
	public boolean isHigherThan(Card otherCard){
		if(this.value>otherCard.value){
			return true;
		}else{
			return false;
		}
	}
	
	public String createSpecialName(){
		String specialName;
		if(value == 1){
			specialName = "Ace";
		}else if(value == 11){
			specialName = "Jack";
		}else if(value == 12){
			specialName = "Queen";
		}else if(value == 13){
			specialName = "King";
		}else{
			specialName = null;
		}
		return specialName;
	}
	
	public String createColor(){
		String color; 
		if(suit == "Hearts" || suit == "Diamonds"){
			color = "red";
		}else{
			color = "black";
		}
		return color;
	}
}