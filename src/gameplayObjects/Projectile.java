package gameplayObjects;

import java.util.ArrayList;

import functionality.*;
import processing.core.PApplet;

public class Projectile extends GameObject{
	
	private double accelX;
	private double accelY;

	public Projectile(double x, double y, Game g, double xVel, double yVel) {
		super(x, y, g);
		velX = xVel;
		velY = yVel;
		accelY = 0;
		accelX = 0;
	}
	
	public void gatherForce(ArrayList<Planet> planets){

		for (Planet p: planets){
			accelX += (Physics.GRAVCONST*p.getMass()/Math.pow(distToX(p), 2)/1000)*Math.signum(distToX(p));
			accelY += (Physics.GRAVCONST*p.getMass()/Math.pow(distToY(p), 2)/1000)*Math.signum(distToY(p));
		}
		accelY += Physics.GRAVCONST*game.getSun().getMass()/Math.pow(distToX(game.getSun()), 2)*Math.signum(distToX(game.getSun()));
		accelX += Physics.GRAVCONST*game.getSun().getMass()/Math.pow(distToY(game.getSun()), 2)*Math.signum(distToY(game.getSun()));
	}
	
	public void orbit(ArrayList<Planet> planets){
		gatherForce(planets);
		changeVel(accelX, accelY);
		act();
	}
	
	@SuppressWarnings("static-access")
	public void draw(PApplet p){
		p.ellipseMode(p.CENTER);
		p.fill(255,100,100);
		p.ellipse((float)(x), (float)(y), 10, 10);
		p.fill(0, 255, 0);
		p.ellipse((float)(x+accelX), (float)(y+accelY), 5, 5);
	}

}
