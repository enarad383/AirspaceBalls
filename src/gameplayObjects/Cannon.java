package gameplayObjects;

import functionality.Game;
import processing.core.PApplet;

public class Cannon extends Planet{

	private double aimAngle;
	
	public Cannon(double radius, double angle, Game g, double aimAngle) {
		super(radius, angle, g, 0, 4);
		this.aimAngle = aimAngle;
	}
	
	public void aim(boolean direction){
		if (direction){
			aimAngle ++;
		}
		else{
			aimAngle --;
		}
	}
	
	public void draw(PApplet p){
		p.ellipseMode(p.CENTER);
		p.fill(150,150,255);
		p.ellipse((float)(x), (float)(y), (float)size, (float)size);
		int canLength = 10;
		int canWidth = 3;
		p.rotate((float)aimAngle);
		p.rect((float)x, (float)(y-canWidth/2), canLength, canWidth);
		p.rotate(-(float)aimAngle);
	}

}
