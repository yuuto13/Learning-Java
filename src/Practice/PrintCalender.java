package Practice;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class PrintCalender {

	public static void printCalenderOfThisMonth()
	{
		LocalDate date = LocalDate.now();
		int todayIndex = date.getDayOfMonth();
		date = date.minusDays(todayIndex - 1);
		
		int dayOfWeekIndex = date.getDayOfWeek().getValue();
		
		String month = date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		System.out.println(month + ", " + date.getYear());
		System.out.println();
		System.out.println("Mon Tue Wed Thu Fri Sat Sun");
		for(int i = 0; i < dayOfWeekIndex - 1; ++i)
		{
			System.out.printf("    ");
		}

		int monthIndex = date.getMonthValue(); 
		while(date.getMonthValue() == monthIndex)
		{
			int dayIndex = date.getDayOfMonth();
			System.out.printf("%3d", dayIndex);
			if(dayIndex == todayIndex)
			{
				System.out.printf("*");
			}
			else
			{
				System.out.printf(" ");
			}
			date = date.plusDays(1);
			if(date.getDayOfWeek().getValue() == 1)
			{
				System.out.println();
			}
		}
		if(date.getDayOfWeek().getValue() != 1)
		{
			System.out.println();
		}
	}
}
