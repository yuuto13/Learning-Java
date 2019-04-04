package Practice;

//import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class ImageViewer {
	private JFrame frame;
	
	public ImageViewer() {
		frame = new ImageViewerFrame();
	}
	
	public void show() {
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		ImageViewer viewer = new ImageViewer();
		viewer.show();
	}
}

class ImageViewerFrame extends JFrame {

	private static final long serialVersionUID = 8525601478363315305L;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	private JLabel image;
	
	public ImageViewerFrame() {
		super.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		super.setTitle("Image Viewer");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		super.setJMenuBar(menuBar);
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new OpenFileListener());
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		image = new JLabel();
		super.add(image);
	}

	private class OpenFileListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(""));
			fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
				public boolean accept(File f) {
					String name = f.getName().toLowerCase();
					return name.endsWith(".gif") || name.endsWith(".png") || name.endsWith(".jpg")
						|| f.isDirectory();
				}
				public String getDescription() {
					return "JPG, PNG and GIF Images";
				}
			});
			int r = fileChooser.showOpenDialog(ImageViewerFrame.this);
			if(r == JFileChooser.APPROVE_OPTION) {
				String name = fileChooser.getSelectedFile().getPath();
				image.setIcon(new ImageIcon(name));
				ImageViewerFrame.this.setTitle(name);
			}
		}
	}
	
}