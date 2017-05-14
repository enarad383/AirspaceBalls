package gameplayObjects;

import java.util.ArrayList;

import functionality.*;
import processing.core.PApplet;

public class Projectile extends GameObject{
	
	private double accel;
	private double accelAngle;
	private double gravMult = 23.5;
	private ArrayList<Planet>planets;

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
		accel = 0;
		accelAngle = 0;
		planets = new ArrayList<Planet>();

	}
	
	/** Prepares the acceleration fields by collecting the net gravitational effect on the projectile.
	 * 
	 * @param planets The planets from which to collect gravity data.
	 */
	public void gatherForce(ArrayList<Planet> planets){
		this.planets = planets;
		double accelX = 0, accelY = 0;
		Sun sun = game.getSun();

		double tempaccel = 1*gravMult*(Physics.GRAVCONST*sun.getMass()/Math.pow(distanceTo(sun), 2));
		double tempAngle = getAngleTo(sun);
		accelX += tempaccel*Math.cos(tempAngle);
		accelY += tempaccel*Math.sin(tempAngle);
		for (Planet p: planets){ //PROBLEM: Can't seem to properly add forces at certain angles
			tempaccel = 2*gravMult*(Physics.GRAVCONST*p.getMass()/Math.pow(distanceTo(p), 2));
			tempAngle = getAngleTo(p);
			double cosine = distToX(p)/distanceTo(p);
			double sine = distToY(p)/distanceTo(p);
//			accelX += tempaccel*Math.cos(tempAngle);
//			accelY += tempaccel*Math.cos(tempAngle);
			accelX += tempaccel*cosine;
			accelY += tempaccel*sine;
			

		}
		
		accel = Math.sqrt(accelX*accelX + accelY*accelY);
		accelAngle = Math.atan(accelX/accelY)+Math.PI;
		if (accelX<0){
			accelAngle += Math.PI;
		}
		else if (accelY<0){
			accelAngle += 2*Math.PI;
		}
	}
	
	/** Tells the projectile to take one step, recalculating gravity and changing its velocity.
	 * 
	 * @param planets The planets from which to collect gravity data.
	 */
	public void orbit(ArrayList<Planet> planets){
		gatherForce(planets);
		changeVel(accel*Math.cos(accelAngle), accel*Math.sin(accelAngle));
		act();
	}
	
	@SuppressWarnings("static-access")
	/**Draws the projectile using Processing.
	 * 
	 */
	public void draw(PApplet p){
		p.ellipseMode(p.CENTER);
		p.stroke(255,100,0);
		p.fill(255,0,0);
		p.ellipse((float)(x), (float)(y), 10, 10);
		p.fill(0, 255, 0);
		p.stroke(255,255,0);
		p.strokeWeight(1);
		p.ellipse((float)(x+1000*accel*Math.cos(accelAngle)), (float)(y+1000*accel*Math.sin(accelAngle)), 5, 5);
		//p.line((float)x, (float)y, (float)(x+10000*accel*Math.cos(accelAngle)), (float)(y+10000*accel*Math.sin(accelAngle)));
		//Planet plan = planets.get(2);
		p.strokeWeight(1);
		/*
		for (Planet plan: planets){
			p.stroke (0, 50+10*(float)plan.getMass(), 100+5*(float)plan.getMass());
			p.line((float)x, (float)y, (float)plan.getX(), (float)plan.getY());
			p.stroke(100, 50+10*(float)plan.getMass(), 100+5*(float)plan.getMass());
			p.strokeWeight(3);
			if (Math.abs(Math.signum(Math.cos(getAngleTo(plan)))-Math.signum(Math.sin(getAngleTo(plan))))<0.1){
				p.line((float)x, (float)y, (float)x-(float)(100*Math.sin(getAngleTo(plan))), (float)y-(float)(100*Math.cos(getAngleTo(plan))));
			}
			else{
				p.line((float)x, (float)y, (float)x+(float)(100*Math.sin(getAngleTo(plan))), (float)y+(float)(100*Math.cos(getAngleTo(plan))));
			}
			p.strokeWeight(1);
		}
		*/
		p.stroke(0);
	}

}
