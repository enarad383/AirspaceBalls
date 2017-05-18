package gameplayObjects;

import java.io.Serializable;

import functionality.Game;
import processing.core.PApplet;

public class Cannon extends Planet implements Serializable{

	private double aimAngle;
	private double power;
	
	public Cannon(double radius, double angle, Game g, double aimAngle) {
		super(radius, angle, g, 1, 10);
		this.aimAngle = aimAngle;
		power = 3;
	}
	
	public void aim(boolean direction){
		if (direction){
			aimAngle += 0.05;
		}
		else{
			aimAngle -= 0.05;
		}
	}
	
	public void changePower(boolean direction){
		if (direction){
			power += 0.1;
		}
		else{
			power -= 0.1;
		}
	}
	
	public double getAimAngle(){
		return aimAngle;
	}
	
	public double getPower(){
		return power;
	}
	
	public void orbit(){
		aimAngle += getOrbVel();
		super.orbit();
	}
	
	public void draw(PApplet p){
		p.ellipseMode(p.CENTER);
		p.stroke(254);
		p.fill(50,50,254);
		p.ellipse((float)(x), (float)(y), (float)size, (float)size);
		double l = 20;
		double w = 3;	
		p.pushMatrix();
		p.translate((float)x, (float)y);
		p.rotate((float)aimAngle);
		p.rect((float)l/2, -(float)w/2, (float)l, (float)w);
		p.popMatrix();
		p.stroke(0);
		
	}

}
