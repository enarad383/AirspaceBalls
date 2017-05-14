package gameplayObjects;

import functionality.*;
import processing.core.PApplet;

public class Planet extends GameObject {

	private double gravAccel;
	private double size;
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
		orbitVelAngular = 5*Math.sqrt(Physics.GRAVCONST*g.getSun().getMass()/Math.pow(orbitHeight, 3));
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
	
	public double getVel(){
		return orbitVelAngular*orbitHeight;
	}
	
	/**
	 * Draws the planet using Processing.
	 */
	public void draw(PApplet p){
		p.ellipseMode(p.CENTER);
		p.fill(200,200,150);
		p.ellipse((float)(x), (float)(y), (float)size, (float)size);
	}

}
