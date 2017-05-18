package gameplayObjects;

import functionality.Game;
import processing.core.PApplet;

public class Spark extends GameObject {
	private int timer;

	public Spark(double x, double y, Game g, double vX, double vY, int time) {
		super(x, y, g);
		super.setVel(vX, vY);
		timer = time;
		setVisible(true);
		// TODO Auto-generated constructor stub
	}
	
	public void act(){
		if (timer>0){
			timer--;
			changePos(getVelX(), getVelY());
		}
		else{
			setVisible(false);
		}
	}
	
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
