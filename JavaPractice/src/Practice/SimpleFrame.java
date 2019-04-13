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
			//simpleFrame.toBack();
			//simpleFrame.setExtendedState(ICONIFIED); //MAXIMIZED_BOTH
		});
	}
	
	static final int DEFAULT_WIDTH = 400;
	static final int DEFAULT_HEIGHT = 300;
	static final long serialVersionUID = 1L;
	
	public SimpleFrame() {
		setTitle("Simple Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenDimension = toolkit.getScreenSize();
		int offsetX = screenDimension.width / 4;
		int offsetY = screenDimension.height / 4;
		int width = screenDimension.width / 2;
		int height = screenDimension.height / 2;
		setBounds(offsetX, offsetY, width, height);
		//setLocationByPlatform(true);
		//setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		setBackground(new Color(0, 0, 100));
		
		Image icon = new ImageIcon("H:/Picture/MCTheme/icos/Baby_Zombie.jpg").getImage();
		setIconImage(icon);
	}
	public SimpleFrame(int w, int h) {
		this();
		setSize(w, h);
	}
	
}
