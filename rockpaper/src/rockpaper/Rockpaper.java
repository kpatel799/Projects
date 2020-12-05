
package rockpaper;
import java.util.*;
public class Rockpaper {

    
    public static void main(String[] args) {
        
   String personPlay; 
    String computerPlay = "";
    int computerInt;  
                      
    String response; 


    Scanner scan = new Scanner(System.in); 
    Random generator = new Random(); 

    System.out.println("Please enter a move.\n" + "Rock = R, Paper" + 
                       "= P, and Scissors = S.");

    System.out.println();

 
    computerInt = generator.nextInt(3)+1; 

   

    if (computerInt == 1) 
       computerPlay = "R"; 
    else if (computerInt == 2) 
       computerPlay = "P"; 
    else if (computerInt == 3) 
       computerPlay = "S"; 


   
    System.out.println("Enter your play: "); 
    personPlay = scan.next();

    
    personPlay = personPlay.toUpperCase(); 

    
    System.out.println("Computer play is: " + computerPlay); 




    if (personPlay.equals(computerPlay)) 
       System.out.println("It's a tie!"); 
    else if (personPlay.equals("R")) 
       if (computerPlay.equals("S")) 
          System.out.println("Rock beats scissors. You win!!");
    else if (computerPlay.equals("P")) 
            System.out.println("Paper beats rock. You lose!!"); 
    else if (personPlay.equals("P")) 
       if (computerPlay.equals("S")) 
       System.out.println("Scissor beats paper. You lose!!"); 
    else if (computerPlay.equals("R")) 
            System.out.println("Paper beats rock. You win!!"); 
    else if (personPlay.equals("S")) 
         if (computerPlay.equals("P")) 
         System.out.println("Scissor beats paper. You win!!"); 
    else if (computerPlay.equals("R")) 
            System.out.println("Rock beats scissors. You lose!!"); 
    else 
         System.out.println("Invalid user input."); 
}
}