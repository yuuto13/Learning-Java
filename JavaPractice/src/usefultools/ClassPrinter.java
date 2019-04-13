package usefultools;

import java.util.*;
import java.lang.reflect.*;

/*
 * This class uses reflection library to 
 * print out all features of a class.
 * @version 2.11 2019-4-13
 * @Todo: add "private"
 */

public class ClassPrinter {

	public static void main(String[] args) {
		String className;
		String version = "";
		if(args.length > 0) {
			className = args[0];
			if(args.length > 1) {
				if(args[1] == "-n") {
					version = "n";
				}
			}
		}
		else {
			Scanner in = new Scanner(System.in);
			System.out.println("Please enter a class name (e.g. java.lang.Double):");
			className = in.next();
			System.out.println("Do you want to see the qualified names instead of imports? (y/n)");
			version = in.next().toLowerCase();
			in.close();
		}
		try {
			Class<?> cl = Class.forName(className);
			ClassPrinter classPrinter = new ClassPrinter(cl);

			//classPrinter.printClass();
			System.out.println();
			if(version.compareTo("y") == 0) {
				classPrinter.printClass();
			} else {
				classPrinter.printClassWithImportedPackage();
			}
		}
		catch(ClassNotFoundException e){
			System.out.println("Class not found! Program ended.");
		}
	}

	
	Class<?> cl;
	SortedSet<String> importSet;
	String packageName = "";
	String packageStr = "";
	String mainStr = "";
	String oldMain = "";
	
	public ClassPrinter(Class<?> cl) {
		this.cl = cl;
		this.packageName = cl.getPackageName();
		
		//TODO: need more accurate comparing factor for importSet
		importSet = new TreeSet<>(new Comparator<String>() {
			public int compare(String a, String b) {
				if(a.substring(0, 8).compareTo(b.substring(0, 8)) == 0) {
					return a.length() - b.length();
				}
				else return a.compareTo(b);
			}
		});
	}
	
	public String printClass() {
		String all;
		
		if(mainStr == "") GetClassString();
			
		if(oldMain != "") {
			all = packageStr + oldMain;
		}
		else all = packageStr + mainStr;
		System.out.println(all);
		return all;
	}
	public String printClassWithImportedPackage() {
		
		if(mainStr == "") GetClassString();
		if(importSet.size() == 0) {
			oldMain = mainStr;
			GetImports();
		}
		
		StringBuilder sb = new StringBuilder();
		for(String i : importSet) {
			sb.append("import " + i + ";\n");
		}
		sb.append("\n");
		String importStr = sb.toString();
		
		System.out.println(packageStr + importStr + mainStr);
		return packageStr + importStr + mainStr;
	}
	String GetFields() { //Get Field String
		StringBuilder sb = new StringBuilder();
		List<Field> fieldList = Arrays.asList(cl.getDeclaredFields());
		
		fieldList.sort(Comparator.comparing(Field::getName));
		fieldList.sort(new Comparator<Field>() {
			public int compare(Field f1, Field f2) {
				String type1 = f1.getGenericType().toString();
				String type2 = f2.getGenericType().toString();
				return type1.compareTo(type2);
			}
		});
		fieldList.sort(new Comparator<Field>() {
			public int compare(Field f1, Field f2) {
				String mod1 = Modifier.toString(f1.getModifiers());
				String mod2 = Modifier.toString(f2.getModifiers());
				if(mod1.length() > 0 && mod1.charAt(0) != 'p') mod1 = "private" + mod1;
				if(mod2.length() > 0 && mod2.charAt(0) != 'p') mod2 = "private" + mod2;
				return mod1.compareTo(mod2);
			}
		});
		
		for(Field f : fieldList) {
			if(f != null)
				sb.append("    " + f.toGenericString() + ";\n");
		}
		return sb.toString();
	}
	String GetConstructors() { //Get Constructor String
		StringBuilder sb = new StringBuilder();
		List<Constructor<?>> constructorList = Arrays.asList(cl.getDeclaredConstructors());
		constructorList.sort(Comparator.comparing(Constructor::getParameterCount));
		
		for(Constructor<?> c : constructorList) {
			if(c != null)
				sb.append("    " + c.toGenericString() + ";\n");
		}
		return sb.toString();
	}
	String GetMethods() { //Get Method String
		StringBuilder sb = new StringBuilder();
		List<Method> methodList = new ArrayList<>(Arrays.asList(cl.getDeclaredMethods()));

		methodList.sort(Comparator.comparing(Method::getParameterCount));
		methodList.sort(Comparator.comparing(Method::getName));
		methodList.sort(new Comparator<Method>() {
			public int compare(Method m1, Method m2) {
				String mod1 = Modifier.toString(m1.getModifiers());
				String mod2 = Modifier.toString(m2.getModifiers());
				if(mod1.length() > 0 && mod1.charAt(0) != 'p') mod1 = "private" + mod1;
				if(mod2.length() > 0 && mod2.charAt(0) != 'p') mod2 = "private" + mod2;
				return mod1.compareTo(mod2);
			}
		});
		
		for(Method m : methodList) {
			if(m != null)
				sb.append("    " + m + ";\n");
		}
		return sb.toString();
	}
	void GetClassString() {
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
				sb.append((i > 0 ? "," : "") + interfaces[i].getTypeName());
			}
		}
		sb.append("\n{\n");
		
		String fieldStr = GetFields();
		String constructorStr = GetConstructors();
		String methodStr = GetMethods();
		
		if(hasFields()) sb.append(fieldStr + "\n");
		if(hasConstructors()) sb.append(constructorStr + "\n");
		sb.append(methodStr + "}");

		mainStr = sb.toString();
		
		mainStr = mainStr.replace(getClassName() + ".", "");
		mainStr = mainStr.replace(getClassName(), getSimpleName());
		mainStr = mainStr.replace(",", ", ");		
		
		packageStr = "package " + packageName + ";\n\n";
	}
	void GetImports() {
		String endChars = " ;,) {[<>\n";
		String packageName = "";
		String className = "";
		int start, middle, end;
		for(int i = mainStr.length()-1; i > 0; i--) {
			if(mainStr.charAt(i) == '.') {
				if(mainStr.charAt(i-1) == '.' || mainStr.charAt(i+1) == '.') continue;
				
				start = middle = end = i;
				while(mainStr.charAt(start) != ' ' && mainStr.charAt(start) != '(') start--;
				while(!endChars.contains("" + mainStr.charAt(end)))                    end++;
				packageName = mainStr.substring(start + 1, middle);
				className = mainStr.substring(middle + 1, end);
				
				String importName = packageName + "." + className;
				if(importName != getClassName()) {
					importSet.add(importName);
				}
				
				mainStr = mainStr.replace(importName, className);
				GetImports();
				break;
			}
		}
	}
	
	public String getClassName() { return cl.getName(); }
	public String getSimpleName() { return cl.getSimpleName(); } 
	public boolean hasFields() { return cl.getDeclaredFields().length != 0; }
	public boolean hasConstructors() { return cl.getDeclaredConstructors().length != 0; }
	public boolean hasMethods() { return cl.getDeclaredMethods().length != 0; }
}
