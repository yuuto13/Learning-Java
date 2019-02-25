package HelloWorld;

import java.util.*;

public class HelloWorld 
{
	public static double max(double... numbers)
	{
		double largest = Double.NEGATIVE_INFINITY;
		for(double number : numbers)
		{
			largest = number > largest ? number : largest;
		}
		
		return largest;
	}
	
	public static void main(String[] args)
	{
		int[] array = { 1, 1, 3, 3, 9, 7 };
		ArrayList<Double> arrayList = new ArrayList<>();
		for(int i = 0; i < array.length; i++)
		{
			arrayList.add((double)array[i]);
		}
		arrayList.remove(arrayList.size()-1);
		arrayList.add(arrayList.size()-1, arrayList.get(arrayList.size()-1));
		double[] doubleArray = new double[arrayList.size()];
		for(int i = 0; i < arrayList.size(); ++i)
		{
			doubleArray[i] = arrayList.get(i);
		}
		
		System.out.println(arrayList.toString());
		System.out.println("The largest number is " + max(doubleArray) + ".");
	}

}


//Unicode & Math
//import static java.lang.Math.*;
//System.out.println("The square root of \u03C0 is " + sqrt(PI));
//System.out.println("\u6211");
//String str = "ÎÒbU+1D546";
//int codePoint = str.codePointAt(0);
//System.out.println(str);
//System.out.println(Integer.toHexString(codePoint));

//Console input & output
//Scanner in = new Scanner(System.in);
//System.out.println("What's your name: ");
//String name = in.next();
//System.out.println("How old are you: ");
//int age = in.nextInt();
//System.out.println("Hello " + name + ", next year you will be " + ++age + "!");

//Load and Write text to file
//String path = System.getProperty("user.dir") + "\\aaa.txt";
//String path = "D:/aaa.txt";
//System.out.println(path);
//PrintWriter out = new PrintWriter(path);
//out.println("Who's your daddy?");
//out.close();
//Scanner in = new Scanner(Paths.get(path));
//String cheatCode = in.nextLine();
//in.close();
//System.out.print(cheatCode);

//int[] array = { 1, 1, 3, 3, 9, 7 };
//System.out.println(array.toString());
//System.out.println(Arrays.toString(array));