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

class TimeCounter {

	public TimeCounter() {}
	public TimeCounter(int timeInSeconds) {
		secondsLeft = timeInSeconds;
		timer = new Timer(1000, event -> {
			System.out.println(secondsLeft);
			//Toolkit.getDefaultToolkit().beep();
			if(secondsLeft == 0) {
				System.out.println("Times Up!");
				this.stopCounting();
			}
			else
				secondsLeft--;
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
	public boolean isOver() {
		return secondsLeft == 0;
	}
	
	private int secondsLeft = 0;
	private Timer timer = null;
}

class TalkingClock {
	
	public TalkingClock() {
		interval = 1000;
		hasBeep = false;
	}
	public TalkingClock(int interval, boolean hasBeep) {
		this.interval = interval;
		this.hasBeep = hasBeep;
	}
	public void startTimePrinter() {
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
		JOptionPane.showMessageDialog(null, "Quit Program?");
		System.out.println("Program aborted.");
		System.exit(0);
	}
	
	private int interval;
	private boolean hasBeep; 
	
	public class TimePrinter implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(hasBeep) {
				System.out.println("At the tone, the ");
				Toolkit.getDefaultToolkit().beep();
			}
			else
				System.out.println("The ");
			System.out.println("time is " + new Date());
		}
	}
}