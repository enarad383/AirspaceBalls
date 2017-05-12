package gameplayObjects;

import functionality.*;
import processing.core.PApplet;

public class Planet extends GameObject {

	private double gravAccel;
	private double size;
	private double orbitHeight;
	private double orbitVelAngular;
	private double angle;
	
	public Planet(double radius, double angle, Game g, double grav, double size) {
		super((g.getCentX()+radius*Math.cos(angle)), (g.getCentY()+radius*Math.cos(angle)), g);
		orbitHeight = radius;
		this.size = size;
		gravAccel = grav;
		orbitVelAngular = 5*Math.sqrt(Physics.GRAVCONST*g.getSun().getMass()/Math.pow(orbitHeight, 3));
		this.angle = angle;
		setPosPolar(orbitHeight, angle);
	}
	
	public void orbit(){
		angle += orbitVelAngular;
		setPosPolar(orbitHeight, angle);
	}
	
	public double getMass(){
		return gravAccel;
	}
	
	public void draw(PApplet p){
		p.ellipseMode(p.CENTER);
		p.fill(200,200,150);
		p.ellipse((float)(x), (float)(y), (float)size, (float)size);
	}

}
