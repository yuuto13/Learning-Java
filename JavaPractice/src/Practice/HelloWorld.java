package Practice;

import java.util.*;
import java.util.function.*;
import creatures.*;

public class HelloWorld 
{
	public static void main(String[] args)
	{
		repeat(5, i -> System.out.println(i));
		
		int[] counter = new int[1];
		Animal[] animals = new Animal[100];
		for(int i = 0; i < animals.length; ++i) {
			animals[99-i] = new Animal() {
				public int compareTo(Animal other) {
					counter[0]++;
					return super.compareTo(other);
				}
			};
		}
		//Arrays.sort(animals);
		ArrayManipulator.maxMin(animals);
		System.out.println(counter[0] + " comparisons.");
	}

	public static double max(double... numbers)
	{
		double largest = Double.NEGATIVE_INFINITY;
		for(double number : numbers)
		{
			largest = number > largest ? number : largest;
		}
		
		return largest;
	}
	
	public static void repeat(int times, IntConsumer action) {
		for(int i = 0; i < times; ++i) {
			action.accept(i);
		}
	}
}

class ArrayManipulator {
	
	public static class Pair {
		private Object first;
		private Object second;
		
		public Pair(Object first, Object second) {
			this.first = first;
			this.second = second;
		}
		
		public Object getFirst() { return first; }
		public Object getSecond() { return second; }
	}
	public static class DoublePair {
		private double first;
		private double second;
		
		public DoublePair(double first, double second) {
			this.first = first;
			this.second = second;
		}
		
		public double getFirst() { return first; }
		public double getSecond() { return second; }
	}
	
	public static Pair maxMin(Comparable[] array) {
		Comparable max = array[0];
		Comparable min = array[0];
		for(int i = 1; i < array.length; ++i) {
			if(array[i].compareTo(max) > 0) max = array[i];
			if(array[i].compareTo(min) < 0) min = array[i];
		}
		return new Pair(max, min);
	}
	public static DoublePair doubleMaxMin(double[] array) {
		double max = Double.MIN_VALUE;
		double min = Double.MAX_VALUE;
		for(int i = 0; i < array.length; ++i) {
			if(array[i] > max) max = array[i];
			if(array[i] < min) min = array[i];
		}
		return new DoublePair(max, min);
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

//int[] array = { 1, 1, 3, 3, 9, 7 };
//ArrayList<Double> arrayList = new ArrayList<>();
//for(int i = 0; i < array.length; i++)
//{
//	arrayList.add((double)array[i]);
//}
//arrayList.remove(arrayList.size()-1);
//arrayList.add(arrayList.size()-1, arrayList.get(arrayList.size()-1));
//double[] doubleArray = new double[arrayList.size()];
//for(int i = 0; i < arrayList.size(); ++i)
//{
//	doubleArray[i] = arrayList.get(i);
//}
//String className = ArrayList.class.getName();
//System.out.println(arrayList.toString());
//System.out.println("The largest number is " + max(doubleArray) + ".");
//System.out.println(Objects.equals(ArrayList.class, arrayList.getClass()) + " " + className);