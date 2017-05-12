package gameplayObjects;

import java.util.ArrayList;

import functionality.*;
import processing.core.PApplet;

public class Projectile extends GameObject{
	
	private double accel;
	private double angle;

	/**Constructs a Projectile object.
	 * 
	 * @param x The initial x coordinate of the object.
	 * @param y The initial y coordinate of the object.
	 * @param g The Game in which it is created.
	 * @param xVel The initial x velocity.
	 * @param yVel The initial y velocity.
	 */
	public Projectile(double x, double y, Game g, double xVel, double yVel) {
		super(x, y, g);
		velX = xVel;
		velY = yVel;

	}
	
	/** Prepares the acceleration fields by collecting the net gravitational effect on the projectile.
	 * 
	 * @param planets The planets from which to collect gravity data.
	 */
	public void gatherForce(ArrayList<Planet> planets){
		double accelX = 0, accelY = 0;
		Sun sun = game.getSun();
		for (Planet p: planets){
			double tempaccel = 20*(Physics.GRAVCONST*p.getMass()/Math.pow(distanceTo(p), 2));
			accelX += tempaccel*Math.cos(getAngleTo(p));
			accelY += tempaccel*Math.sin(getAngleTo(p));
		}
		double tempaccel = 20*(Physics.GRAVCONST*sun.getMass()/Math.pow(distanceTo(sun), 2));
		accelX += tempaccel*Math.cos(getAngleTo(sun));
		accelY += tempaccel*Math.sin(getAngleTo(sun));
		accel = -Math.sqrt(accelX*accelX + accelY*accelY);
		angle = Math.atan(accelX/accelY);
		if (accelX<0){
			angle += Math.PI;
		}
		else if (accelY<0){
			angle += 2*Math.PI;
		}
	}
	
	/** Tells the projectile to take one step, recalculating gravity and changing its velocity.
	 * 
	 * @param planets The planets from which to collect gravity data.
	 */
	public void orbit(ArrayList<Planet> planets){
		gatherForce(planets);
		changeVel(accel*Math.cos(angle), accel*Math.sin(angle));
		act();
	}
	
	@SuppressWarnings("static-access")
	/**Draws the projectile using Processing.
	 * 
	 */
	public void draw(PApplet p){
		p.ellipseMode(p.CENTER);
		p.fill(255,100,100);
		p.ellipse((float)(x), (float)(y), 10, 10);
		p.fill(0, 255, 0);
		p.ellipse((float)(x+1000*accel*Math.cos(angle)), (float)(y+1000*accel*Math.sin(angle)), 5, 5);
	}

}
