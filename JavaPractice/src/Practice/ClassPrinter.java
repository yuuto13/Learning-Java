package Practice;

import java.util.*;
import java.lang.reflect.*;

/*
 * This class uses reflection library to 
 * print out all features of a class.
 * @version 1.2
 * @issues
 * 1. Use more Class<?> methods to clean up the code;
 */

public class ClassPrinter{

	public static void main(String[] args) {
		String className;
		
		if(args.length > 0) {
			className = args[0];
//			if(args.length > 1) {
//				if(args[1] == "-n") {
//					ClassPrinter.simplify = false;
//				}
//			}
		}
		else {
			Scanner in = new Scanner(System.in);
			System.out.println("Please enter a class name (e.g. java.lang.Double):");
			className = in.next();
//			System.out.println("Do you want a simplified version? (y/n)");
//			String answer = in.next().toLowerCase();
//			if(answer.charAt(0) == 'n') ClassPrinter.simplify = false;
			in.close();
		}
		
		try {
			Class<?> cl = Class.forName(className);
			ClassPrinter.printClass(cl);
		}
		catch(ClassNotFoundException e){
			System.out.println("Class not found! Program ended.");
		}
	}
	
	public static String printConstructors(Class<?> cl) {
		
		StringBuilder sb = new StringBuilder();
		Constructor<?>[] constructors = cl.getDeclaredConstructors();
		for(Constructor<?> c : constructors) {
			sb.append("    " + c.toGenericString() + ";\n");
		}
		String lines = sb.toString();
		//System.out.println(lines);
		return lines;
	}
	
	public static String printMethods(Class<?> cl) {
		
		StringBuilder sb = new StringBuilder();
		Method[] methods = cl.getDeclaredMethods();
		for(Method m : methods) {
			sb.append("    " + m.toGenericString() + ";\n");
		}
		String lines = sb.toString();
		//System.out.println(lines);
		return lines;
	}

	public static String printFields(Class<?> cl) {
		
		StringBuilder sb = new StringBuilder();
		Field[] fields = cl.getDeclaredFields();
		for(Field f : fields) {
			sb.append("    " + f.toGenericString() + ";\n");
		}
		String lines = sb.toString();
		//System.out.println(lines);
		return lines;
	}
	
	public static String printClass(Class<?> cl) {
		
		StringBuilder sb = new StringBuilder();
		Class<?> supercl = cl.getSuperclass();
		Type[] interfaces = cl.getGenericInterfaces();
		
		sb.append(cl.toGenericString());
		
		if(supercl != null && supercl != Object.class) {
			sb.append(" extends " + supercl.getName());
		}
		if(interfaces.length != 0) {
			sb.append(" implements ");
			for(int i = 0; i < interfaces.length; ++i) {
				sb.append((i > 0 ? ", " : "") + interfaces[i].getTypeName());
			}
		}
		sb.append("\n{\n");
		sb.append(ClassPrinter.printFields(cl)       + "\n"
				+ ClassPrinter.printConstructors(cl) + "\n"
				+ ClassPrinter.printMethods(cl) 	  + "}");

		String lines = sb.toString();
		System.out.println(lines);
		return lines;
	}
	
	//public static boolean simplify = true;
}
