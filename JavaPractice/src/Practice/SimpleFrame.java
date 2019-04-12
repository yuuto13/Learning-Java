package Practice;

import java.awt.*;
import javax.swing.*;

/*
 * Simple java frame for testing.
 * @version 0.1 2019-4-12
 */
public class SimpleFrame extends JFrame {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame simpleFrame = new SimpleFrame();
			simpleFrame.setVisible(true);
		});
	}
	
	static final int DEFAULT_WIDTH = 400;
	static final int DEFAULT_HEIGHT = 300;
	static final long serialVersionUID = 1L;
	
	public SimpleFrame(int w, int h) {
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public SimpleFrame() {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
