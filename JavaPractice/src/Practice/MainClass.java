package Practice;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class MainClass {
	
	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock(20000, true);
		clock.startTimePrinter();
	}
	
}

//Test TimeCounter class
//Scanner in = new Scanner(System.in);
//System.out.println("Please input a time (10h10m10s):");
//String time = in.next();
//time = time.trim();
//int h, m, s;
//h = m = s = 0;
//if(time.contains("h")) {
//	h = Integer.parseInt(time.split("h")[0]);
//	if(time.split("h").length > 1) 
//		time = time.split("h")[1];
//}
//if(time.contains("m")) {
//	m = Integer.parseInt(time.split("m")[0]);
//	if(time.split("m").length > 1)
//		time = time.split("m")[1];
//}
//if(time.contains("s")) {
//	s = Integer.parseInt(time.replace("s", ""));
//}
//int timeInSeconds = 60*60*h + 60*m + s;
//TimeCounter counter = new TimeCounter(timeInSeconds);
//System.out.println("Count Down Starts!");
//counter.startCounting();
//JOptionPane.showMessageDialog(null, "Quit Counting?");
//if(!counter.isOver()) {
//	System.out.println("I'M NOT DONE YOU IDIOT! NOOOOOOO!");
//}
//System.exit(0);

