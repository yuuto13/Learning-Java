package Practice;

import java.util.*;
import java.lang.reflect.*;

/*
 * This class uses reflection library to 
 * print out all features of a class.
 * @version 1.0
 * @author Yang Yudong
 * @issues
 * 1. Array types' name not right, [L at fornt and ; at back
 * 2. 
 */

public class ClassPrinter{
	
	public static void main(String[] args) {
		String className;
		
		if(args.length > 0) {
			className = args[0];
		}
		else {
			Scanner in = new Scanner(System.in);
			System.out.println("Please enter a class name (e.g. java.lang.Double):");
			className = in.next();
		}
		
		try {
			Class cl = Class.forName(className);
			ClassPrinter.printClass(cl);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	/* printConstructors()
	 * Prints all constructors of a class
	 * @param cl a class
	 */
	public static String printConstructors(Class cl) {
		
		StringBuilder sb = new StringBuilder();
		Constructor[] constructors = cl.getDeclaredConstructors();
		for(Constructor c : constructors) {
			String name = c.getName();
			String modifier = Modifier.toString(c.getModifiers());
			
			sb.append("    ");
			if(modifier.length() > 0) {
				sb.append(modifier + " ");
			}
			sb.append(name + "(");
			Class[] paramTypes = c.getParameterTypes();
			for(int i = 0; i < paramTypes.length; ++i) {
				if(i > 0) {
					sb.append(", ");
				}
				sb.append(paramTypes[i].getName());
			}
			sb.append(");\n");
		}
		String lines = sb.toString();
		//System.out.println(lines);
		return lines;
	}
	
	/* printMethods()
	 * Prints all methods of a class
	 * @param cl a class
	 */
	public static String printMethods(Class cl) {
		
		StringBuilder sb = new StringBuilder();
		Method[] methods = cl.getDeclaredMethods();
		for(Method m : methods) {
			String name = m.getName();
			String returnType = m.getReturnType().getName();
			String modifier = Modifier.toString(m.getModifiers());
			sb.append("    " + modifier + (modifier.length() > 0 ? " " : "")
					+ returnType + " " + name + "(");
			Class[] paramTypes = m.getParameterTypes();
			for(int i = 0; i < paramTypes.length; ++i) {
				sb.append((i > 0 ? ", " : "") + paramTypes[i].getName());
			}
			sb.append(");\n");
		}
		String lines = sb.toString();
		//System.out.println(lines);
		return lines;
	}
	
	/* printFields()
	 * Prints all fields of a class
	 * @param cl a class
	 */
	public static String printFields(Class cl) {
		
		StringBuilder sb = new StringBuilder();
		Field[] fields = cl.getDeclaredFields();
		for(Field f : fields) {
			String name = f.getName();
			String type = f.getType().getName();
			String modifier = Modifier.toString(f.getModifiers());
			sb.append("    " + modifier + (modifier.length() > 0 ? " " : "")
					+ type + " " + name + ";\n");
		}
		String lines = sb.toString();
		//System.out.println(lines);
		return lines;
	}
	
	/* printClass()
	 * Prints all features of a class
	 * @param cl a class
	 */
	public static String printClass(Class cl) {
		
		StringBuilder sb = new StringBuilder();
		Class supercl = cl.getSuperclass();
		
		String name = cl.getName();
		String inheritance = (supercl != null && supercl != Object.class) 
						   ? (" extends " + supercl.getName()) : "";
		String modifier = Modifier.toString(cl.getModifiers());
		
		
		sb.append(modifier + (modifier.length() > 0 ? " " : "") 
				+ "class" + name + inheritance		 + "\n{\n"
				+ ClassPrinter.printConstructors(cl) + "\n"
				+ ClassPrinter.printMethods(cl) 	 + "\n"
				+ ClassPrinter.printFields(cl) 		 + "}");
		
		String lines = sb.toString();
		System.out.println(lines);
		return lines;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
