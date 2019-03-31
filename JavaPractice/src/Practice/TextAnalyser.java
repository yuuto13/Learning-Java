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
		System.out.println();//TODO: add user instructions
	}
	
	private String text;
	
	public void CreateFromTest(String text) {
		this.text = text;
	}
	public void CreateFromFile(String fileName) {
		if(!text.isBlank()) {
			text = "";
		}
		readFile(fileName);
	}
	public void readFile(String fileName) {
		File file = new File(fileName);
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
	public int GetNumWords() {
		Set<String> wordHashes = new HashSet<>();
		String[] words = text.split(" ");
		
		for (int i = 0; i < words.length; i++) {
			wordHashes.add(words[i]);
		}
		//Iterator<String> iter = wordHashes.iterator();
		return wordHashes.size();
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