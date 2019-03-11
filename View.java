
/*import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/

public class View extends JPanel{
	
	final int frameCount = 10;
    int picNum = 0;
    BufferedImage[][] pics;
    final static int frameWidth = 500;
    final static int frameHeight = 300;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    final int xIncr = 8;
    final int yIncr = 2;
    private int xloc;
    private int yloc;
    private int direction;
    JFrame frame;
    
    
    public View() {
    	frame = new JFrame();
    	frame.getContentPane().add(this);
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameWidth, frameHeight);
    	frame.setVisible(true);
    	BufferedImage[] imgs = createImage();
    	BufferedImage img;
    	pics = new BufferedImage[4][10];
    	for(int i = 0; i < 4; i++) {
    		img = imgs[i];
    		for(int j = 0; j < frameCount; j++) {
    			pics[i][j] = img.getSubimage(imgWidth*j, 0, imgWidth, imgHeight);
    		}
    	}
    }
    
    
    public int getWidth() {
    	return frameWidth;
    }
    
    public int getHeight() {
    	return frameHeight;
    }
    
    public int getImageWidth() {
    	return imgWidth;
    }
    
    public int getImageHeight() {
    	return imgHeight;
    }
    
    public void paint(Graphics g) {
    	
    	picNum = (picNum + 1) % frameCount;
    	if(direction == 0){
    		g.drawImage(pics[direction][picNum], xloc+=xIncr, yloc+=yIncr, Color.gray, this);
    	}
    	else if(direction == 1) {
    		g.drawImage(pics[direction][picNum], xloc-=xIncr, yloc+=yIncr, Color.gray, this);
    	}
    	else if(direction == 2) {
    		g.drawImage(pics[direction][picNum], xloc+=xIncr, yloc-=yIncr, Color.gray, this);
    	}
    	else if(direction == 3) {
    		g.drawImage(pics[direction][picNum], xloc-=xIncr, yloc-=yIncr, Color.gray, this);
    	}
    }
    
    public void update(int x, int y, int direction) {
    	this.xloc = x;
    	this.yloc = y;
    	this.direction = direction;
    	frame.repaint();
    	try
    	{
    		Thread.sleep(100);
    	}
    	catch(InterruptedException e)
    	{
    		e.printStackTrace();
    	}
    }
	
	 //Read image from file and return
    private BufferedImage[] createImage(){
    	BufferedImage[] bufferedImage = new BufferedImage[8];
    	try {
    		bufferedImage[0] = ImageIO.read(new File("src/orc_forward_southeast.png"));
    		bufferedImage[1] = ImageIO.read(new File("src/orc_forward_southwest.png"));
    		bufferedImage[2] = ImageIO.read(new File("src/orc_forward_northeast.png"));
    		bufferedImage[3] = ImageIO.read(new File("src/orc_forward_northwest.png"));
    		
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    }
    
    

}