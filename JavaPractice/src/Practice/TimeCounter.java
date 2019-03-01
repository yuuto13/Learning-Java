package Practice;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class TimeCounter implements ActionListener {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please input a time (10h10m10s):");
		String time = in.next();
		time = time.trim();
		int h, m, s;
		h = m = s = 0;
		if(time.contains("h")) {
			h = Integer.parseInt(time.split("h")[0]);
			if(time.split("h").length > 1) 
				time = time.split("h")[1];
		}
		if(time.contains("m")) {
			m = Integer.parseInt(time.split("m")[0]);
			if(time.split("m").length > 1)
				time = time.split("m")[1];
		}
		if(time.contains("s")) {
			s = Integer.parseInt(time.replace("s", ""));
		}
		int timeInSeconds = 60*60*h + 60*m + s;
		TimeCounter counter = new TimeCounter(timeInSeconds);
		Timer timer = new Timer(1000, counter);
		System.out.println("Count Down Starts!");
		timer.start();
		JOptionPane.showMessageDialog(null, "Quit Counting?");
		System.out.println("I'M NOT DONE YOU IDIOT! NOOOOOOO!");
		System.exit(0);
	}
	
	public TimeCounter() {}
	public TimeCounter(int timeInSeconds) {
		secondsLeft = timeInSeconds;
	}
	
	public void actionPerformed(ActionEvent event) {
		System.out.println(secondsLeft);
		secondsLeft--;
		if(secondsLeft <= 0) {
			System.out.println("Times Up!");
		}
	}
	
	private int secondsLeft = 0;
}
