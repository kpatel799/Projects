
package casino;



import java.util.*;

public class Casino{
	public static void main(String[] args){
		chooseGame();
	}
	
	
	public static void playBlackjack(){
		boolean wantToPlayBlackjack = true;
		double credit = getCredit();
		Deck myDeck = new Deck();
		while(wantToPlayBlackjack && credit>0){
			double bet;
			do{
				bet = makeBet();
			} while(bet>credit || bet<=0);
			
			Card playerCard1 = myDeck.drawNextCard();
			Card playerCard2 = myDeck.drawNextCard();
			int humanTotal = playerCard1.getBlackjackValue() + playerCard2.getBlackjackValue();
			System.out.println("Human cards: ");
			System.out.println(playerCard1.toString());
			printCardAndPoints(playerCard2,humanTotal);
			int cardCounter = 2;
			boolean wantAnotherCard;
			do{
				wantAnotherCard = wantAnotherCard();
				
				if(wantAnotherCard){
					Card newPlayerCard = myDeck.drawNextCard();
					humanTotal = humanTotal + newPlayerCard.getBlackjackValue();
					printCardAndPoints(newPlayerCard, humanTotal);
					cardCounter++;
					myDeck.discard(newPlayerCard);
				}
			}while(wantAnotherCard && cardCounter<=5 && humanTotal<21); 
			Card computerCard1 = myDeck.drawNextCard();
			Card computerCard2 = myDeck.drawNextCard();
			int computerTotal = computerCard1.getBlackjackValue() + computerCard2.getBlackjackValue();
			System.out.println("Computer cards: ");
			System.out.println(computerCard1.toString());
			printCardAndPoints(computerCard2, computerTotal);
			
			while(computerTotal<16){
				Card newComputerCard = myDeck.drawNextCard();
				computerTotal = computerTotal + newComputerCard.getBlackjackValue();
				printCardAndPoints(newComputerCard, computerTotal);
				myDeck.discard(newComputerCard);
			}
			
			myDeck.discard(playerCard1);
			myDeck.discard(playerCard2);
			myDeck.discard(computerCard1);
			myDeck.discard(computerCard2);
			
			credit = getNewCredit(humanTotal, computerTotal, credit, bet);
			if (credit>0){
				wantToPlayBlackjack = wantToKeepPlaying();
			}else{
				System.out.println("I'm sorry, you ran out of money");
			}
		}
	}
	
	public static boolean wantAnotherCard(){
		Scanner console = new Scanner(System.in);
		System.out.println("Do you want another card?");
		String reply = console.next();
		if(reply.charAt(0) == 'y' || reply.charAt(0) == 'Y'){
			return true;
		}else{
			return false;
		}
	}
	
	public static void printCardAndPoints(Card myCard, int points){
		System.out.println(myCard.toString());
		System.out.println("That's " + points + " points");
	}
	
	public static double getNewCredit(int humanTotal, int computerTotal, double credit, double bet){
		if(humanTotal<=21 && (humanTotal>computerTotal || computerTotal>21)){
			credit = credit + bet; 
			System.out.println("Human won. You get " + bet + " dollars. Now you have " + credit + " dollars.");
		}else if (computerTotal<=21 && (humanTotal<computerTotal || humanTotal>21)){
			credit = credit - bet; 
			System.out.println("Human lost. You lose " + bet + " dollars. Now you have " + credit + " dollars.");
		}else{
			System.out.println("Nobody wins! Your credit remains the same: " + credit + " dollars.");
		}
		return credit;
	}
	
	
	public static void playWar(){
		boolean wantToPlayWar = true;
		double credit = getCredit();
		Deck myDeck = new Deck();
		while(wantToPlayWar && credit>0){
			double bet;
			do{
				bet = makeBet();
			} while(bet>credit || bet<=0);
			Card playerCard = myDeck.drawNextCard();
			System.out.println("Human card: " + playerCard.toString());
			Card computerCard = myDeck.drawNextCard();
			System.out.println("Computer card: " + computerCard.toString());
			if(playerCard.isHigherThan(computerCard)){
				credit = credit + bet; 
				System.out.println("Human won. You get " + bet + " dollars. Now you have " + credit + " dollars.");
			}else{
				credit = credit - bet; 
				System.out.println("Human lost. You lose " + bet + " dollars. Now you have " + credit + " dollars.");
			}
			myDeck.discard(playerCard);
			myDeck.discard(computerCard);
			if (credit>0){
				wantToPlayWar = wantToKeepPlaying();
			}else{
				System.out.println("I'm sorry, you ran out of money to keep on playing at Antonella's cyber casino. The house always wins!");
			}
		}
	}
	
	public static void chooseGame(){
		Scanner console = new Scanner(System.in);
		System.out.println("Please, type c for card battle and b for blackjack");
		String reply = console.next();
		if(reply.charAt(0)== 'c'){
			playWar();
		}else{
			playBlackjack();
		}
	}

	
	public static double makeBet(){
		Scanner console = new Scanner(System.in);
		System.out.println("Please, enter the bet you want to make.");
		if(console.hasNextDouble()){
			return console.nextDouble();
		}else{
			return 0;
		}
	}
	
	public static double getCredit(){
		Scanner console = new Scanner(System.in);
		System.out.println("Please, enter the amount of money you have to spend");
		return console.nextDouble();
	}
	
	public static boolean wantToKeepPlaying(){
		Scanner console = new Scanner(System.in);
		System.out.println("Want to play another round?");
		String reply = console.next();
		if(reply.charAt(0) == 'y' || reply.charAt(0) == 'Y'){
			return true;
		}else{
			System.out.println("Thank you for visiting the casino");
			return false;
		}
	}
}