package gameplayObjects;

import functionality.*;

public class Planet extends GameObject {

	private double gravAccel;
	private double size;
	private double orbitHeight;
	private double orbitVel;
	private double angle;
	
	public Planet(double radius, double angle, Game g, double grav, double size) {
		super((int)(g.getCentX()+radius*Math.cos(angle)), (int)(g.getCentY()+radius*Math.cos(angle)), g);
		orbitHeight = radius;
		this.size = size;
		gravAccel = grav;
		orbitVel = Math.sqrt(Physics.GRAVCONST*g.getSun().getMass()/orbitHeight);
		this.angle = angle;
		setPosPolar(orbitHeight, angle);
	}
	
	public void orbit(){
		changePos(orbitVel*Math.cos(angle), orbitVel*Math.sin(angle));
		angle = Math.atan((x-centX)/(y-centY));
	}
	
	

}
