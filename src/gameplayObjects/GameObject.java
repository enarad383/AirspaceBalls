package gameplayObjects;

import functionality.*;
import processing.core.PApplet;

public class GameObject {
	int x, y;
	double velX, velY;
	double r, angle;
	int centX, centY;
	
	public GameObject(int x, int y, Game g){
		setPos(x, y);
		centX = g.getCentX();
		centY = g.getCentY();
	}
	
	public void setPosPolar(double rad, double theta){
		double newX, newY = 0;
		newX = centX+rad*Math.cos(theta);
		newY = centY+rad*Math.sin(theta);
		setPos((int)newX, (int)newY);
	}
	
	public void setPos(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void changePos(double x, double y){
		this.x += x;
		this.y += y;
	}
	
	public void setVel(double x, double y){
		this.velX = x;
		this.velY = y;
	}
	public void changeVel(double x, double y){
		this.velX += x;
		this.velY += y;
	}
	
	public void draw(PApplet p){
		
	}
	
}
