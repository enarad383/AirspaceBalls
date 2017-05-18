package gameplayObjects;

import functionality.Game;
import processing.core.PApplet;

/**Represents sparks that form in the event of a collision.
 * 
 * @author enarad383
 *
 */
public class Spark extends GameObject {
	private int timer;

	public Spark(double x, double y, Game g, double vX, double vY, int time) {
		super(x, y, g);
		super.setVel(vX, vY);
		timer = time;
		setVisible(true);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Increments the spark's timer and moves it according to velocity.
	 */
	public void act(){
		if (timer>0){
			timer--;
			changePos(getVelX(), getVelY());
		}
		else{
			setVisible(false);
		}
	}
	
	/**Sets the lifetime of the spark.
	 * 
	 * @param time how long it will last.
	 */
	public void setTime(int time){
		timer = time;
	}
	
	public void draw(PApplet p){
		if (isVisible()){
			p.strokeWeight(timer+4);
			p.stroke(255,200,0);
			p.line((float)x, (float)y, (float)(x+velX), (float)(y+velY));
			p.strokeWeight(timer);
			p.stroke(255);
			p.line((float)x, (float)y, (float)(x+velX), (float)(y+velY));
		}	
	}

}
