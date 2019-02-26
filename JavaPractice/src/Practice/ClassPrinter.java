package Practice;

import java.util.*;
import java.lang.reflect.*;

/*
 * This class uses reflection library to 
 * print out all features of a class.
 * @version 1.1
 * @author Yang Yudong
 * @issues
 * 1. sort Methods or make them list look nicer
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
			String name = simplify ? cl.getSimpleName() : cl.getName();
			String modifier = Modifier.toString(c.getModifiers());
			sb.append("    " + modifier 
					+ (modifier.length() > 0 ? " " : "") 
					+ name + "(");
			Class[] paramTypes = c.getParameterTypes();
			for(int i = 0; i < paramTypes.length; ++i) {
				if(i > 0) {
					sb.append(", ");
				}
				sb.append(simplify ? paramTypes[i].getSimpleName() : paramTypes[i].getName());
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
			String returnType = simplify ? m.getReturnType().getSimpleName() 
					                     : m.getReturnType().getName();
			String modifier = Modifier.toString(m.getModifiers());
			sb.append("    " + modifier + (modifier.length() > 0 ? " " : "")
					+ returnType + " " + name + "(");
			Class[] paramTypes = m.getParameterTypes();
			for(int i = 0; i < paramTypes.length; ++i) {
				sb.append((i > 0 ? ", " : "") 
						+ (simplify ? paramTypes[i].getSimpleName() : paramTypes[i].getName()));
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
			String type = simplify ? f.getType().getSimpleName() : f.getType().getName();
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
		
		String name = simplify ? cl.getSimpleName() : cl.getName();
		String superclName = simplify ? supercl.getSimpleName() : supercl.getName();
		String inheritance = (supercl != null && supercl != Object.class) 
						   ? (" extends " + superclName) : "";
		String modifier = Modifier.toString(cl.getModifiers());
		
		sb.append(modifier + (modifier.length() > 0 ? " " : "") 
				+ "class " + name + inheritance		 + "\n{\n"
				+ ClassPrinter.printConstructors(cl) + "\n"
				+ ClassPrinter.printMethods(cl) 	 + "\n"
				+ ClassPrinter.printFields(cl) 		 + "}");
		
		String lines = sb.toString();
		System.out.println(lines);
		return lines;
	}
	
	public static boolean simplify = true;

	


	
	
}
