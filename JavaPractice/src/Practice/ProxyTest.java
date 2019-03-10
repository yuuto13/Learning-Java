package Practice;

import java.lang.reflect.*;
import java.util.*;

/*
 * This program demonstrates the use of proxies.
 * @version 1.0
 */

public class ProxyTest {
	public static void main(String[] args) {
		Object[] elements = new Object[1000];
		for(int i = 0; i < elements.length; ++i) {
			Integer value = i + 1;
			InvocationHandler handler = new TraceHandler(value);
			Object proxy = Proxy.newProxyInstance(null, new Class[] { Comparable.class }, handler);
			elements[i] = proxy;
		}
		Integer key = new Random().nextInt(elements.length) + 1;
		int result = Arrays.binarySearch(elements, key);
		if(result >= 0) {
			System.out.println("The result is " + elements[result] + ".");
			System.out.println("Binary searched for " + (TraceHandler.getInvokeTimes()-1) + " times.");
		}
	}
}



class TraceHandler implements InvocationHandler {
	private Object target;
	private static int invokeTimes;
	
	public TraceHandler(Object t) {
		target = t;
	}
	
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		System.out.print(target + "." + m.getName() + "(");
		if(args != null) {
			for(int i = 0; i < args.length; ++i) {
				System.out.print(args[i]);
				if(i < args.length - 1)
					System.out.print(", ");
			}
		}
		System.out.println(")");
		invokeTimes++;
		return m.invoke(target, args);
	}
	public static int getInvokeTimes() { return invokeTimes; }
}