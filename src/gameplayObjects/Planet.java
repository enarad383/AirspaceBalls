package gameplayObjects;

import functionality.*;
import processing.core.PApplet;

public class Planet extends GameObject {

	private double gravAccel;
	protected double size;
	private double orbitHeight;
	private double orbitVelAngular;
	private double angle;
	
	/**Creates a Planet object.
	 * 
	 * @param radius The distance at which the planet orbits the sun.
	 * @param angle The polar angle at which the planet starts.
	 * @param g The Game object in which it is created.
	 * @param grav The acceleration due to the gravity of the planet.
	 * @param size The visual size of the planet.
	 */
	public Planet(double radius, double angle, Game g, double grav, double size) {
		super((g.getCentX()+radius*Math.cos(angle)), (g.getCentY()+radius*Math.cos(angle)), g);
		orbitHeight = radius;
		this.size = size;
		gravAccel = grav;
		orbitVelAngular = 3.75*Math.sqrt(Physics.GRAVCONST*g.getSun().getMass()/Math.pow(orbitHeight, 3));
		this.angle = angle;
		setPosPolar(orbitHeight, angle);
	}
	
	/**Tells the planet to take one step forward. Planets are on rails, so it only rotates about the center.
	 * 
	 */
	public void orbit(){
		angle += orbitVelAngular;
		setPosPolar(orbitHeight, angle);
	}
	
	/**Gives the mass of the planet.
	 * 
	 * @return The mass of the planet.
	 */
	public double getMass(){
		return gravAccel;
	}
	
	/**
	 * 
	 * @return The planet's radius.
	 */
	public double getRadius(){
		return size;
	}
	
	/**
	 * 
	 * @return The velocity of the planet.
	 */
	public double getVel(){
		return orbitVelAngular*orbitHeight;
	}
	
	/**
	 * 
	 * @return The orbital velocity of the planet.
	 */
	public double getOrbVel(){
		return orbitVelAngular;
	}
	/**
	 * 
	 * @return The height at which the planet orbits.
	 */
	public double getR(){
		return orbitHeight;
	}
	
	/**
	 * @return X component of velocity
	 */
	public double getVelX(){
		return getVel()*Math.cos(angle+Math.PI/2);
	}
	
	/**
	 * 
	 * @return Y component of velocity
	 */
	public double getVelY(){
		return getVel()*Math.sin(angle+Math.PI/2);
	}
	
	/**Changes the angle by an amount
	 * 
	 * @param amt by which to change the angle
	 */
	public void incrementAngle(double amt){
		angle += amt;
	}
	
	/**Gets the angle of its orbit
	 * 
	 * @return angle of its orbit
	 */
	public double getAngle(){
		return angle;
	}
	
	/**
	 * Draws the planet using Processing.
	 */
	public void draw(PApplet p){
		p.ellipseMode(p.CENTER);
		p.strokeWeight(1);
		p.stroke(0);
		p.fill(200,150,100);
		p.ellipse((float)(x), (float)(y), (float)size, (float)size);
	}

}
