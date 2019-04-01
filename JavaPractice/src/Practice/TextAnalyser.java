package Practice;

import java.util.*;
import java.io.*;

/*
 * This class takes in text from a file or give string, 
 * analyse the content and return the analysis.
 * @version 0.1 
 * @author Yang Yudong
 */

public class TextAnalyser {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please type in a text file address: ");
		String fileName = in.nextLine();
		in.close();
		TextAnalyser ta = new TextAnalyser();
		ta.CreateFromFile(fileName);
		ta.AnalyseText();
		System.out.println("The text has " + ta.numWords + " words and " + ta.numDiffWords + " different words.");
		System.out.println("Time Usage: " + ta.time + "s");
	}
	
	String text = "";
	public int numWords;
	public int numDiffWords;
	public long time;
	
	public void CreateFromTest(String text) {
		this.text = text;
	}
	public void CreateFromFile(String fileName) {
		if(!text.isBlank()) {
			text = "";
		}
		readFile(fileName);
	}
	public void AnalyseText() {
		GetNumWords();
	}
	private void GetNumWords() {
		Set<String> wordHashes = new HashSet<>();
		String[] words = text.split(" ");
		//String[] punctuations = ",.!?:;\"'-#()+-*/=".split("");
		
		time = System.currentTimeMillis();
		for (int i = 0; i < words.length; i++) {
			wordHashes.add(words[i]);
		}
		time = System.currentTimeMillis() - time;
		
		//Iterator<String> iter = wordHashes.iterator();
		numWords = words.length;
		numDiffWords = wordHashes.size();
	}
	private void readFile(String fileName) {
		//File file = new File(fileName);
		Reader reader = null;
		try {
			reader = new InputStreamReader(new FileInputStream(fileName));
			int tempchar;
			while((tempchar = reader.read()) != -1) {
				text += (char)tempchar;
			}
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

//try(FileReader reader = new FileReader(fileName);
//BufferedReader bReader = new BufferedReader(reader)) {
//String line;
//while((line = bReader.readLine()) != null) {
//	System.out.println(line);
//}
//}
//catch (IOException e) {
//e.printStackTrace();
//}