import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class Frame {
	static int mouseX = 500;
	static int mouseY = 300;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		JFrame frame = new JFrame("FrameDemo");
		File mouseFile = new File("mouse.png");
		final BufferedImage mouseImage = ImageIO.read(mouseFile);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent comp = new JComponent() {
			@Override
			protected void paintComponent(Graphics g) {
				System.out.println("paintComponent");
				
			    super.paintComponent(g);
		        g.setColor(Color.BLUE);
		        g.drawLine(0, 0, 400, 400);
		        
		        g.setColor(Color.RED);
		        g.drawOval(150, 100, 100, 200);
		        
		        g.drawImage(mouseImage, mouseX, mouseY, null);
			}
		};
		comp.setPreferredSize(new Dimension(1400, 800));
		frame.add(comp);
		
		frame.pack();
		frame.setVisible(true);
		
		while (true) {
			comp.repaint();
			Thread.sleep(500);
			
			if (Math.random() > 0.5) {
				mouseX += 20 * (Math.random() > 0.5 ? 1 : -1);
			} else {
				mouseY += 20 * (Math.random() > 0.5 ? 1 : -1);
			}
		}
	}
}
