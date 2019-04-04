package Practice;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.function.*;
import java.util.logging.*;
import creatures.*;

public class HelloWorld 
{
	public static void main(String[] args)
	{
		repeat(5, i -> System.out.println(i));
		
		LocalDate[] dates = {
				LocalDate.of(1996, 4, 13),
				LocalDate.of(2018, 11, 11),
				LocalDate.of(1919, 2, 20),
				LocalDate.of(1949, 10, 10),
				LocalDate.of(2011, 11, 20),
				LocalDate.of(1988, 2, 15)
		};
		ArrayAlg.Pair<LocalDate> p = ArrayAlg.maxMin(dates);
		System.out.println("max: " + p.getFirst());
		System.out.println("min: " + p.getSecond());

		//StackTraceTest.factorial(2);
		StackTraceElement[] elements = new Throwable().getStackTrace();
		for(StackTraceElement element : elements) {
			System.out.println(element.getFileName());
			System.out.println(element.getClassName());
			System.out.println(element.getLineNumber());
			System.out.println(element.getMethodName());
			System.out.println(element.getModuleName());
			System.out.println(element.getModuleVersion());
		}
		//Logger.getGlobal().info("Print Stack Trace");
		//Thread.dumpStack();
		
		Class<?> cl = ArrayAlg.class;
		System.out.println(cl.toGenericString());
		System.out.println(cl.toString());
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

class ArrayAlg<T> {

	//Generic class test
	public static class Pair<T> {
		private T first;
		private T second;
		
		public Pair(T first, T second) {
			this.first = first;
			this.second = second;
		}
		
		public T getFirst() { return first; }
		public T getSecond() { return second; }
		public void setFirst(T first) { this.first = first; }
		public void setSecond(T second) { this.second = second; }
	}
	//Generic method test
	public static <T extends Comparable<? super T>> Pair<T> maxMin(T[] array) {
		if(array == null || array.length == 0) {
			return null;
		}
		T max = array[0];
		T min = array[0];
		for(int i = 1; i < array.length; ++i) {
			if(array[i].compareTo(max) > 0) max = array[i];
			if(array[i].compareTo(min) < 0) min = array[i];
		}
		return new Pair<T>(max, min);
	}
	@SuppressWarnings("deprecation")
	public static <T> Pair<T> makePair(Class<T> cl) {
		try {
			return new Pair<>(cl.newInstance(), cl.newInstance());
		}
		catch(Exception e) {
			return null;
		}
	}
}

class StackTraceTest {
	public static int factorial(int number) {
		StackTraceElement[] elements = new Throwable().getStackTrace();
		for(StackTraceElement element : elements) {
			System.out.println(element.getMethodName() + "(" + number + "):");
			System.out.println(element);
		}
		int result;
		if(number <= 1)
			result = 1;
		else
			result = number * factorial(number - 1);
		System.out.println("return " + result);
		return result;
	}
}

class Test extends HelloWorld implements Comparable<Test>, Serializable{

	public static class TestInner {
		float f;
		
		public TestInner() {
			// TODO Auto-generated constructor stub
		}
		
		public void name() {
			
		}
	}
	
	private static final long serialVersionUID = 1L;
	private Integer[] numbers;
	
	public Test() {
		numbers = new Integer[10];
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Comparable<? super T>> void testMethod(T... t) {
		System.out.print(numbers[0] + ". " + t[0].toString());
	}
	public int compareTo(Test t) {
		return 0;
	}
}

//Unicode & Math
//import static java.lang.Math.*;
//System.out.println("The square root of \u03C0 is " + sqrt(PI));
//System.out.println("\u6211");
//String str = "Œ“bU+1D546";
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

//Anonymous class
//int[] counter = new int[1];
//Animal[] animals = new Animal[100];
//for(int i = 0; i < animals.length; ++i) {
//	animals[99-i] = new Animal() {
//		public int compareTo(Animal other) {
//			counter[0]++;
//			return super.compareTo(other);
//		}
//	};
//}
//Arrays.sort(animals);
//System.out.println(counter[0] + " comparisons.");






