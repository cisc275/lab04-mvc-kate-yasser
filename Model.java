
/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/

public class Model{
	int xloc = 0;
    int yloc = 0;
    boolean flagX = false;
	boolean flagY = false;
	int direction = 0;
	int frameWidth;
	int frameHeight;
	int imgWidth;
	int imgHeight;
	private final int xIncr = 8;
	private final int yIncr = 2;
	private int xDir = 1;
	private int yDir = 1;
	
	public Model(int width, int height, int imgWidth, int imgHeight) {
		frameWidth = width;
		frameHeight = height;
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
	}
	
	public void updateLocationAndDirection() {
		//update flags
		if(xloc > frameWidth - imgWidth || xloc < 0) {
    		flagX = !flagX;
    		xDir *= -1;
    	}
    	
    	if(yloc > frameHeight - imgHeight || yloc < 0) {
    		flagY = !flagY;
    		yDir *= -1;
    	}
    	
    	//update direction based on flags
    	if(flagX == true && flagY == false) {
    		direction = 1;
    	}
    	else if(flagY == true && flagX == false) {
    		direction = 2;
    	}
    	else if(flagX == true && flagY == true) {
    		direction = 3;
    	}
    	else {
    		direction = 0;
    	}
		xloc += (xDir)*(xIncr);
		yloc += (yDir)*(yIncr);
	}
	
	public int getX() {
		return this.xloc;
	}
	
	public int getY() {
		return this.yloc;
	}
	
	public int getDirect() {
		return direction;
	}
	
	
	
}
