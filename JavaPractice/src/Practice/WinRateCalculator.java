package Practice;

import java.util.Scanner;

public class WinRateCalculator {
	
	public void LotteryJackpotOdds()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many numbers can you pick from?");
		int maxNumber = in.nextInt();
		
		System.out.println("How many times can you pick?");
		int timesPicked = in.nextInt();
		
		double jackpotOdds = JackpotOddsCalculator(maxNumber, timesPicked);
		
		System.out.println("Your odds to win the jackpot are 1 in " + Math.round(1/jackpotOdds) + ". Good Luck!");
	}
	
	private double JackpotOddsCalculator(int maxNumber, int timesPicked)
	{
		double jackpotOdds = 1.0;
		for(int i = timesPicked; i > 0; --i) 
		{
			jackpotOdds *= 1 - Math.pow(maxNumber-1, i) / Math.pow(maxNumber, i);
		}
		return jackpotOdds;
	}
	
	public static void main(String[] args)
	{
		new WinRateCalculator().LotteryJackpotOdds();
	}
}
