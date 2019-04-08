package usefultools;

import java.util.*;
import java.lang.reflect.*;

/*
 * This class uses reflection library to 
 * print out simple features of a class.
 * @version 1.2 
 */

public class SimpleClassPrinter{

	public static void main(String[] args) {
		String className;
		
		if(args.length > 0) {
			className = args[0];
		}
		else {
			Scanner in = new Scanner(System.in);
			System.out.println("Please enter a class name (e.g. java.lang.Double):");
			className = in.next();
			in.close();
		}
		try {
			Class<?> cl = Class.forName(className);
			SimpleClassPrinter.printClass(cl);
		}
		catch(ClassNotFoundException e){
			System.out.println("Class not found! Program ended.");
		}
	}
	
	/* printConstructors()
	 * Prints all constructors of a class.
	 * @param cl a class
	 * @return a string with all constructors of a class
	 */
	public static String printConstructors(Class<?> cl) {
		
		StringBuilder sb = new StringBuilder();
		Constructor<?>[] constructors = cl.getDeclaredConstructors();
		for(Constructor<?> c : constructors) {
			String name = cl.getSimpleName();
			String modifier = Modifier.toString(c.getModifiers());
			sb.append("    " + modifier 
					+ (modifier.length() > 0 ? " " : "") 
					+ name + "(");
			Class<?>[] paramTypes = c.getParameterTypes();
			for(int i = 0; i < paramTypes.length; ++i) {
				if(i > 0) {
					sb.append(", ");
				}
				sb.append(paramTypes[i].getSimpleName());
			}
			sb.append(");\n");
		}
		String lines = sb.toString();
		//System.out.println(lines);
		return lines;
	}
	
	/* printMethods()
	 * Prints all methods of a class.
	 * @param cl a class
	 * @return a string with all methods of a class
	 */
	public static String printMethods(Class<?> cl) {
		
		StringBuilder sb = new StringBuilder();
		Method[] methods = cl.getDeclaredMethods();
		for(Method m : methods) {
			String name = m.getName();
			String modifier = Modifier.toString(m.getModifiers());
			String appendage = "";
			Class<?> returnType = m.getReturnType();
			if(returnType.isArray()) {
				returnType = returnType.getComponentType();
				appendage = "[]";
			}
			sb.append("    " + modifier + (modifier.length() > 0 ? " " : "")
					+ returnType.getSimpleName()
					+ appendage + " " + name + "(");
			Class<?>[] paramTypes = m.getParameterTypes();
			for(int i = 0; i < paramTypes.length; ++i) {
				sb.append((i > 0 ? ", " : "") + paramTypes[i].getSimpleName());
			}
			sb.append(");\n");
		}
		String lines = sb.toString();
		//System.out.println(lines);
		return lines;
	}
	
	/* printFields()
	 * Prints all fields of a class.
	 * @param cl a class
	 * @return a string with all fields of a class
	 */
	public static String printFields(Class<?> cl) {
		
		StringBuilder sb = new StringBuilder();
		Field[] fields = cl.getDeclaredFields();
		for(Field f : fields) {
			String name = f.getName();
			String modifier = Modifier.toString(f.getModifiers());
			String appendage = "";
			Class<?> type = f.getType();
			if(type.isArray()) {
				type = type.getComponentType();
				appendage = "[]";
			}
			sb.append("    " + modifier + (modifier.length() > 0 ? " " : "")
					+ type.getSimpleName() + appendage + " " + name + ";\n");
		}
		String lines = sb.toString();
		//System.out.println(lines);
		return lines;
	}
	
	/* printClass()
	 * Prints all features of a class.
	 * @param cl a class
	 * @return a string with all features of a class
	 */
	public static String printClass(Class<?> cl) {
		
		StringBuilder sb = new StringBuilder();
		Class<?> supercl = cl.getSuperclass();
		Class<?>[] interfaces = cl.getInterfaces();
		
		String name = cl.getSimpleName();
		String superclName = supercl.getSimpleName();
		String modifier = Modifier.toString(cl.getModifiers());
		String inheritance = "";
		if(supercl != null && supercl != Object.class) {
			inheritance = " extends " + superclName;
		}
		sb.append(modifier + (modifier.length() > 0 ? " " : "") 
				+ "class " + name + inheritance);
		
		if(interfaces.length != 0) {
			sb.append(" implements ");
			for(int i = 0; i < interfaces.length; ++i) {
				sb.append((i > 0 ? ", " : "") + interfaces[i].getSimpleName());
			}
		}
		sb.append("\n{\n");
		sb.append(SimpleClassPrinter.printFields(cl)      +  "\n"
				+ SimpleClassPrinter.printConstructors(cl) + "\n"
				+ SimpleClassPrinter.printMethods(cl)       + "}");
		
		String lines = sb.toString();
		System.out.println(lines);
		return lines;
	}

}
