package Practice;

import java.util.*;

public class DrawingNumbers {
	
	public static void drawNumbers() 
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many numbers can you draw from?");
		int maxNumber = in.nextInt();
		
		System.out.println("How many numbers can you draw?");
		int drawNumber = in.nextInt();
		
		System.out.println("Drawing Numbers...");
		
		int[] numbers = new int[maxNumber];
		for(int i = 0; i < maxNumber; ++i)
		{
			numbers[i] = i + 1;
		}
		
		int[] resultNumbers = new int[drawNumber];
		for(int i = 0; i < drawNumber; ++i)
		{
			int randomNumber = (int)(Math.random() * maxNumber);
			resultNumbers[i] = numbers[randomNumber];
			numbers[randomNumber] = numbers[maxNumber - 1];
			maxNumber--;
		}
		Arrays.sort(resultNumbers);
		
		System.out.print("The numbers drawn are: ");
		for(int number : resultNumbers)
		{
			System.out.print(number + " ");
		}
		//System.out.println(".");
	}
	
}
