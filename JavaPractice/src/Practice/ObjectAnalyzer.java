package Practice;

import java.util.*;
import java.lang.reflect.*;

/* Java Core Technics 201 or 218
 * This class allows you to analyze what fields
 * does a object has and what are their value.
 * @version 1.0 2.26.2019
 * @author Yang Yudong
 */

public class ObjectAnalyzer {

	public static void main(String[] args) {
		
		
	}
	
	/* analyzeObject(Object)
	 * Prints all fields and values of a class.
	 * @param obj a object
	 * @return a string with a list of fields and values
	 * of a class
	 */
	public static String analyzeObject(Object obj) {
		
		StringBuilder sb = new StringBuilder();
		if(obj == null) return "null";
		Class cl = obj.getClass();
		if(cl == String.class) return obj.toString();
		if(cl.isArray()) {
			sb.append(cl.getComponentType().getSimpleName() + "[]{");
			for(int i = 0; i < Array.getLength(obj); ++i) {
				if(i > 0) sb.append(", ");
				
			}
		}
		
		return "";
	}
	
	
	
	
	
	
	
	
	
	
}
