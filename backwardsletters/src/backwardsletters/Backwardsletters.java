
package backwardsletters;


import java.util.Scanner;

public class Backwardsletters
{
	public static void main(String[] args)
	{
		System.out.println("Enter a word:");
		
		Scanner read = new Scanner(System.in);
		String userword = read.nextLine();
		String reverse = "";
		
		
		for(int i = userword.length() - 1; i >= 0; i--)
		{
			reverse = reverse + userword.charAt(i);
		}
		
		System.out.println("Your word reversed is:");
		System.out.println(reverse);
	}
}

