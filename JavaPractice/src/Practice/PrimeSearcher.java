package Practice;

import java.util.*;

/*
 * This program runs the Sieve of Erathostenes benchmark,
 * it takes in a natural number and computes all primes up to that number.
 * @version 0.1 2019-4-12
 */

public class PrimeSearcher {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please input a natural number: ");
		PrimeSearcher.search(in.nextInt());
		in.close();
	}
	
	public static void search(int naturalNumber) {
		int primeCount = 0;
		BitSet bs = new BitSet(naturalNumber + 1);
		long startTime = System.currentTimeMillis();
		
		for(int i = 2; i <= naturalNumber; i++) {
			bs.set(i);
		}
		int i = 2;
		while(i * i < naturalNumber) {
			if(bs.get(i)) {
				primeCount++;
				int k = 2 * i;
				while(k <= naturalNumber) {
					bs.clear(k);
					k += i;
				}
			}
			i++;
		}
		while(i <= naturalNumber) {
			if(bs.get(i)) 
				primeCount++;
			i++;
		}
		
		long endTime = System.currentTimeMillis();
		long timeTaken = endTime - startTime;
		
		System.out.println("Prime number found: " + primeCount);
		System.out.println("Time taken: " + timeTaken + "ms");
		System.out.println();
	}
}
