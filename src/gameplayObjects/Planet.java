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
		orbitVelAngular = Math.sqrt(Physics.GRAVCONST*g.getSun().getMass()/Math.pow(orbitHeight, 2));
		this.angle = angle;
		setPosPolar(orbitHeight, angle);
	}
	
	public void orbit(){
		angle += orbitVelAngular;
		setPosPolar(orbitHeight, angle);
	}
	
	public void draw(PApplet p){
		p.ellipseMode(p.CENTER);
		p.fill(200,200,150);
		p.ellipse(centX+(float)(x/Math.pow(10, 9)), centY+(float)(y/Math.pow(10, 9)), (float)size, (float)size);
	}

}
