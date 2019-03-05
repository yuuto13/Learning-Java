package Practice;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/* 
 * This class allows you to count a
 * number down to zero.
 * @version 1.1
 * @author Yang Yudong
 */

public class TimeCounter {
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
		System.out.println("Count Down Starts!");
		counter.startCounting();
		JOptionPane.showMessageDialog(null, "Quit Counting?");
		if(counter.secondsLeft > 0) {
			System.out.println("I'M NOT DONE YOU IDIOT! NOOOOOOO!");
		}
		System.exit(0);
	}
	
	public TimeCounter() {}
	public TimeCounter(int timeInSeconds) {
		secondsLeft = timeInSeconds;
		timer = new Timer(1000, event -> {
			System.out.println(secondsLeft);
			//Toolkit.getDefaultToolkit().beep();
			secondsLeft--;
			if(secondsLeft < 0) {
				System.out.println("Times Up!");
				this.stopCounting();
			}
		});
	}
	
	public void startCounting() {
		if(timer != null) {
			timer.start();
		}
	}
	
	public void stopCounting() {
		if(timer != null) {
			timer.stop();
		}
	}
	
	private int secondsLeft = 0;
	private Timer timer = null;
}
